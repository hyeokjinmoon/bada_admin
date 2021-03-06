<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/inc/head.jsp" %>
</head>

<body>

    <%@ include file="/WEB-INF/inc/topnav.jsp" %>
    <!-- 컨테이너 영역 -->
    <div class="container">
        <%@ include file="/WEB-INF/inc/sidenav.jsp" %>
        <div class="row">
            <!-- 메인 컨텐츠 영역 -->
            <div class="col-sm-offset-2 col-md-offset-2 main-content">

                <!-- 작성 영역 -->
                <div class="page-header">
                  <h1>${boardName} &nbsp;&nbsp;<small>글 번호 : ${noticeFaqView.id}</small></h1>
                </div>
                
                <div class="panel panel-success">
                    <div class="panel-heading clearfix">
                        <h3 class="panel-title pull-left">${noticeFaqView.subject}</h3>
                        <span class="pull-right">최종수정일 : ${noticeFaqView.edit_date}</span>
                    </div>
                    <div class="panel-body" style="min-height: 200px;">
                    	${noticeFaqView.content}
                    </div>
                    <div class="panel-footer clearfix">
                    	<c:choose>
	                    	<c:when test="${prevNoticeFaqView != null}">
	                    		<a href="${pageContext.request.contextPath}/board_manage/noti_faq_view.do?category=${category}&id=${prevNoticeFaqView.id}" class="pull-left">&laquo; 이전 글</a>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<span class="pull-left">이전 글이 없습니다.</span>
	                    	</c:otherwise>
                    	</c:choose>
                    	<c:choose>
	                    	<c:when test="${nextNoticeFaqView != null}">
	                    		<a href="${pageContext.request.contextPath}/board_manage/noti_faq_view.do?category=${category}&id=${nextNoticeFaqView.id}" class="pull-right">다음 글 &raquo;</a>
	                    	</c:when>
	                    	<c:otherwise>
	                    		<span class="pull-right">다음 글이 없습니다.</span>
	                    	</c:otherwise>
                    	</c:choose>
                    </div>
                </div>
                <div class="text-right">
	                <a href="${pageContext.request.contextPath}/board_manage/noti_faq_list.do?category=${category}" class="btn btn-primary">목록</a>
	                <a href="${pageContext.request.contextPath}/board_manage/noti_faq_update.do?category=${category}&id=${noticeFaqView.id}" class="btn btn-warning">수정</a>
	                <a href="${pageContext.request.contextPath}/board_manage/noti_faq_delete.do?category=${category}&id=${noticeFaqView.id}" class="btn btn-danger">삭제</a>
                </div>
                <!-- 작성 영역 끝 -->
                <%@ include file="/WEB-INF/inc/footer.jsp" %>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->
    
</body>

</html>
