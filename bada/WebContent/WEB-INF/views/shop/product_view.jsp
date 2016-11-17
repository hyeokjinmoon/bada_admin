<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/views/inc/head.jsp" %>
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
                    <h2>판매 및 신청 내역 상세</h2>
                </div>
                <table class="table table-bordered">
					<tr>
						<th class="info text-center" width="100">상품명</th>
						<td>${product.product_name }</td>
					</tr>
					<tr>
						<th class="info text-center">카테고리</th><!-- 카테고리 : 미지정="E", 학문="S", 소설="N", 자기계발="D", 정기 간행물="M", 어린이 도서="C" -->
						<td>
							<c:choose>
                             	<c:when test="${product.category == 'E'}">
                             		<span class="text-primary">미지정</span>
                             	</c:when>
                             	<c:when test="${product.category == 'S'}">
                             		<span class="text-primary">학문</span>
                             	</c:when>
                             	<c:when test="${product.category == 'N'}">
                            		<span class="text-primary">소설</span>
                            	</c:when>
                            	<c:when test="${product.category == 'D'}">
                             		<span class="text-primary">자기계발</span>
                             	</c:when>
                             	<c:when test="${product.category == 'M'}">
                             		<span class="text-primary">정기 간행물</span>
                             	</c:when>
                             	<c:when test="${product.category == 'C'}">
                            		<span class="text-primary">어린이 도서</span>
                            	</c:when>
                             </c:choose>
						</td>
					</tr>
					<tr>
						<th class="info text-center">구매가</th>
						<td><span class="text-danger"><fmt:formatNumber value="${product.list_price}" groupingUsed="true"/></span> 원</td>
					</tr>
					<tr>
						<th class="info text-center">판매가</th>
						<td><span class="text-info"><fmt:formatNumber value="${product.sale_price}" groupingUsed="true"/></span> 원</td>
					</tr>
					<tr>
						<th class="info text-center" style="vertical-align:middle;">이미지</th>
						<td>
							<c:url var="imgUrl" value="/download.do">
								<c:param name="file" value="${product.product_img}"/>
							</c:url>
							<c:choose>
								<c:when test="${product.product_img == null }">
									<img class="thumbnail" src="${pageContext.request.contextPath}/assets/img/basic_img.png" alt="상품 이미지" width="150px"/>상품 이미지가 없습니다.
								</c:when>
								<c:otherwise>
									<img class="thumbnail" src="${imgUrl }" alt="상품 이미지" style="cursor: pointer;" width="150px"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th class="info text-center">등록일</th>
						<td>${product.reg_date }</td>
					</tr>
					<tr>
						<th class="info text-center">승인상태</th>
						<td>
							<c:choose>
                             	<c:when test="${product.ok_status == 'O'}">
                             		<span class="text-primary">승인</span>
                             	</c:when>
                             	<c:when test="${product.ok_status == 'W'}">
                             		<span class="text-warning">승인대기</span>
                             	</c:when>
                             	<c:when test="${product.ok_status == 'R'}">
                            		<span class="text-danger">승인거절</span>
                            	</c:when>
                             </c:choose>
						</td>
					</tr>
					<tr>
						<th class="info text-center">판매상태</th>
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
                            	<c:when test="${product.product_status == 'R'}">
                             		<span class="text-danger">판매거절</span>
                             	</c:when>
                             	
                             </c:choose>
						</td>
					</tr>
				</table>
				<a href="${pageContext.request.contextPath}/shop/sale_list.do" class="btn btn-primary">목록</a>
				<c:if test="${product.product_status == 'W' || product.product_status == 'S' }">
					<a href="${pageContext.request.contextPath}/shop/product_update.do?id=${product.id}" class="btn btn-warning">수정</a>
				</c:if>
				<a href="${pageContext.request.contextPath}/shop/product_delete.do?id=${product.id}" class="btn btn-danger">삭제</a>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->

        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    
</body>

</html>
