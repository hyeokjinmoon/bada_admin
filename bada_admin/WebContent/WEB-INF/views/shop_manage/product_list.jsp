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
                  <h1>상품목록</h1>
                </div>
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead class="alert alert-info">
                            <tr>
                                <th class="text-center" width="20%">상품명</th>
                                <th class="text-center" width="10%">판매자</th>
                                <th class="text-center" width="10%">정가</th>
                                <th class="text-center" width="10%">판매가</th>
                                <th class="text-center" width="25%">등록일</th>
                                <th class="text-center" width="15%">승인상태</th>
                                <th class="text-center" width="10%">판매상태</th>
                             </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="product" items="${productList}">
                        		 <tr align="center">
									<td class="subject">
										<c:url var="productUrl" value="/shop_manage/product_view.do">
											<c:param name="id" value="${product.id}"/>
										</c:url>
										<a href="${productUrl}">${product.product_name}</a>
									</td>
	                                <td>${product.seller_name}</td>
	                                <td><span class="text-danger"><fmt:formatNumber value="${product.list_price}" groupingUsed="true"/></span> 원</td>
	                                <td><span class="text-info"><fmt:formatNumber value="${product.sale_price}" groupingUsed="true"/></span> 원</td>
	                                <td>${product.reg_date}</td>
	                                <td>
	                                	<c:choose>
			                             	<c:when test="${product.ok_status == 'O'}">
			                             		<span class="text-primary">승인</span>
			                             	</c:when>
			                             	<c:when test="${product.ok_status == 'W'}">
			                             		<span class="text-warning">승인대기</span>
			                             	</c:when>
			                             	<c:when test="${product.ok_status == 'R'}">
			                            		<span class="text-danger">거절</span>
			                            	</c:when>
			                             </c:choose>
	                                </td>
	                                <td>
	                                	<c:choose>
			                             	<c:when test="${product.product_status == 'S'}">
			                             		<span class="text-success">판매중</span>
			                             	</c:when>
			                             	<c:when test="${product.product_status == 'W'}">
			                             		<span class="text-warning">판매대기</span>
			                             	</c:when>
			                             	<c:when test="${product.product_status == 'C'}">
			                            		<span class="text-danger">판매완료</span>
			                            	</c:when>
			                             </c:choose>
	                                </td>
								</tr>
                        	</c:forEach>
                        </tbody>
                    </table>
				</div>
				<div class="text-right">
                	<a href="${pageContext.request.contextPath}/shop_manage/product_register.do" class="btn btn-info" >상품등록</a>
                </div>
                <!-- 페이지 번호 시작 -->
				<nav class="text-center">
					<ul class="pagination">
						<!-- 이전 그룹으로 이동 -->
						<c:choose>
							<c:when test="${pageHelper.prevPage > 0}">
								<!-- 이전 그룹에 대한 페이지 번호가 존재한다면? -->
								<!-- 이전 그룹으로 이동하기 위한 URL을 생성해서 "prevUrl"에 저장 -->
								<c:url var="prevUrl" value="/shop_manage/product_list.do">
									<c:param name="page" value="${pageHelper.prevPage}"></c:param>
								</c:url>
				
								<li><a href="${prevUrl}">&laquo;</a></li>
							</c:when>
				
							<c:otherwise>
								<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
								<li class='disabled'><a href="#">&laquo;</a></li>
							</c:otherwise>
						</c:choose>
							
						<!-- 페이지 번호 -->
						<!-- 현재 그룹의 시작페이지~끝페이지 사이를 1씩 증가하면서 반복 -->
						<c:forEach var="i" begin="${pageHelper.startPage}" end="${pageHelper.endPage}" step="1">
				
							<!-- 각 페이지 번호로 이동할 수 있는 URL을 생성하여 page_url에 저장 -->
							<c:url var="pageUrl" value="/shop_manage/product_list.do" >
								<c:param name="page" value="${i}"></c:param>
							</c:url>
								
							<!-- 반복중의 페이지 번호와 현재 위치한 페이지 번호가 같은 경우에 대한 분기 -->
							<c:choose>
								<c:when test="${pageHelper.page == i}">
									<li class='active'><a href="#">${i}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${pageUrl}">${i}</a></li>
								</c:otherwise>
							</c:choose>	
				
						</c:forEach>
							
						<!-- 다음 그룹으로 이동 -->
						<c:choose>
							<c:when test="${pageHelper.nextPage > 0}">
								<!-- 다음 그룹에 대한 페이지 번호가 존재한다면? -->
								<!-- 다음 그룹으로 이동하기 위한 URL을 생성해서 "nextUrl"에 저장 -->
								<c:url var="nextUrl" value="/shop_manage/product_list.do">
									<c:param name="page" value="${pageHelper.nextPage}"></c:param>
								</c:url>
				
								<li><a href="${nextUrl}">&raquo;</a></li>
							</c:when>
				
							<c:otherwise>
								<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
								<li class='disabled'><a href="#">&raquo;</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</nav>
				<!--// 페이지 번호 끝 -->
                <%@ include file="/WEB-INF/inc/footer.jsp" %>
                <!-- 작성 영역 끝 -->

            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->
</body>

</html>
