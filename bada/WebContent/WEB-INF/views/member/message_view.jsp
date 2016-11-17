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
                    <h2>쪽지 보기</h2>
                </div>
                <div class="panel panel-primary">
					<div class="panel-heading">
						<c:choose>
							<c:when test="${flag == 'receive' }">
								<h3 class="panel-title">보낸 사람 : ${message.sender_name}</h3>
							</c:when>
							<c:when test="${flag == 'send' }">
								<h3 class="panel-title">받은 사람 : ${message.receiver_name}</h3>
							</c:when>
						</c:choose>
					</div>
					<div class="panel-body" style="min-height: 200px;">
						${message.content }
					</div>
					<ul class="list-group">
						<c:choose>
							<c:when test="${flag == 'receive' }">
								<li class="list-group-item">받은 날짜 : ${message.reg_date}</li>
							</c:when>
							<c:when test="${flag == 'send' }">
								<li class="list-group-item">보낸 날짜 : ${message.reg_date}</li>
							</c:when>
						</c:choose>
					</ul>
				</div>
				<c:choose>
					<c:when test="${flag == 'receive'}">
						<a href="${pageContext.request.contextPath}/member/receive_message_list.do" class="btn btn-primary">목록</a>
						<a href="${pageContext.request.contextPath}/member/message_delete.do?id=${message.id}&flag=receive" class="btn btn-danger">삭제</a>
					</c:when>
					<c:when test="${flag == 'send'}">
						<a href="${pageContext.request.contextPath}/member/send_message_list.do" class="btn btn-primary">목록</a>
						<a href="${pageContext.request.contextPath}/member/message_delete.do?id=${message.id}&flag=send" class="btn btn-danger">삭제</a>
					</c:when>
				</c:choose>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->

        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    
</body>

</html>
