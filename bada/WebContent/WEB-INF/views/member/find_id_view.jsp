<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/views/inc/head.jsp" %>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ajax_helper.css">
	
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/daumPostCode.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.form.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/additional-methods.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/ajax_helper.js"></script>
    
</head>

<body>

   <%@ include file="/WEB-INF/views/inc/topnav.jsp" %>
    <div class="container">

        <div class="page-header col-md-offset-3 col-md-6 clearfix">
            <h2>아이디 확인</h2>
        </div>
        <div class="row">
	        <div class="col-md-offset-3 col-md-6">
	        	<h3>회원님의 아이디는 <strong class="text-info">${user_id}</strong>입니다.</h3>
	        </div>
		</div>
		<div class="col-md-offset-3 col-md-6">
       <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
       </div>
    </div>
</body>

</html>
