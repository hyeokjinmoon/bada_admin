<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!-- 사이드 네비게이션 바 -->
<div class="col-sm-2 col-md-2 sidebar">
    <ul class="nav nav-sidebar">
        <li>
            <a href="${pageContext.request.contextPath}/board_manage/dashboard.do">대시보드</a>
        </li>
        <li>
            <a href="#collapse-item-shop" data-toggle="collapse">쇼핑몰 관리</a>
            <ul class="nav nav-sidebar-inner collapse" id="collapse-item-shop">
                <li>
                    <a href="${pageContext.request.contextPath}/shop_manage/order_list.do">주문목록</a>
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
            <a href="#collapse-item-board" data-toggle="collapse">게시판 관리</a>
            <ul class="nav nav-sidebar-inner collapse" id="collapse-item-board">
	            <li>
	                <a href="${pageContext.request.contextPath}/board_manage/qna_list.do">1:1문의</a>
	            </li>
	            <li>
	                <a href="${pageContext.request.contextPath}/board_manage/board_list.do">공지사항</a>
	            </li>
	            <li>
	                <a href="${pageContext.request.contextPath}/board_manage/board_list.do">자주묻는질문</a>
	            </li>
            </ul>
        </li>
        <li>
            <a href="#collapse-item-user" data-toggle="collapse">회원 관리</a>
            <ul class="nav nav-sidebar-inner collapse" id="collapse-item-user">
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
<!-- 사이트 네비게이션 바 끝 -->
