<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
			<!-- 좌측 사이드 네비게이션 바 -->
            <div class="col-sm-3 col-md-2 side-menu">
                <h4 class="list-title text-info"><i class="fa fa-book" aria-hidden="true"></i> 카테고리</h4>
                <ul class="nav nav-side-menu">
                	<li id="A"><a href="${pageContext.request.contextPath}/shop/search.do?category=A">전체</a></li>
                    <li id="S"><a href="${pageContext.request.contextPath}/shop/search.do?category=S">학문</a></li>
                    <li id="N"><a href="${pageContext.request.contextPath}/shop/search.do?category=N">소설</a></li>
                    <li id="D"><a href="${pageContext.request.contextPath}/shop/search.do?category=D">자기계발</a></li>
                    <li id="M"><a href="${pageContext.request.contextPath}/shop/search.do?category=M">정기 간행물</a></li>
                    <li id="C"><a href="${pageContext.request.contextPath}/shop/search.do?category=C">어린이 도서</a></li>
                </ul>
                <h4 class="list-title text-info"><i class="fa fa-pencil" aria-hidden="true"></i> 게시판</h4>
                <ul class="nav nav-side-menu">
                    <li id="notice"><a href="${pageContext.request.contextPath}/board/notice_faq_list.do?category=notice">공지사항</a></li>
                    <li id="faq"><a href="${pageContext.request.contextPath}/board/notice_faq_list.do?category=faq">자주묻는 질문</a></li>
                </ul>
            </div>
            <!-- 좌측 사이드 네비게이션 바 끝 -->
            <script type="text/javascript">
            $(function() {
				//active 클래스 부여 (현재 페이지의 이름과 li의 아이디 값이 같은 항목에 active 클래스 부여)
        		
				var pgurl =  window.location.href.substring(window.location.href.lastIndexOf("=")+1);
        		
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