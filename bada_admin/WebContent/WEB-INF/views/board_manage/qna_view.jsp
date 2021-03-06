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
                  <h1>1:1문의 &nbsp;&nbsp;<small>글 번호 : ${qna.id}</small></h1>
                </div>
                
                <div class="panel panel-info">
                    <div class="panel-heading clearfix">
                        <h3 class="panel-title pull-left">${qna.subject }</h3>
                        <div class="text-right">
                        	<span>작성자 : ${qna.request_name} &nbsp;&nbsp;</span>
                        	<span>${qna.reg_date}</span>
                        </div>
                    </div>
                    <div class="panel-body" style="min-height: 200px;">
                    ${qna.content}
                    </div>
                    <c:choose>
	                    <c:when test="${qna.answer != null}">
		                    <div class="panel-footer">
		                    	<p>답변자 : ${qna.answer_name}</p>
		                    	<p>${qna.answer}</p>
							</div>
						</c:when>
					</c:choose>
                </div>
                <div class="text-right">
	                <a href="${pageContext.request.contextPath}/board_manage/qna_list.do" class="btn btn-primary">목록</a>
	                <a href="${pageContext.request.contextPath}/board_manage/qna_answer.do?id=${qna.id}&answer_status=${qna.answer_status}" class="btn btn-info">답변하기</a>
	                <a href="${pageContext.request.contextPath}/board_manage/qna_update.do?id=${qna.id}&answer_status=${qna.answer_status}" class="btn btn-warning">답변수정</a>
	                <a href="${pageContext.request.contextPath}/board_manage/qna_delete.do?id=${qna.id}" class="btn btn-danger">삭제</a>
                </div>
                <%@ include file="/WEB-INF/inc/footer.jsp" %>
                <!-- 작성 영역 끝 -->
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->

</body>

</html>
