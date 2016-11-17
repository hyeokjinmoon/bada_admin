<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/views/inc/head.jsp" %>
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

            <%@ include file="/WEB-INF/views/inc/sidebar_info.jsp" %>

            <!-- 메인 컨텐츠 영역 시작 -->
            <div class="col-sm-9 col-md-10 main-content">
                <div class="page-header clearfix">
                    <h2>장바구니</h2>
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
				                		<td><input type="checkbox" name="cart_ids" value="${cart.id}" checked /></td>
				                		<td>
				                			<c:choose>
				                				<c:when test="${cart.product_img != null }">
						                			<c:url var="cartImg" value="/download.do">
						                				<c:param name="file" value="${cart.product_img}" />
						                			</c:url>
						                				<a href="${pageContext.request.contextPath}/shop/product_detail.do?id=${cart.product_id}"><img class="thumbnail" src="${cartImg }" width="150"/></a>
					                			</c:when>
					                			<c:otherwise>
					                				<img class="thumbnail" src="${pageContext.request.contextPath}/assets/img/basic_img.png" alt="상품 이미지" width="150" />
					                			</c:otherwise>
				                			</c:choose>
				                		</td>
				                		<td class="subject"><p>${cart.product_name}</p></td>
				                		<td><p><span class="text-danger"><fmt:formatNumber value="${cart.sale_price}" groupingUsed="true"/></span> 원</p></td>
				                		<td><p>${cart.reg_date}</p></td>
				                		<td>
				                			<p>
				                			<a data-toggle="popover" tabindex="0" data-html="true" data-container="body" data-toggle="popover"
			                    			   data-placement="bottom" 
			                    			   data-trigger="focus"
			                    			   data-content="<a href='${pageContext.request.contextPath}/member/message_answer.do?id=${cart.seller_id}'>쪽지보내기</a>">
				                			${cart.seller_name}</a>
				                			</p>
				                		</td>
				                	</tr>
				                </c:forEach>
				        	</c:otherwise>
		                </c:choose>		
                	</table>
                </div>
                <c:if test="${fn:length(cartList) != 0 }">
	                <div class="text-center">
		                <button type="button" class="btn btn-info" id="cart_orders">선택 상품 주문</button>
		                <button type="button" class="btn btn-danger" id="cart_delete">선택 상품 장바구니 삭제</button>
	                </div>
                </c:if>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->

        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
   	<script type="text/javascript">
   		$(function() {
   			/* 선택상품주문 */
   			$("#cart_orders").on('click', function(e) {
   				var $checked = $("input[name=cart_ids]:checked");
   				var cart_id = '';
   				$checked.each(function(){
   					cart_id += $(this).val() + ',';
   					
   					/* $.get('${pageContext.request.contextPath}/shop/cart_delete.do', {
   	   					cart_id : $(this).val()
   	   				}, function(res) {
   	   					if(res.rt != 'OK') {
   	   						swal(res.rt);
   	   						return false;
   	   					}
   	   					var cart_id = res.cart_id;
   	   					$("#cart_item_" + cart_id).remove();
   	   					
   	   				});	 */
   				});
   				window.location.href="${pageContext.request.contextPath}/shop/order_confirm.do?add_id=${loginInfo.id}&cart_id="+cart_id;
   				
   			});
   			
   			/* 선택상품삭제 */
   			$("#cart_delete").on('click', function(e) {
   				var $checked = $("input[name=cart_ids]:checked");
   				
   				$checked.each(function(index){
   					$.get('${pageContext.request.contextPath}/shop/cart_delete.do', {
   	   					cart_id : $(this).val()
   	   				}, function(res) {
   	   					if(res.rt != 'OK') {
   	   						swal(res.rt);
   	   						return false;
   	   					}
   	   					var cart_id = res.cart_id;
   	   					
	   					$("#cart_item_" + cart_id).remove();	
   	   					
   	   					
   	   				});	
   				});
   			});
   			
   		});
   	</script>
</body>

</html>
