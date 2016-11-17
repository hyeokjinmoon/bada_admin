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
                    <h2>주문/배송조회</h2>
                </div>
                <div class="table table-responsive">
                	<table class="table table-hover">
                		<thead>
                			<tr class="bg-primary">
                				<th class="text-center">상품이미지</th>
                				<th class="text-center">상품명</th>
                				<th class="text-center">판매자</th>
                				<th class="text-center">결제금액</th>
                				<th class="text-center">결제일</th>
                				<th class="text-center">배송상황</th>
                			</tr>
                		</thead>
                		<c:choose>
                			<c:when test="${fn:length(cartList) == 0 }">
                       			<tr align="center"  valign="middle">
                       				<td colspan="4" height="150">
                       					<h4>구매 내역이 없습니다.</h4>
                       				</td>
                       			</tr>
                       		</c:when>
                       		<c:otherwise>
		                		<c:forEach var="cart" items="${cartList}">
		                			<c:forEach var="order" items="${orderList}">
		                				<c:if test="${cart.order_id == order.id }">
						                	<tr align="center" id="cart_item_${cart.id}">
						                		<td>
						                			<c:choose>
						                				<c:when test="${cart.product_img != null }">
								                			<c:url var="cartImg" value="/download.do">
								                				<c:param name="file" value="${cart.product_img}" />
								                			</c:url>
								                				<a href="${pageContext.request.contextPath}/shop/product_detail.do?id=${cart.product_id}"><img class="thumbnail" src="${cartImg }" width="150"/></a>
							                			</c:when>
							                			<c:otherwise>
							                				<img class="thumbnail" src="${pageContext.request.contextPath}/assets/img/basic_img.png" alt="상품 이미지" width="150"/>
							                			</c:otherwise>
						                			</c:choose>
						                		</td>
						                		<td class="subject"><p>${cart.product_name}</p></td>
						                		<td>
						                			<p>
						                				<a data-toggle="popover" tabindex="0" data-html="true" data-container="body" data-toggle="popover"
						                    			   data-placement="bottom" 
						                    			   data-trigger="focus"
						                    			   data-content="<a href='${pageContext.request.contextPath}/member/message_answer.do?id=${cart.seller_id}'>쪽지보내기</a>">
							                			${cart.seller_name}</a>
						                			</p>
						                		</td>
						                		<td><p><span class="text-danger"><fmt:formatNumber value="${cart.sale_price}" groupingUsed="true"/></span> 원</p></td>
						                		<td><p>${order.order_date}</p></td>
						                		<td>
						                			<c:choose>
						                				<c:when test="${order.delivery_status == 'W'}">
						                					<p class="text-warning">배송대기</p>			
						                				</c:when>
						                				<c:when test="${order.delivery_status == 'S'}">
						                					<p class="text-warning">배송중</p>			
						                				</c:when>
						                				<c:when test="${order.delivery_status == 'C'}">
						                					<p class="text-warning">배송완료</p>			
						                				</c:when>
													</c:choose>				                		
						                		</td>
						                	</tr>
						                </c:if>
				                	</c:forEach>
				                </c:forEach>
				        	</c:otherwise>
		                </c:choose>		
                	</table>
            	</div>
            <!-- 메인 컨텐츠 영역 끝 -->

        	</div>
        <!-- Grid Row 끝 -->
        
		</div>
        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    
</body>

</html>
