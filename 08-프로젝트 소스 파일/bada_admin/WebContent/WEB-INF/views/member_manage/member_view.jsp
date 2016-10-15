<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
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
                  <h1>회원정보</h1>
                </div>
                <table class="table table-bordered">
					<tr>
						<th class="info text-center" width="100">회원일련번호</th>
						<td>1</td>
					</tr>
					<tr>
						<th class="info text-center">이름</th>
						<td>문혁진</td>
					</tr>
					<tr>
						<th class="info text-center">아이디</th>
						<td>moonhyeokjin</td>
					</tr>
					<tr>
						<th class="info text-center">이메일</th>
						<td>moonhyeokjin@email.com</td>
					</tr>
					<tr>
						<th class="info text-center">주소</th>
						<td>(12345)서울시 강남구 역삼동 123-12</td>
					</tr>
					<tr>
						<th class="info text-center">연락처</th>
						<td>01012341234</td>
					</tr>
					<tr>
						<th class="info text-center">가입일</th>
						<td>2016-10-10</td>
					</tr>
					<tr>
						<th class="info text-center">정보수정일</th>
						<td>2016-10-10</td>
					</tr>
				</table>
				<div class="text-right">
					<a href="#" class="btn btn-primary">목록</a>
					<a href="#" class="btn btn-warning">수정</a>
					<a href="#" class="btn btn-danger">삭제</a>
				</div>
                <!-- 작성 영역 끝 -->
                <%@ include file="/WEB-INF/inc/footer.jsp" %>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->
</body>

</html>
