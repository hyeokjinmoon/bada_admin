<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>BaDa Admin</title>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common_admin.css">
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.2/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>

<body>

    <!-- 로고, 상단 네비게이션 바 -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">메뉴 열기</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
                <a class="navbar-brand" href="#">BaDa <span class="small">ADMIN</span></a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="#">대시보드</a></li>
                    <li><a href="#collapse-nav-item-shop" data-toggle="collapse">쇼핑몰 관리</a>
                        <ul class="nav navbar-nav-inner collapse" id="collapse-nav-item-shop">
                            <li><a href="#">회원주문내역</a></li>
                            <li><a href="#">거래내역</a></li>
                            <li><a href="#">상품등록(바다)</a></li>
                            <li><a href="#">승인요청관리</a></li>
                            <li><a href="#">주문/입금/베송관리</a></li>
                        </ul>
                    </li>
                    <li><a href="#collapse-nav-item-board" data-toggle="collapse">게시판 관리</a>
                        <ul class="nav navbar-nav-inner collapse" id="collapse-nav-item-board">
                            <li><a href="#">1:1문의 관리</a></li>
                            <li><a href="#">공지사항 관리</a></li>
                            <li><a href="#">자주묻는 질문 관리</a></li>
                        </ul>
                    </li>
                    <li><a href="#collapse-nav-item-user" data-toggle="collapse">회원 관리</a>
                        <ul class="nav navbar-nav-inner collapse" id="collapse-nav-item-user">
                            <li><a href="#">회원 정보</a></li>
                            <li><a href="#">판매자 평</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- 로고, 상단 네비게이션 바 끝 -->

    <!-- 컨테이너 영역 -->
    <div class="container">
        <!-- 사이드 네비게이션 바 -->
        <div class="col-sm-2 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">대시보드</a></li>
                <li><a href="#collapse-item-shop" data-toggle="collapse">쇼핑몰 관리</a>
                    <ul class="nav nav-sidebar-inner collapse" id="collapse-item-shop">
                        <li class="active"><a href="#">회원주문내역</a></li>
                        <li><a href="#">거래내역</a></li>
                        <li><a href="#">상품등록(바다)</a></li>
                        <li><a href="#">승인요청관리</a></li>
                        <li><a href="#">주문/입금/베송관리</a></li>
                    </ul>
                </li>
                <li><a href="#collapse-item-board" data-toggle="collapse">게시판 관리</a>
                    <ul class="nav nav-sidebar-inner collapse" id="collapse-item-board">
                        <li><a href="#">1:1문의 관리</a></li>
                        <li><a href="#">공지사항 관리</a></li>
                        <li><a href="#">자주묻는 질문 관리</a></li>
                    </ul>
                </li>
                <li><a href="#collapse-item-user" data-toggle="collapse">회원 관리</a>
                    <ul class="nav nav-sidebar-inner collapse" id="collapse-item-user">
                        <li><a href="#">회원 정보</a></li>
                        <li><a href="#">판매자 평</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- 사이트 네비게이션 바 끝 -->
        <div class="row">
            <!-- 메인 컨텐츠 영역 -->
            <div class="col-sm-offset-2 col-md-offset-2 main-content">

                <!-- 작성 영역 -->
                <div class="page-header">
                  <h1>제목</h1>
                </div>
                <!-- 작성 영역 끝 -->
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
