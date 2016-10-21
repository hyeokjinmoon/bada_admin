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
                  <h1>상품 등록</h1>
                </div>
                <p class="col-md-offset-2 text-warning">*은 필수 입력입니다.</p>
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/shop_manage/product_register_ok.do" enctype="multipart/form-data">
                	<input type="hidden" name="seller_id" value="${loginInfo.id}"/>
                    <div class="form-group">
                        <label for="name" class="col-md-2">도서명*</label>
                        <div class="col-md-8"><input type="text" name="name" id="name" class="form-control"></div>
                    </div>
                    <div class="form-group">
                        <label for="list_price" class="col-md-2">정가*</label>
                        <div class="col-md-4"><input type="number" name="list_price" id="list_price" class="form-control"></div>
                    </div>
                    <div class="form-group">
                        <label for="sale_price" class="col-md-2">판매가*</label>
                        <div class="col-md-4">
                            <input type="number" name="sale_price" id="sale_price" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="book_img" class="col-md-2">도서 이미지</label>
                        <div class="col-md-8">
                            <input type="file" name="book_img" id="book_img" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-8 text-right">
                            <button type="submit" class="btn btn-info" >상품등록</button>
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
