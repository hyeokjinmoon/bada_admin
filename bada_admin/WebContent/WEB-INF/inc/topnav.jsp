<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
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
            <a class="navbar-brand" href="#">BaDa
                <span class="small">ADMIN</span>
            </a>
        </div>
        <div class="navbar-right" style="margin-right: 50px;">
	    	<a href="#" class="dropdown-toggle navbar-link navbar-btn btn navbar-admin" data-toggle="dropdown">${loginInfo.name} 님 <span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="${pageContext.request.contextPath}/logout.do">로그아웃</a></li>
			</ul>
      	</div>
		<div id="navbar" class="navbar-collapse collapse">
        	<ul class="nav navbar-nav navbar-right">
        		<li>
        			<a href="#" class="dropdown-toggle navbar-link" data-toggle="dropdown">${loginInfo.name} 님 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/logout.do">로그아웃</a></li>
					</ul>
        		</li>
                <li>
                    <a href="${pageContext.request.contextPath}/board_manage/dashboard.do">대시보드</a>
                </li>
                <li>
                    <a href="#collapse-nav-item-shop" data-toggle="collapse">쇼핑몰 관리</a>
                    <ul class="nav navbar-nav-inner collapse" id="collapse-nav-item-shop">
                        <li>
                            <a href="${pageContext.request.contextPath}/shop_manage/orders_list.do">주문목록</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/shop_manage/trade_list.do">거래목록</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/shop_manage/product_list.do">상품목록</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/shop_manage/ok_request_list.do">승인요청목록</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/shop_manage/deposit_list.do">입금현황</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/shop_manage/delivery_list.do">배송현황</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#collapse-nav-item-board" data-toggle="collapse">게시판 관리</a>
                    <ul class="nav navbar-nav-inner collapse" id="collapse-nav-item-board">
                        <li>
                            <a href="${pageContext.request.contextPath}/board_manage/qna_list.do">1:1문의</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/board_manage/noti_faq_list.do?category=notice">공지사항</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/board_manage/noti_faq_list.do?category=faq">자주묻는질문</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#collapse-nav-item-member" data-toggle="collapse">회원 관리</a>
                    <ul class="nav navbar-nav-inner collapse" id="collapse-nav-item-member">
                        <li>
                            <a href="${pageContext.request.contextPath}/member_manage/member_list.do">회원목록</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/member_manage/message_list.do">쪽지목록</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- 로고, 상단 네비게이션 바 끝 -->
