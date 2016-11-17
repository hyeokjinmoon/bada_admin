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
                <input type="text" name="user_id" id="user_id" class="form-control" placeholder="아이디" autofocus required>
                <label for="user_pw" class="sr-only">비밀번호</label>
                <input type="password" name="user_pw" id="user_pw" class="form-control" placeholder="비밀번호" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
            </form>
		</div>
        <!-- 컨테이너 끝 -->
        <!-- google analytics -->
<script>
	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
	
	ga('create', 'UA-85741327-1', 'auto');
	ga('send', 'pageview');
</script>
    </body>
</html>
