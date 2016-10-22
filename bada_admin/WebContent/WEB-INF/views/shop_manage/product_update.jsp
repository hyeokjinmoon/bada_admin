<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                  <h1>상품 수정</h1>
                </div>
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/shop_manage/product_update_ok.do" enctype="multipart/form-data">
                	<input type="hidden" name="id" value="${product.id}"/>
                	<div class="form-group">
                        <label for="product_name" class="col-md-2 text-right">도서명</label>
                        <div class="col-md-8"><input type="text" name="product_name" id="product_name" class="form-control" value="${product.name}"></div>
                    </div>
                    <div class="form-group">
                        <label for="list_price" class="col-md-2 text-right">정가</label>
                        <div class="col-md-4"><input type="number" name="list_price" id="list_price" class="form-control" value="${product.list_price }"></div>
                    </div>
                    <div class="form-group">
                        <label for="sale_price" class="col-md-2 text-right">판매가</label>
                        <div class="col-md-4">
                            <input type="number" name="sale_price" id="sale_price" class="form-control" value="${product.sale_price }">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="product_img" class="col-md-2 text-right">도서 이미지</label>
                        <div class="col-md-8">
                        	<c:url var="imgUrl" value="/download.do">
								<c:param name="file" value="${product.product_img }"/>
							</c:url>
                        	<c:choose>
								<c:when test="${product.product_img == null }">
									<img class="thumbnail" src="${pageContext.request.contextPath}/assets/img/basic_img.png" alt="상품 이미지" width="150px"/>
								</c:when>
								<c:otherwise>
									<img class="thumbnail" src="${imgUrl }" alt="프로필 이미지" style="cursor: pointer;" width="200px"/>
								</c:otherwise>
							</c:choose>
                        	<input type="file" name="product_img" id="product_img" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-8 text-right">
                            <button type="submit" class="btn btn-info" >수정완료</button>
                        </div>
                    </div>
                </form>
                <%@ include file="/WEB-INF/inc/footer.jsp" %>
                <!-- 작성 영역 끝 -->

            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->
</body>

</html>
