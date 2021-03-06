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
                  <h1>1:1문의 &nbsp;<small> 목록</small></h1>
                </div>
                 <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                            <tr class="alert alert-info">
                                <th class="text-center" width="20%">작성자</th>
                                <th class="text-center" width="15%">문의종류</th>
                                <th class="text-center" width="35%">문의제목</th>
                                <th class="text-center" width="20%">작성일시</th>
                                <th class="text-center" width="10%">답변상태</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="qnaMemberJoin" items="${qnaMemberJoinList}">
                            	<tr align="center">

	                                <td>${qnaMemberJoin.request_name}</td>
	                               	<td>
		                               	<c:choose>
		                               		<c:when test="${qnaMemberJoin.req_type == 'S'}">
		                               			판매
		                               		</c:when>
		                                	<c:when test="${qnaMemberJoin.req_type == 'D'}">
		                               			환불
		                               		</c:when>
		                               		<c:when test="${qnaMemberJoin.req_type == 'R'}">
		                               			배송
		                               		</c:when>
		                               		<c:when test="${qnaMemberJoin.req_type == 'E'}">
		                               			기타
		                               		</c:when>
		                                </c:choose>
	                                </td>
	                                <td class="subject">
                               	    	<c:url var="viewUrl" value="/board_manage/qna_view.do">
						            		<c:param name="id" value="${qnaMemberJoin.id}" />
						            	</c:url>
	                                	<a href="${viewUrl}">${qnaMemberJoin.subject}</a>
                                	</td>
	                                <td>${qnaMemberJoin.reg_date}</td>
	                                <td>
	                                	<c:choose>
	                                		<c:when test="${qnaMemberJoin.answer_status == 'A'}">
	                                			답변 완료
	                                		</c:when>
	                                		<c:when test="${qnaMemberJoin.answer_status == 'N'}">
	                                			미답변
	                                		</c:when>
	                                	</c:choose>
	                                </td>
	
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>

                </div>
                <!-- 페이지 번호 시작 -->
				<nav class="text-center">
					<ul class="pagination">
						<!-- 이전 그룹으로 이동 -->
						<c:choose>
							<c:when test="${pageHelper.prevPage > 0}">
								<!-- 이전 그룹에 대한 페이지 번호가 존재한다면? -->
								<!-- 이전 그룹으로 이동하기 위한 URL을 생성해서 "prevUrl"에 저장 -->
								<c:url var="prevUrl" value="/board_manage/qna_list.do">
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
							<c:url var="pageUrl" value="/board_manage/qna_list.do" >
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
								<c:url var="nextUrl" value="/board_manage/qna_list.do">
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
                <!-- 작성 영역 끝 -->

            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->

</body>

</html>
