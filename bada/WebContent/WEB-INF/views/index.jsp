<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/views/inc/head.jsp" %>
    
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css" />
  	<style type="text/css">
  		.autocomplete-suggestions { border: 1px solid #3399FF; background: #FFF; overflow: auto; }
		.autocomplete-suggestion { padding: 2px 5px; white-space: nowrap; overflow: hidden; }
		.autocomplete-selected { background: #F0F0F0; }
		.autocomplete-suggestions strong { font-weight: normal; color: #3399FF; }
  	</style>
</head>

<body>
	<div class="top-menu">
		<c:choose>
			<c:when test="${loginInfo != null }">
				<a href="${pageContext.request.contextPath}/member/my_info.do" style="text-decoration:none;"><strong class="text-info">마이페이지</strong></a>&nbsp;|&nbsp;
				<a href="${pageContext.request.contextPath}/logout.do" style="text-decoration:none;"><strong class="text-danger">로그아웃</strong></a>
			</c:when>
			<c:otherwise>
				<a href="" data-toggle="modal" data-target=".modal" style="text-decoration:none;"><strong class="text-info">로그인</strong></a>&nbsp;|&nbsp;
				<a href="${pageContext.request.contextPath}/member/join.do" style="text-decoration:none;"><strong class="text-warning">회원가입</strong></a>
			</c:otherwise>
		</c:choose>
	</div>
    
    <div class="container">
		<!-- Grid Row 시작 -->
        <div class="row">
			
            <!-- 메인 컨텐츠 영역 시작 -->
            <div class="cover text-center hero">
	            <form method="get" action="${pageContext.request.contextPath}/shop/search.do" id="search_form">
	            	<input type="hidden" name="category" value="A" />
	            	<h3 id="description" style="color: #2372b5;"></h3>
	            	<h1 class="logo"><strong><a style="text-decoration : none;" href="${pageContext.request.contextPath}/shop/main.do" id="logo"></a></strong></h1>
	            	<input type="text" class="form-control" placeholder="검색어를 입력해주세요." name="keyword" id="search"/>
	            </form>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->

        </div>
        <!-- Grid Row 끝 -->
    </div>
    <!-- .modal -->
	<div class="modal fade" tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title text-primary" id="gridSystemModalLabel">로그인</h4>
	      </div>
	      <form action="${pageContext.request.contextPath}/login_ok.do" class="form-horizontal" method="post" id="login_form">
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
	
	<script src="${pageContext.request.contextPath}/assets/js/jquery.typist.min.js"></script>
	<script type="text/javascript">
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
   		
   		$("#description").on('end_type.typist', function() {
   			$("#logo").typist({
   	   			speed : 10,
   	   			text : 'BADA'
   	   		});
   		}).typist({
   			speed : 10,
   			cursor : false,
   			text : '바꿔 읽고 다시 읽자!'
   		});
   		
    });
	</script>
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
