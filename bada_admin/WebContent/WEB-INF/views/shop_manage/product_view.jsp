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
                  <h1>상품 정보</h1>
                </div>
                <table class="table table-bordered">
					<tr>
						<th class="info text-center" width="100">상품일련번호</th>
						<td>1</td>
					</tr>
					<tr>
						<th class="info text-center">상품명</th>
						<td>자바의 정석</td>
					</tr>
					<tr>
						<th class="info text-center">판매자</th>
						<td>문혁진</td>
					</tr>
					<tr>
						<th class="info text-center">판매가</th>
						<td>50,000 원</td>
					</tr>
					<tr>
						<th class="info text-center" style="vertical-align:middle;">이미지</th>
						<td><img class="thumbnail" src="../assets/img/profile.png" alt="프로필 이미지" width="150px" /></td>
					</tr>
					<tr>
						<th class="info text-center">등록일</th>
						<td>2016-10-10</td>
					</tr>
				</table>
				<div class="text-right">
					<a href="#" class="btn btn-primary">목록</a>
					<a href="#" class="btn btn-warning">수정</a>
					<a href="#" class="btn btn-danger">삭제</a>
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
