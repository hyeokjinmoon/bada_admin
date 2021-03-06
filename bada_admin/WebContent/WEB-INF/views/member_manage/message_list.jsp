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
                  <h1>쪽지목록</h1>
                </div>
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead class="alert alert-info">
                            <tr>
                            	<th class="text-center" width="10%">일련번호</th>
                                <th class="text-center" width="15%">보낸사람</th>
                                <th class="text-center" width="15%">받은사람</th>
                                <th class="text-center" width="40%">내용</th>
                                <th class="text-center" width="20%">작성일</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="message" items="${messageList}">
                        		<tr class="text-center">
                        			<td>${message.id}</td>
                        			<td>
                        				<c:choose>
                        					<c:when test="${loginInfo.id == message.sender_id }">
                        						${message.sender_name}
                        					</c:when>
                        					<c:otherwise>
			                        			<a data-toggle="popover" tabindex="0" data-html="true" data-container="body" data-toggle="popover"
			                       			       data-placement="bottom" 
			                       			       data-trigger="focus"
			                       			       data-content="<a href='${pageContext.request.contextPath}/member_manage/message_write.do?id=${message.sender_id}'>쪽지보내기</a>">
			                       			    ${message.sender_name}</a>
		                       			    </c:otherwise>
		                       			</c:choose>
                       			    </td>
                        			<td>
		                        		<c:choose>
		                        			<c:when test="${loginInfo.id == message.receiver_id }">
		                        				${message.receiver_name}
		                        			</c:when>
		                        			<c:otherwise>
			                        			<a data-toggle="popover" tabindex="0" data-html="true" data-container="body" data-toggle="popover"
			                       			       data-placement="bottom" 
			                       			       data-trigger="focus"
			                       			       data-content="<a href='${pageContext.request.contextPath}/member_manage/message_write.do?id=${message.receiver_id}'>쪽지보내기</a>">
			                       			    ${message.receiver_name}</a>
		                       			   	</c:otherwise>
		                       			</c:choose>
		                       		</td>
                        			<td class="content">
                        				<c:url var="messageUrl" value="/member_manage/message_view.do">
                        					<c:param name="id" value="${message.id }" />
                        				</c:url>
                        				<a href="${messageUrl}">${message.content}</a>
                        			</td>
                        			<td>${message.reg_date}</td>
                        		</tr>
                        	</c:forEach>
                        </tbody>
                    </table>
                   </div>
                <!-- 작성 영역 끝 -->
                <!-- 페이지 번호 시작 -->
				<nav class="text-center">
					<ul class="pagination">
						<!-- 이전 그룹으로 이동 -->
						<c:choose>
							<c:when test="${pageHelper.prevPage > 0}">
								<!-- 이전 그룹에 대한 페이지 번호가 존재한다면? -->
								<!-- 이전 그룹으로 이동하기 위한 URL을 생성해서 "prevUrl"에 저장 -->
								<c:url var="prevUrl" value="/member_manage/message_list.do">
									<c:param name="page" value="${pageHelper.prevPage}"></c:param>
								</c:url>
				
								<li><a href="${prevUrl}">&laquo;</a></li>
							</c:when>
				
							<c:otherwise>
								<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
								<li class='disabled'><a href="#">&laquo;</a></li>
							</c:otherwise>
						</c:choose>
							
						<!-- 페이지 번호 -->
						<!-- 현재 그룹의 시작페이지~끝페이지 사이를 1씩 증가하면서 반복 -->
						<c:forEach var="i" begin="${pageHelper.startPage}" end="${pageHelper.endPage}" step="1">
				
							<!-- 각 페이지 번호로 이동할 수 있는 URL을 생성하여 page_url에 저장 -->
							<c:url var="pageUrl" value="/member_manage/message_list.do" >
								<c:param name="page" value="${i}"></c:param>
							</c:url>
								
							<!-- 반복중의 페이지 번호와 현재 위치한 페이지 번호가 같은 경우에 대한 분기 -->
							<c:choose>
								<c:when test="${pageHelper.page == i}">
									<li class='active'><a href="#">${i}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${pageUrl}">${i}</a></li>
								</c:otherwise>
							</c:choose>	
				
						</c:forEach>
							
						<!-- 다음 그룹으로 이동 -->
						<c:choose>
							<c:when test="${pageHelper.nextPage > 0}">
								<!-- 다음 그룹에 대한 페이지 번호가 존재한다면? -->
								<!-- 다음 그룹으로 이동하기 위한 URL을 생성해서 "nextUrl"에 저장 -->
								<c:url var="nextUrl" value="/member_manage/message_list.do">
									<c:param name="page" value="${pageHelper.nextPage}"></c:param>
								</c:url>
				
								<li><a href="${nextUrl}">&raquo;</a></li>
							</c:when>
				
							<c:otherwise>
								<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
								<li class='disabled'><a href="#">&raquo;</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</nav>
				<!--// 페이지 번호 끝 -->
                <%@ include file="/WEB-INF/inc/footer.jsp" %>

            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->
</body>

</html>
