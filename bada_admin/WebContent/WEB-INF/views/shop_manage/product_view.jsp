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
                  <h1>상품 정보</h1>
                </div>
                <table class="table table-bordered">
					<tr>
						<th class="info text-center" width="100">상품일련번호</th>
						<td>${product.id }</td>
					</tr>
					<tr>
						<th class="info text-center">상품명</th>
						<td>${product.name }</td>
					</tr>
					<tr>
						<th class="info text-center">판매자</th>
						<td>${product.seller_name }</td>
					</tr>
					<tr>
						<th class="info text-center">정가</th>
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
								<c:param name="file" value="${product.book_img }"/>
							</c:url>
							<c:choose>
								<c:when test="${product.book_img == null }">
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
                             		<span class="text-success">승인대기</span>
                             	</c:when>
                             	<c:when test="${product.ok_status == 'R'}">
                            		<span class="text-danger">거절</span>
                            	</c:when>
                             </c:choose>
						</td>
					</tr>
				</table>
				<div class="text-right">
					<a href="${pageContext.request.contextPath}/shop_manage/product_list.do" class="btn btn-primary">목록</a>
					<a href="${pageContext.request.contextPath}/shop_manage/product_update.do?id=${product.id}" class="btn btn-warning">수정</a>
					<a href="${pageContext.request.contextPath}/shop_manage/product_delete.do?id=${product.id}" class="btn btn-danger">삭제</a>
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
