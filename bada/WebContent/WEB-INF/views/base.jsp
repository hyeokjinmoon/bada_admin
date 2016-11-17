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

            <!-- 좌측 사이드 네비게이션 바 -->
            <div class="col-sm-3 col-md-2 side-menu">
                <h5 class="list-title text-info"><i class="fa fa-book" aria-hidden="true"></i> 카테고리</h5>
                <ul class="nav nav-side-menu">
                	<li class="active"><a href="#">전체</a></li>
                    <li><a href="#">학문</a></li>
                    <li><a href="#">소설</a></li>
                    <li><a href="#">자기계발</a></li>
                    <li><a href="#">정기 간행물</a></li>
                    <li><a href="#">어린이 도서</a></li>
                </ul>
                <h5 class="list-title text-info"><i class="fa fa-pencil" aria-hidden="true"></i> 사이트 관련</h5>
                <ul class="nav nav-side-menu">
                    <li><a href="#">공지사항</a></li>
                    <li><a href="#">자주묻는 질문</a></li>
                </ul>
            </div>
            <!-- 좌측 사이드 네비게이션 바 끝 -->

            <!-- 메인 컨텐츠 영역 시작 -->
            <div class="col-sm-9 col-md-10 main-content">
                <div class="page-header clearfix">
                    <h2>제목</h2>
                </div>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->

        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    
</body>

</html>
