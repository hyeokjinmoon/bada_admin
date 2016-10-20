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
                  <h1>쪽지 작성</h1>
                </div>
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/member_manage/message_write_ok.do">
                    <input type="hidden" name="sender_id" value="${loginInfo.id}"/>
                    <input type="hidden" name="receiver_id" value="${receiver_id}"/>
                    <div class="form-group">
                        <label for="receiver_id" class="col-md-2">받는 사람</label>
                        <div class="col-md-8"><p>${receiver_name}</p></div>
                    </div>
                    <div class="form-group">
                        <label for="content" class="col-md-2">내용</label>
                        <div class="col-md-8">
                            <textarea name="content" id="content" rows="10" class="form-control ckeditor"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-8 text-right">
                            <button type="submit" class="btn btn-info">보내기</button>
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
