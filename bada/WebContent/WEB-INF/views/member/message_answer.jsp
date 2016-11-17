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

            <%@ include file="/WEB-INF/views/inc/sidebar_info.jsp" %>

            <!-- 메인 컨텐츠 영역 시작 -->
            <div class="col-sm-9 col-md-10 main-content">
                <div class="page-header clearfix">
                    <h2>쪽지쓰기</h2>
                </div>
                <form class="form-horizontal" id="regi-form" method="post" action="${pageContext.request.contextPath}/member/message_answer_ok.do">
                    <input type="hidden" name="receiver_id" value="${receiver_id}"/>
                    <div class="form-group">
                        <label for="receiver_user_id" class="col-md-2">받는 사람</label>
                        <div class="col-md-8"><p>${receiver_name}</p></div>
                    </div>
                    <div class="form-group">
                        <label for="list_price" class="col-md-2">내용</label>
                        <div class="col-md-8">
                        	<textarea name="content" id="content" class="ckeditor"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-8">
                            <button type="submit" class="btn btn-primary">쪽지보내기</button>
                        </div>
                    </div>
                </form>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->

        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    
</body>

</html>
