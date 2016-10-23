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
                    <h1>대시보드</h1>
                </div>
                <div class="row">
                	<div class="col-md-6">
						<div class="panel panel-info">
							<!-- Default panel contents -->
							<div class="panel-heading">
								<strong>회원목록</strong>
								<a href="${pageContext.request.contextPath}/member_manage/member_list.do" class="pull-right">더보기</a>
							</div>
							
							<!-- Table -->
							<table class="table table-hover">
								<thead>
									
									<tr>
										<th class="text-center" width="20%">회원번호</th>
										<th class="text-center" width="40%">이름</th>
										<th class="text-center" width="40%">가입일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="member" items="${memberList}">
										<tr align="center">
											<td>${member.id}</td>
											<td>${member.name}</td>
											<td>${member.reg_date}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel panel-info">
							<!-- Default panel contents -->
							<div class="panel-heading">
								<strong>상품목록</strong>
								<a href="${pageContext.request.contextPath}/shop_manage/product_list.do" class="pull-right">더보기</a>
							</div>
							<!-- Table -->
							<table class="table table-hover">
								<thead>
									<tr>
										<th class="text-center" width="20%">상품번호</th>
										<th class="text-center" width="40%">상품명</th>
										<th class="text-center" width="40%">등록일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="product" items="${productList}">
										<tr align="center">
											<td>${product.id}</td>
											<td>${product.product_name}</td>
											<td>${product.reg_date}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="row">
                	<div class="col-md-6">
						<div class="panel panel-info">
							<!-- Default panel contents -->
							<div class="panel-heading">
								<strong>주문목록</strong>
								<a href="${pageContext.request.contextPath}/shop_manage/orders_list.do" class="pull-right">더보기</a>
							</div>
							<!-- Table -->
							<table class="table table-hover">
								<thead>
									<tr>
										<th class="text-center" width="20%">주문번호</th>
										<th class="text-center" width="25%">입금현황</th>
										<th class="text-center" width="25%">배송현황</th>
										<th class="text-center" width="30%">주문일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="orders" items="${ordersList}">
										<tr align="center">
											<td>${orders.id}</td>
											<td>
												<c:choose>
				                             	<c:when test="${orders.deposit_status == 'W'}">
				                             		<span class="text-warning">입금대기</span>
				                             	</c:when>
				                             	<c:when test="${orders.deposit_status == 'C'}">
				                            		<span class="text-danger">입금완료</span>
				                            	</c:when>
				                             </c:choose>
											</td>
											<td>
												<c:choose>
					                             	<c:when test="${orders.delivery_status == 'S'}">
					                             		<span class="text-success">배송중</span>
					                             	</c:when>
					                             	<c:when test="${orders.delivery_status == 'W'}">
					                             		<span class="text-warning">배송대기</span>
					                             	</c:when>
					                             	<c:when test="${orders.delivery_status == 'C'}">
					                            		<span class="text-danger">배송완료</span>
					                            	</c:when>
					                             </c:choose>
											</td>
											<td>${orders.order_date}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel panel-info">
							<!-- Default panel contents -->
							<div class="panel-heading">
								<strong>1:1문의</strong>
								<a href="${pageContext.request.contextPath}/board_manage/qna_list.do" class="pull-right">더보기</a>
							</div>
							<!-- Table -->
							<table class="table table-hover">
								<thead>
									<tr>
										<th class="text-center" width="20%">문의번호</th>
										<th class="text-center" width="40%">제목</th>
										<th class="text-center" width="40%">등록일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="qna" items="${qnaList}">
										<tr align="center">
											<td>${qna.id}</td>
											<td>${qna.subject}</td>
											<td>${qna.reg_date}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
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
