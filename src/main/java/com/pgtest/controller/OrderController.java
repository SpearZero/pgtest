package com.pgtest.controller;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.pgtest.dto.CancelDTO;
import com.pgtest.dto.MerchandiseDTO;
import com.pgtest.dto.OrderDTO;
import com.pgtest.dto.OrderIdDTO;
import com.pgtest.dto.OrderValidator;
import com.pgtest.dto.OrdererDTO;
import com.pgtest.dto.PaidResultDTO;
import com.pgtest.dto.PayDTO;
import com.pgtest.service.MerchandiseService;
import com.pgtest.service.OrdererService;
import com.pgtest.service.PayService;
import com.pgtest.util.UsingImPortAPI;

@Controller
public class OrderController {
	
	@Autowired
	private MerchandiseService merchandiseService;
	@Autowired
	private OrdererService ordererService;
	@Autowired
	private PayService payService;
	
	private UsingImPortAPI api = new UsingImPortAPI();
	
	@GetMapping("/order")
	public String order() {
		return "orderInput";
	}
	
	@PostMapping("/order")
	public String requestPay(OrderDTO dto, Model model) {
		boolean validResult = new OrderValidator().validator(dto);
		model.addAttribute("orderDTO", dto);
		
		if(!validResult) {
			return "orderInput";
		}
		
		// 상품 ID 생성,저장 후 반환
		dto.setMerchandise_uid(merchandiseService.getGeneratedMerchandiseUid());
		
		// 회원 존재 여부 체크(없으면 입력함) -> 인조키, 이름, 전화번호, 이메일, 주소, 우편번호 
		boolean exist = ordererService.isOrdererExist(dto.getBuyer_email());
		if(!exist) {
			OrdererDTO ordererDTO = new OrdererDTO(dto.getBuyer_name(), dto.getBuyer_tel(), 
					dto.getBuyer_email(), dto.getBuyer_address(), dto.getBuyer_postal());
			int result = ordererService.insertOrderer(ordererDTO);
		}
		
		// DB에 결제되어야 할 금액 저장 -> /payments/complete에서 검증
		merchandiseService.insertMerchandisePrice(dto.getMerchandise_uid(), dto.getMerchandise_price());
		return "payRequest";
	}
	
	@PostMapping("/payments/complete")
	@ResponseBody
	public JsonObject showPaymentResult(@RequestBody OrderIdDTO dto) {
		Gson gson = new Gson();
		String token = api.getToken();
		JsonObject result = api.getPaymentData(dto.getImp_uid(), token).get("response").getAsJsonObject();
		
		OrdererDTO ordererDTO = gson.fromJson(result, OrdererDTO.class);
		PayDTO payDTO = gson.fromJson(result, PayDTO.class);
		MerchandiseDTO mDTO = gson.fromJson(result, MerchandiseDTO.class);
		String status = result.get("status").getAsString();
		
		String merchandiseId = result.get("merchant_uid").getAsString();
		// DB와 아임포트에서의 금액 비교
		Long amountBePaid = result.get("amount").getAsLong();
		Long amount = merchandiseService.getMerchandisePrice(merchandiseId);
		
		if(amountBePaid.equals(amount)) {
			// 상품 정보 저장, pay(결제사, 방법), orderer(주문자) 관계 설정 
			int orderer = ordererService.getOrdererNum(ordererDTO.getBuyer_email());
			int pay = payService.getPayNumber(payDTO.getPg_provider(), payDTO.getPay_method());
			mDTO.setPay(pay);
			mDTO.setOrderer(orderer);
			
			merchandiseService.insertMerchandiseInfo(mDTO);
		}
		
		JsonObject statusResult = makeStatus(status);

		return statusResult;
	}
	
	private JsonObject makeStatus(String status) {
		JsonObject result = new JsonObject();
		
		if(status.equals("paid")) {
			result.addProperty("status", "success");
			result.addProperty("message", "일반결제 성공");
		} else if(status.equals("ready")) {
			result.addProperty("status", "vbankIssued");
			result.addProperty("message", "가상계좌 발급 성공");
		} else if(status.equals("cancelled")) {
			result.addProperty("status", "cancel");
			result.addProperty("message", "결제 취소");
		} else if(status.equals("failed")){
			result.addProperty("status", "fail");
			result.addProperty("message", "결제 실패");
		}
		
		return result;
	}
	
	@GetMapping("/payResults")
	public String hi2() {
		
		return "payResults";
	}
	
	@PostMapping(value = "/results", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public String payResults(@RequestBody String email) {
		List<PaidResultDTO> dto = merchandiseService.getPaidResults(email);
		
		String jsonText = new Gson().toJson(dto);
		return jsonText;
	}
	
	@PostMapping(value = "/payments/cancel", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public JsonObject cancel(@RequestBody CancelDTO dto) {
		String token = api.getToken();
		
		// UsingImPortAPI에서 환불 요청하는 부분작성
		MerchandiseDTO mdto = merchandiseService.getMerchandiseUsingImpUid(dto.getImp_uid());
		JsonObject result = api.cancelPayment(dto, token).get("response").getAsJsonObject();
		
		// 결제 번호 / 취소사유
		String imp_uid = result.get("imp_uid").getAsString();
		String status = result.get("status").getAsString();
		String reason = result.get("cancel_history").getAsJsonArray().get(0).getAsJsonObject().get("reason").getAsString();
		
		// 트랜잭션(상품번호 얻고, 환불 정보 업데이트)
		if(status.equals("cancelled")) {
			int refundResult = merchandiseService.insertRefundInfo(imp_uid, reason);
		}
		
		JsonObject statusResult = new JsonObject();
		statusResult = makeStatus(status);
		
		return statusResult;
	}
}