<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <%@ include file="/WEB-INF/inc/head.jsp" %>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css">
    </head>
    <body>
        <!-- 로고, 상단 네비게이션 바 -->
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="">BaDa
                        <span class="small">ADMIN</span>
                    </a>
                </div>
            </div>
        </nav>
        <!-- 로고, 상단 네비게이션 바 끝 -->

        <!-- 컨테이너 영역 -->
        <div class="container">

            <form class="form-login" method="post" action="${pageContext.request.contextPath}/login_ok.do">
                <h2 class="form-login-heading text-center">BaDa ADMIN</h2>
                <label for="user_id" class="sr-only">아이디</label>
                <input type="text" name="user_id" id="user_id" class="form-control" placeholder="아이디">
                <label for="user_pw" class="sr-only">비밀번호</label>
                <input type="password" name="user_pw" id="user_pw" class="form-control" placeholder="비밀번호">
                <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
            </form>
		</div>
        <!-- 컨테이너 끝 -->
    </body>
</html>