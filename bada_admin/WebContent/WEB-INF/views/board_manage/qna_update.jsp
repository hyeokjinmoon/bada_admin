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
                  <h1>1:1문의 답변 수정 &nbsp;&nbsp;<small>글 번호 : ${qna.id}</small></h1>
                </div>
                
                <div class="panel panel-danger">
                    <div class="panel-heading clearfix">
                        <h3 class="panel-title pull-left">${qna.subject}</h3>
                        <div class="text-right">
                        	<span>작성자 : ${qna.request_name} &nbsp;&nbsp;</span>
                        	<span>${qna.reg_date}</span>
                        </div>
                    </div>
                    <div class="panel-body" style="min-height: 200px;">
                    ${qna.content}
                    </div>
                </div>
                <form action="${pageContext.request.contextPath}/board_manage/qna_update_ok.do">
                	<input type="hidden" name="id" value="${qna.id}" />
	                <div class="form-group clearfix">
	                	<textarea name="answer" id="answer" cols="30" rows="10" class="ckeditor">${qna.answer}</textarea>
	                </div>
	                <div class="text-right">
			                <a href="${pageContext.request.contextPath}/board_manage/qna_list.do" class="btn btn-primary">목록</a>
			                <button type="submit" class="btn btn-warning">수정완료</button>
			                <button type="reset" class="btn btn-danger" onclick="history.back();">취소</button>
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
