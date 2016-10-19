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
                <div class="page-header clearfix">
                    <h1>회원정보수정</h1>
                </div>
                <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/member_manage/member_update_ok.do">
                    <input type="hidden" name="id" value="${readMember.id}"/>
                    <div class="form-group">
                        <label for="user_id" class="col-md-2 col-md-2 text-right">아이디</label>
                        <div class="col-md-8"><input type="text" name="user_id" id="user_id" class="form-control" disabled value="${readMember.user_id}"></div>
                    </div>
                    <div class="form-group">
                        <label for="postcode" class="col-md-2 col-md-2  text-right">우편번호</label>
                        <div class="col-md-8 clearfix">
                            <input type="text" name="postcode" id="postcode" class="form-control pull-left" style="width: 120px; margin-right: 5px;" value="${readMember.postcode}">
                        	<input type="button" value="우편번호 찾기" class="btn btn-warning" onclick='execDaumPostcode("postcode", "addr1", "addr2");'>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addr1" class="col-md-2 col-md-2 text-right">주소</label>
                        <div class="col-md-8"><input type="text" name="addr1" id="addr1" class="form-control" value="${readMember.addr1}"></div>
                    </div>
                    <div class="form-group">
                        <label for="addr2" class="col-md-2 col-md-2 text-right">상세주소</label>
                        <div class="col-md-8"><input type="text" name="addr2" id="addr2" class="form-control" value="${readMember.addr2}"></div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-2 col-md-2  text-right">이름</label>
                        <div class="col-md-8"><input type="text" name="name" id="name" class="form-control" value="${readMember.name}"></div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-md-2 col-md-2 text-right">이메일</label>
                        <div class="col-md-8"><input type="email" name="email" id="email" class="form-control" value="${readMember.email}"></div>
                    </div>
                    <div class="form-group">
                        <label for="tel" class="col-md-2 col-md-2   text-right">연락처</label>
                        <div class="col-md-8"><input type="tel" name="tel" id="tel" class="form-control" value="${readMember.tel }"></div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-8 text-right">
                            <button type="submit" class="btn btn-info">작성완료</button>
                            <button type="reset" class="btn btn-danger">다시작성</button>
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
