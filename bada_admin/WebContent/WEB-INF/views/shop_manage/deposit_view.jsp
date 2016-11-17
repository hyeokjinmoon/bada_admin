<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/inc/head.jsp" %>
</head>

<body>

    <%@ include file="/WEB-INF/inc/topnav.jsp" %>

    <!-- 컨테이너 영역 -->
    <div class="container">
        <%@ include file="/WEB-INF/inc/sidenav.jsp" %>
        <div class="row">
            <!-- 메인 컨텐츠 영역 -->
            <div class="col-sm-offset-2 col-md-offset-2 main-content">

                <!-- 작성 영역 -->
                <div class="page-header">
                  <h1>입금 현황 상세</h1>
                </div>
                <table class="table table-bordered">
					<tr>
						<th class="info text-center" width="100">주문자 이름</th>
						<td>${orders.buyer_name}</td>
					</tr>
					<tr>
						<th class="info text-center">주문자 연락처</th>
						<td>${orders.buyer_tel}</td>
					</tr>
					<tr>
						<th class="info text-center">주문자 주소</th>
						<td>${orders.buyer_addr}</td>
					</tr>
					<tr>
						<th class="info text-center">주문금액</th>
						<td><span class="text-danger"><fmt:formatNumber value="${orders.payment_price}" groupingUsed="true"/></span> 원</td>
					</tr>
					<tr>
						<th class="info text-center">주문일시</th>
						<td>${orders.order_date }</td>
					</tr>
					<tr>
						<th class="info text-center">입금상황</th>
						<td>
							<c:choose>
                             	<c:when test="${orders.deposit_status == 'W'}">
                             		<span class="text-success">입금대기</span>
                             	</c:when>
                             	<c:when test="${orders.deposit_status == 'C'}">
                            		<span class="text-danger">입금완료</span>
                            	</c:when>
                             </c:choose>
						</td>
					</tr>
				</table>
				<div class="text-right">
					<a href="${pageContext.request.contextPath}/shop_manage/deposit_list.do" class="btn btn-primary">목록</a>
					<c:if test="${orders.deposit_status == 'W'}">
           		   		<a href="${pageContext.request.contextPath}/shop_manage/deposit_update.do?id=${orders.id}&deposit_status=C" class="btn btn-danger">입금완료</a>	
                    </c:if>
				</div>
				<%@ include file="/WEB-INF/inc/footer.jsp" %>
                <!-- 작성 영역 끝 -->
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->
</body>

</html>
