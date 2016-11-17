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

            <%@ include file="/WEB-INF/views/inc/sidebar_shop.jsp" %>

            <!-- 메인 컨텐츠 영역 시작 -->
            <div class="col-sm-9 col-md-10 main-content">
                <div class="page-header clearfix">
                    <c:choose>
                		<c:when test="${category == 'notice' }">
	                    <h2>공지사항</h2>
	                    </c:when>
	                    <c:when test="${category == 'faq' }">
	                    <h2>자주묻는 질문</h2>
	                    </c:when>
                    </c:choose>
                </div>
                <div class="panel panel-primary">
					<div class="panel-heading clearfix">
						<h3 class="panel-title pull-left">${noticeFaqView.subject }</h3>
						<p class="pull-right">${noticeFaqView.reg_date}</p>
					</div>
					<div class="panel-body" style="min-height: 200px;">
						${noticeFaqView.content}
					</div>
					<ul class="list-group">
						<li class="list-group-item">${noticeFaqView.admin_name}</li>
					</ul>
				</div>
				<a href="${pageContext.request.contextPath}/board/notice_faq_list.do?category=${category}" class="btn btn-primary">목록</a>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->

        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    
</body>

</html>
