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
                  <h1>${boardName} &nbsp;<small> 수정</small></h1>
                </div>
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/board_manage/noti_faq_update_ok.do">
                	<input type="hidden" name="id" value="${noticeFaqUpdate.id}"/>
                	<input type="hidden" name="category" value="${category}"/>
                    <div class="form-group">
                        <label for="subject" class="col-md-2 text-right">제목</label>
                        <div class="col-md-8"><input type="text" name="subject" id="subject" class="form-control" value="${noticeFaqUpdate.subject}"></div>
                    </div>
                    <div class="form-group">
                        <label for="content" class="col-md-2 text-right">내용</label>
                        <div class="col-md-8">
                            <textarea name="content" id="content" rows="10" class="form-control ckeditor">${noticeFaqUpdate.content}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                                <div class="col-md-offset-2 col-md-8">
                                    <button type="submit" class="btn btn-info pull-right">수정완료</button>
                                </div>
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
