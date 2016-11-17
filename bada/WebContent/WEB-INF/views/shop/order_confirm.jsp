<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/views/inc/head.jsp" %>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.form.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/additional-methods.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/ajax_helper.js"></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.2.js"></script>
    <style type="text/css">
   		.table td {
   			vertical-align: middle !important;
   		}
   	</style>
</head>

<body>

    <%@ include file="/WEB-INF/views/inc/topnav.jsp" %>

    <div class="container">

        <!-- Grid Row 시작 -->
        <div class="row">

            <%@ include file="/WEB-INF/views/inc/sidebar_shop.jsp" %>

            <!-- 메인 컨텐츠 영역 시작 -->
            <div class="col-sm-9 col-md-10 main-content">
                <div class="page-header clearfix">
                    <h2>주문하기</h2>
                </div>
                <div class="table table-responsive">
                	<table class="table table-hover">
                		<c:choose>
                			<c:when test="${fn:length(cartList) == 0 }">
                       			<tr align="center"  valign="middle">
                       				<td colspan="4" height="150">
                       					<h4>장바구니 목록이 없습니다.</h4>
                       				</td>
                       			</tr>
                       		</c:when>
                       		<c:otherwise>
		                		<c:forEach var="cart" items="${cartList}" varStatus="status">
				                	<tr align="center" id="cart_item_${cart.id}">
				                		<td>
				                			<c:choose>
				                				<c:when test="${cart.product_img != null }">
						                			<c:url var="cartImg" value="/download.do">
						                				<c:param name="file" value="${cart.product_img}" />
						                			</c:url>
						                				<a href="${pageContext.request.contextPath}/shop/product_detail.do?id=${cart.product_id}"><img src="${cartImg }" alt="" width="200"/></a>
					                			</c:when>
					                			<c:otherwise>
					                				<img class="img-thumbnail" src="${pageContext.request.contextPath}/assets/img/basic_img.png" alt="상품 이미지"/>
					                			</c:otherwise>
				                			</c:choose>
				                		</td>
				                		<td class="subject"><p>${cart.product_name}</p></td>
				                		<td><p><span class="text-danger"><fmt:formatNumber value="${cart.sale_price}" groupingUsed="true"/></span> 원</p></td>
				                		<td><p>${cart.reg_date}</p></td>
				                		<td><p>${cart.seller_name}</p></td>
				                	</tr>
				                </c:forEach>
				        	</c:otherwise>
		                </c:choose>		
                	</table>
                </div>
                <div class="text-center">
                	<h2>결제 금액 : <span class="text-danger"> <fmt:formatNumber value="${total_price}" groupingUsed="true"/></span> 원</h2>
                </div>
                <div class="page-header">
                	<h3>주문정보</h3>
                </div>
                <form action="${pageContext.request.contextPath}/shop/order_confirm_ok.do" class="form-horizontal" id="payment">
                	<input type="hidden" name="order_id" value="${order_id}"/>
                	<input type="hidden" name="buyer_id" value="${loginInfo.id}"/>
                	<input type="hidden" name="product_id" value="${product_id}"/>
                	<input type="hidden" name="cart_id" value="${cart_id}"/>
                	<input type="hidden" name="payment_price" value="${total_price}"/>
                	<div class="form-group">
		                <label class="col-md-2">결제방법</label>
		                <div class="col-md-8">
			                <div class="radio-inline">
				                <label>
				                	<input type="radio" name="payment_type" class="" value="P">현금
				                </label>
			                </div>
			                <div class="radio-inline">
				                <label>
				                	<input type="radio" name="payment_type" class="" value="C">카드
				                </label>
			                </div>
		                </div>
		            </div>
                	<div class="form-group">
		                <label for="buyer_name" class="col-md-2">주문자명</label>
		                <div class="col-md-8"><input type="text" name="buyer_name" id="buyer_name" class="form-control" value="${loginInfo.name}"></div>
		            </div>
		            <div class="form-group">
		                <label for="buyer_tel" class="col-md-2">연락처</label>
		                <div class="col-md-8"><input type="tel" name="buyer_tel" id="buyer_tel" class="form-control" value="${loginInfo.tel}"></div>
		            </div>
                	<div class="form-group">
		                <label for="postcode" class="col-md-2">우편번호</label>
		                <div class="col-md-8 clearfix">
		                    <input type="text" name="postcode" id="postcode" class="form-control pull-left" style="width:100px !important;margin-right: 5px;" value="${loginInfo.postcode}">
		                    <input type="button" value="우편번호 찾기" class="btn btn-warning" onclick='execDaumPostcode("postcode", "addr1", "addr2");'>
		                </div>
		            </div>
		            <div class="form-group">
		                <label for="addr1" class="col-md-2">주소</label>
		                <div class="col-md-8"><input type="text" name="addr1" id="addr1" class="form-control" value="${loginInfo.addr1}"></div>
		            </div>
		            <div class="form-group">
		                <label for="addr2" class="col-md-2">상세주소</label>
		                <div class="col-md-8"><input type="text" name="addr2" id="addr2" class="form-control" value="${loginInfo.addr2}"></div>
		            </div>
		            <div class="form-group">
		                <div class="text-center">
		                    <button type="submit" class="btn btn-primary btn-lg">결제</button>
		                </div>
		            </div>
                </form>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->

        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    <script type="text/javascript">
    	$(function() {
    		$("#payment").validate({
    			onkeyup: false,
    			onclick: false,
    			onfocusout: false,
    			showErrors: function(errorMap, errorList) {
    				if(errorList.length < 1) {
    					return;
    				}
    				swal(errorList[0].message);
    			},
    			// 검사 규칙 정의
    			rules: {
    				payment_type : "required",
    				buyer_name : "required",
    				buyer_tel : "required",
    				postcode : "required",
    				addr1 : "required",
    				addr2 : "required",
    			},
    			// 검사 조건을 충족하지 않을 경우의 메시지 내용
    			messages: {
    				payment_type : "결제방법을 선택해주세요.",
    				buyer_name : "이름을 입력해주세요.",
    				buyer_tel : "연락처를 입력해주세요.",
    				postcode : "주소를 입력해주세요.",
    				addr1 : "주소를 입력해주세요.",
    				addr2 : "주소를 입력해주세요.",
    			}
    		});
    		
    		$("#payment").ajaxForm({
    			beforeSubmit : function (arr, form, options) {
    				// validation 플러그인을 수동으로 호출하여 결과를 리턴한다.
    				// 검사규칙에 위배되어 false가 리턴될 경우 submit을 중단한다.
            		return $(form).valid();
        		},
        		success : function(res) {
        			if(res.rt != 'OK') {
        				swal(res.rt);
        				return null;
        			}
        			swal({
                        title: "결제완료",
                        text: "결제되었습니다.",
                        type: "info",
                        confirmButtonClass: "btn-info",
                        confirmButtonText: "확인",
                        closeOnConfirm: true
	                },
	                function(){
	                        window.location.href="${pageContext.request.contextPath}/shop/order_list.do";
	                });
        		}
    		});
    	});
    </script>
    
</body>

</html>
