<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/inc/head.jsp" %>
    <script type="text/javascript">
	    $(function () {
				$('[data-toggle="popover"]').popover();
		});
    </script>
    
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
                  <h1>쪽지보기</h1>
                </div>
                <table class="table table-bordered">
                	<tr>
						<th class="info text-center" width="100">일련번호</th>
						<td>${readMessage.id}</td>
					</tr>
					<tr>
						<th class="info text-center" width="100">보낸사람</th>
						<td>
							<c:choose>
                       			<c:when test="${loginInfo.id == readMessage.sender_id }">
                       				${readMessage.sender_name}
                      			</c:when>
                       			<c:otherwise>
		                     		<a data-toggle="popover" tabindex="0" data-html="true" data-container="body" data-toggle="popover"
		                       	       data-placement="bottom" 
		                       	       data-trigger="focus"
		                       	       data-content="<a href='${pageContext.request.contextPath}/member_manage/message_write.do?id=${readMessage.sender_id}'>답장보내기</a>">
		                       	    ${readMessage.sender_name}</a>
	                       	    </c:otherwise>
	                       	</c:choose>
						</td>
					</tr>
					<tr>
						<th class="info text-center">받는사람</th>
						<td>
							<c:choose>
                       			<c:when test="${loginInfo.id == readMessage.receiver_id }">
                       				${readMessage.receiver_name}
                       			</c:when>
                       			<c:otherwise>
                        			<a data-toggle="popover" tabindex="0" data-html="true" data-container="body" data-toggle="popover"
                       			       data-placement="bottom" 
                       			       data-trigger="focus"
                       			       data-content="<a href='${pageContext.request.contextPath}/member_manage/message_write.do?id=${readMessage.receiver_id}'>쪽지보내기</a>">
                       			    ${readMessage.receiver_name}</a>
                     		   	</c:otherwise>
                     		</c:choose>
						</td>
					</tr>
					<tr>
						<th class="info text-center" height="100px" style="vertical-align:middle;">내용</th>
						<td style="vertical-align:middle;">${readMessage.content }</td>
					</tr>
					<tr>
						<th class="info text-center">작성일</th>
						<td>${readMessage.reg_date }</td>
					</tr>
				</table>
				<div class="text-right">
					<a href="${pageContext.request.contextPath}/member_manage/message_list.do" class="btn btn-primary">목록</a>
					<a href="${pageContext.request.contextPath}/member_manage/message_write.do?id=${readMessage.sender_id}" class="btn btn-info">답장보내기</a>
					<a href="#" class="btn btn-danger">삭제</a>
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
