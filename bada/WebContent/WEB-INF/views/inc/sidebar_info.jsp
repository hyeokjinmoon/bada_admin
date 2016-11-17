<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
			<!-- 좌측 사이드 네비게이션 바 -->
            <div class="col-sm-3 col-md-2 side-menu">
                <ul class="nav nav-side-menu list-title">
                    <li id="my_info.do"><a href="${pageContext.request.contextPath}/member/my_info.do">내정보</a></li>
                    <li id="info_edit.do"><a href="${pageContext.request.contextPath}/member/info_edit.do">정보수정</a></li>
                    <li id="cart_list.do"><a href="${pageContext.request.contextPath}/shop/cart_list.do?add_id=${loginInfo.id}">장바구니</a></li>
                    <li id="order_list.do"><a href="${pageContext.request.contextPath}/shop/order_list.do">주문/배송 조회</a></li>
                    <li id="receive_message_list.do"><a href="${pageContext.request.contextPath}/member/receive_message_list.do">받은 쪽지함</a></li>
                    <li id="send_message_list.do"><a href="${pageContext.request.contextPath}/member/send_message_list.do">보낸 쪽지함</a></li>
                </ul>
                <ul class="nav nav-side-menu list-title">
                    <li id="product_regist.do"><a href="${pageContext.request.contextPath}/shop/product_regist.do">회원에게 판매신청</a></li>
                    <li id="sale_request_list.do"><a href="${pageContext.request.contextPath}/member/sale_request_list.do">바다에 판매신청</a></li>
                    <li id="sale_list.do"><a href="${pageContext.request.contextPath}/shop/sale_list.do">판매 및 신청 내역</a></li>
                </ul>
                <ul class="nav nav-side-menu list-title">
                    <li id="qna_list.do"><a href="${pageContext.request.contextPath}/board/qna_list.do">1:1 문의</a></li>
                    <li id="out.do"><a href="${pageContext.request.contextPath}/member/out.do?id=${loginInfo.id}">탈퇴하기</a></li>
                </ul>
            </div>
            <!-- 좌측 사이드 네비게이션 바 끝 -->
            <script type="text/javascript">
            	$(function() {
					//active 클래스 부여 (현재 페이지의 이름과 li의 아이디 값이 같은 항목에 active 클래스 부여)
            		var lastIndex = window.location.href.lastIndexOf("?")+1;
            		var pgurl;
            		if(lastIndex == 0) {
            			pgurl =  window.location.href.substring(window.location.href.lastIndexOf("/")+1);
            		} else {
            			pgurl =  window.location.href.substring(window.location.href.lastIndexOf("/")+1, window.location.href.lastIndexOf("?"));
            		}
            		
            		$(".side-menu li").each(function() {
            			if(pgurl == $(this).attr("id")) {
            				$(this).addClass('active');
            			}	
            		});
            		
            		$(window).scroll(function() {
                        $(".side-menu").animate({"top": $(this).scrollTop()}, {queue: false, ducation: 30, easing: "linear"});
            		});
            	});
            </script>