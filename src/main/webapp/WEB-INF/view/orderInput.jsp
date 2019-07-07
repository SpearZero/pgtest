<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/order.css">
</head>
<body>
	<div class="container">
	<form action="/order" method="post">
		<fieldset>
			<legend>주문정보 입력</legend>
			<div class="row">
				<div class="col-25">
					<label for="buyer_name">구매자 이름  </label>
				</div>
				<div class="col-75">
					<input type="text" id="buyer_name" name="buyer_name" placeholder="구매자 이름" required 
							value="${orderDTO.buyer_name}"/>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="buyer_tel">연락처  </label>
				</div>
				<div class="col-75">
					<input type="text" id="buyer_tel" name="buyer_tel" placeholder="구매자 연락처 (-)포함 입력"
						 pattern="01[016789]-[1-9]{1}[0-9]{2,3}-[0-9]{4}" maxlength="13" value="${orderDTO.buyer_tel}" />
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="buyer_email">이메일  </label>
				</div>			
				<div class="col-75">
					<input type="email" id="buyer_email" name="buyer_email" placeholder="구매자 이메일" required
							value="${orderDTO.buyer_email}"/>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="buyer_address">주소  </label>
				</div>
				<div class="col-75">
					<input type="text" id="buyer_address" name="buyer_address" placeholder="구매자 주소" required
							value="${orderDTO.buyer_address}"/>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="buyer_postal">우편번호  </label>
				</div>
				<div class="col-75">
					<input type="text" id="buyer_postal" placeholder="우편번호 5자리"  pattern="\d{5}" name="buyer_postal" required
							value="${orderDTO.buyer_postal}"/>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="merchant_name">상품 이름  </label>
				</div>
				<div class="col-75">
					<input type="text" id="merchandise_name" name="merchandise_name" placeholder="상품 이름" required
							value="${orderDTO.merchant_name}"/>
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="merchant_price">금액(원) </label>
				</div>
				<div class="col-75">
					<input type="number" id="merchandise_price" name="merchandise_price" placeholder="상품 금액" min="0" required
							value="${orderDTO.merchant_price}"/>
				</div>
			</div>
			<div class="row">
				<div class="col-10">
					<input type="radio" name="pay_method" value="card" required/>신용카드
				</div>
				<div class="col-10">
					<input type="radio" name="pay_method" value="trans"/>실시간 계좌이체
				</div>
				<div class="col-10">
					<input type="radio" name="pay_method" value="vbank"/>가상계좌
				</div>
				<div class="col-10">
					<input type="radio" name="pay_method" value="phone"/>휴대폰소액결제
				</div>
			</div>
			<div class="row">
				<input type="submit" value="주문" />
			</div>
		</fieldset>
	</form>
	</div>
</body>
</html>