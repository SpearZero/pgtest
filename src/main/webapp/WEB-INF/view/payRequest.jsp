<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결제 페이지</title>
</head>
<script src="/resources/jquery-3.3.1.js"></script>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script>
<body>
	<script>
		IMP.init('imp39204256');
		IMP.request_pay({
		    pg : 'nice',
		    pay_method : '${orderDTO.pay_method}',
		    merchant_uid : '${orderDTO.merchandise_uid}',
		    name : '${orderDTO.merchandise_name}',
		    amount : ${orderDTO.merchandise_price},
		    buyer_email : '${orderDTO.buyer_email}',
		    buyer_name : '${orderDTO.buyer_name}',
		    buyer_tel : '${orderDTO.buyer_tel}',
		    buyer_addr : '${orderDTO.buyer_address}',
		    buyer_postcode : '${orderDTO.buyer_postal}'
		}, function(rsp) {
		    if ( rsp.success ) {
		    	var form = {
		    		imp_uid : rsp.imp_uid,
		    		merchant_uid : rsp.merchant_uid
		    	}
		    	
		    	jQuery.ajax({
		    		url : "/payments/complete",
		    		method : "post",
		    		type : "json",
		    		contentType : "application/json",
		    		data : JSON.stringify(form)
		    	}).done(function(data) {
		    		if(data.status === 'success') {
		    			var msg = '결제가 완료되었습니다.';
				        msg += '고유ID : ' + rsp.imp_uid;
				        msg += '상점 거래ID : ' + rsp.merchant_uid;
				        msg += '결제 금액 : ' + rsp.paid_amount;
				        msg += '카드 승인번호 : ' + rsp.apply_num;
				        alert(msg);
		    		} else {
		    			alert(data);
		    		}
		    		
		    		location.href = "/order";
		    	})
		    } else {
		        var msg = '결제에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;
		    }
		});
	</script>
</body>
</html>