<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
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
                  <h1>1:1문의 답변 &nbsp;&nbsp;<small>글 번호 : ${qna.id}</small></h1>
                </div>
                
                <div class="panel panel-success">
                    <div class="panel-heading clearfix">
                        <h3 class="panel-title pull-left">${qna.subject}</h3>
                        <span class="pull-right">${qna.reg_date}</span>
                        <span class="pull-right">작성자 : ${qna.request_name} &nbsp;&nbsp;</span>
                    </div>
                    <div class="panel-body" style="min-height: 200px;">
                    ${qna.content}
                    </div>
                </div>
                <form action="${pageContext.request.contextPath}/board_manage/qna_answer_ok.do" method="post">
                	<input type="hidden" name="id" value="${qna.id}"/>
                	<div class="form-group">
	                	<textarea name="answer" id="answer" cols="30" rows="10" class="ckeditor"></textarea>
	                </div>
	                <div class="text-right">
		                <a href="${pageContext.request.contextPath}/board_manage/qna_list.do" class="btn btn-primary">목록</a>
		                <button type="submit" class="btn btn-info">답변완료</button>
		                <button type="reset" class="btn btn-warning" onclick="history.back();">취소</button>
		            </div>
	            </form>
                <%@ include file="/WEB-INF/inc/footer.jsp" %>
                <!-- 작성 영역 끝 -->
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 --> 
</body>

</html>
