<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<!-- 로고, 상단 네비게이션 바 -->
    <nav class="navbar navbar-topbar navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar">
              <span class="sr-only">메뉴 열기</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/shop/main.do">BaDa</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">

                <form class="navbar-form navbar-left" method="get" action="${pageContext.request.contextPath}/shop/search.do" id="search_form">
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-btn">
                            	<input type="hidden" name="category" id="category" value="A" />
                                <button type="button" class="btn btn-default dropdown-toggle dropdown-btn" data-toggle="dropdown"><span data-bind="label">전체</span>&nbsp;<span class="caret"></span></button>
                                <ul class="dropdown-menu">
									<li><a id="A" data-value="A">전체</a></li>
                                    <li><a id="S" data-value="S">학문</a></li>
                                    <li><a id="N" data-value="N">소설</a></li>
                                    <li><a id="D" data-value="D">자기계발</a></li>
                                    <li><a id="M" data-value="M">정기 간행물</a></li>
                                    <li><a id="C" data-value="C">어린이 도서</a></li>
                                </ul>
                            </div>
                            <!-- /btn-group -->
                            <input type="text" class="form-control top-input" placeholder="검색 할 도서명을 입력해주세요." id="search" name="keyword">
                        </div>
                        <!-- /input-group -->
                    </div>
                </form>
                <div class="btn-group navbar-right">
                	<c:choose>
                		<c:when test="${loginInfo != null }">
		                    <a href="${pageContext.request.contextPath}/member/my_info.do" class="btn btn-info navbar-btn"><span class="glyphicon glyphicon-user"></span> 마이페이지</a>
		                    <a href="${pageContext.request.contextPath}/logout.do" class="btn btn-danger navbar-btn"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a>
	                    </c:when>
	                    <c:otherwise>
	                    <button class="btn btn-warning navbar-btn" data-toggle="modal" data-target=".modal"><span class="glyphicon glyphicon-log-in"></span> 로그인</button>
		                    <a href="${pageContext.request.contextPath}/member/join.do" class="btn btn-info navbar-btn"><span class="glyphicon glyphicon-user"></span> 회원가입</a>
	                    </c:otherwise>
                    </c:choose>
                </div>

                <!-- 모바일에서 보여질 메뉴 시작 -->
                <ul class="nav navbar-nav navbar-right navbar-menu">
                    <li><a href="#">학문</a></li>
                    <li><a href="#">소설</a></li>
                    <li><a href="#">자기계발</a></li>
                    <li><a href="#">정기 간행물</a></li>
                    <li><a href="#">어린이 도서</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right navbar-menu">
                    <li><a href="#">공지사항</a></li>
                    <li><a href="#">자주묻는 질문</a></li>
                    <li><a href="#">1:1 문의</a></li>
                </ul>
                <!-- 모바일에서 보여질 메뉴 끝 -->
            </div>
        </div>
    </nav>
    
    <!-- .modal -->
	<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	      
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title text-primary" id="gridSystemModalLabel">로그인</h4>
	      </div>
	      <form action="${pageContext.request.contextPath}/login_ok.do" class="form-horizontal" method="post">
	      <div class="modal-body">
	        	<div class="form-group">
	        		<div class="col-md-3">
		            	<label for="user_id">아이디</label>
		            </div>
		            <div class="col-md-9">
			        	<input type="text" id="user_id" name="user_id" class="form-control" placeholder="아이디를 입력하세요." required autofocus>
			        </div>
		        </div>
		        <div class="form-group">
		        	<div class="col-md-3">
			        	<label for="user_pw">비밀번호</label>
			        </div>
			        <div class="col-md-9">
			        	<input type="password" id="user_pw" name="user_pw" class="form-control" placeholder="비밀번호를 입력하세요." required>
			        </div>
	        	</div>
	      </div>
	      <div class="modal-footer clearfix">
	      	<div class="pull-left">
		        <button type="submit" class="btn btn-primary login">로그인</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
	        </div>
	        <div class="pull-right">
	        	<a href="${pageContext.request.contextPath}/member/find_id.do">ID</a> | <a href="">PW</a> 찾기
	        </div>
	      </div>
	      </form>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	
	<!-- dropdown control -->
	<script type="text/javascript">
         $(document.body).on('click', '.dropdown-menu li', function(event) {
        	$("#category").val($(this).find("a").data('value'));
			var $target = $(event.currentTarget);
			$target.closest('.input-group-btn').find('[data-bind="label"]').text($target.text()).end().children('.dropdown-toggle').dropdown('toggle');
			
			return false;
		 });
         
         $(function() {
        	 $("#search").keypress(function(event) {
        		    if (event.which == 13) {
        		        event.preventDefault();
        		        $("#search_form").submit();
        		    }
        	 });
        	 
        	 $('#search').autocomplete({
       			serviceUrl : '${pageContext.request.contextPath}/shop/autocomplete.do',
       		    onSelect: function (suggestion) {
       		    	$(this).val(suggestion.value);
       		    }
       		 });
         });
         
    </script>
    <!-- 로고, 상단 네비게이션 바 끝 -->