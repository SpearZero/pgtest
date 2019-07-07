<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/result.css" />
</head>
<body>
<div class="container">
        <div class="row">
            <div class="col-25">
                <label for="buyer_email">구매자 메일 : </label>
            </div>
            <div class="col-50">
                <input type="email" id="buyer_email" name="buyer_email" placeholder="구매자 이메일" required />
            </div>
            <div class="col-25">
                <input type="submit" value="조회" id="check">
            </div>
        </div>
    </div>
    <div class="container result">
        <div class="row info">
            <div class="col-25">
                <b>상품번호</b>
            </div>
            <div class="col-25">
                <b>상품이름</b>
            </div>
            <div class="col-25">
                <b>가격</b>
            </div>
            <div class="col-25">
                <b>결제취소</b>
            </div>
        </div>
		<div class="row results">
			
		</div>		
    </div>
    <script src="/resources/jquery-3.3.1.js"></script>
    <script>
        $(document).ready(function(){
            $("#check").click(function(){
                let email = $("#buyer_email").val();
                let emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

                if(!emailRule.test(email)) {
                    alert("메일 형식에 맞지 않습니다.");
                    return false;
                }
                
                $.ajax({
                	url : "results",
                	method : "post",
                	type : "json",
                	contentType : "application/json",
                	data : email
                }).done(function(data) {
                	$(".results").html("");
                	
                	let resultDom = "";
                	for(let i = 0; i < data.length; i++) {
                        resultDom += '<div class="row" id = ' +  data[i].imp_uid +' data-id=' + data[i].imp_uid + ' data-amount=' + data[i].amount + 
                        ' data-mid=' + data[i].merchant_uid  + '>';
                        resultDom +=   '<div class="col-25">' + data[i].merchandise_num + '</div>';
                        resultDom +=   '<div class="col-25">' + data[i].name + '</div>';
                        resultDom +=   '<div class="col-25">' + data[i].amount + '</div>';
                        if(data[i].status === 'cancelled') {
                        	resultDom +=   '<div class="col-25"><input type="button" value="취소됨" class="payResult" disabled></div>';
                        } else {
	                        resultDom +=   '<div class="col-25"><input type="button" value="취소" class="payResult"></div>';
                        }
                        resultDom +='</div>';
                	} 
                	$(".results").html(resultDom);
                })
                
            });
           
            $(document).on('click','.payResult', function(){
                var info = $(this).closest("div").parent();
				
                let form = {
                	"imp_uid" : info.data("id"),
                	"merchant_uid" : info.data("mid"),
                	"amount" : info.data("amount"),
                	"reason" : "테스트 결제 환불",
                	"tax_free" : 0,
                	"checksum" : info.data("amount"),
                }
                
                $.ajax({
                	url : "/payments/cancel",
                	method : "post",
                	type : "json",
                	contentType : "application/json",
                	data : JSON.stringify(form)
                }).done(function(data) {
                	alert(data.status + " : " + data.message);
                	
                	location.href = "/payResults";
                }) 
            })
        })
    </script>
</body>
</html>