<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
                  <h1>판매 신청 상세</h1>
                </div>
                <table class="table table-bordered">
					<tr>
						<th class="info text-center" width="100">일련번호</th>
						<td>${salesRequest.id}</td>
					</tr>
					<tr>
						<th class="info text-center">신청유형</th>
						<td>
							<c:choose>
                               	<c:when test="${salesRequest.sales_type == 'S'}">
                               		단품(5권 이하)
                               	</c:when>
                               	<c:when test="${salesRequest.sales_type == 'B'}">
                               		대량(6권 이상)
                               	</c:when>
                            </c:choose>
						</td>
					</tr>
					<tr>
						<th class="info text-center">신청자</th>
						<td>${salesRequest.member_name}</td>
					</tr>
					<tr>
						<th class="info text-center">판매품목</th>
						<td>
							${salesRequest.book_list}
						</td>
					</tr>
					<tr>
						<th class="info text-center">신청일</th>
						<td>${salesRequest.reg_date }</td>
					</tr>
					<tr>
						<th class="info text-center">수정일</th>
						<td>
							${salesRequest.edit_date }
						</td>
					</tr>
					<tr>
						<th class="info text-center">수거가능일</th>
						<td>
							${salesRequest.pickup_date}
						</td>
					</tr>
					<tr>
						<th class="info text-center">승인상태</th>
						<td>
							<c:choose>
                             	<c:when test="${salesRequest.sales_ok == 'W'}">
                             		<span class="text-warning">승인대기</span>
                             	</c:when>
                             	<c:when test="${salesRequest.sales_ok == 'O'}">
                             		<span class="text-primary">승인</span>
                             	</c:when>
                             	<c:when test="${salesRequest.sales_ok == 'R'}">
                            		<span class="text-danger">승인거절</span>
                            	</c:when>
                             </c:choose>
						</td>
					</tr>
					<tr>
						<th class="info text-center">승인/거절</th>
						<td>
							<a href="${pageContext.request.contextPath}/member_manage/sales_request_update.do?id=${salesRequest.id}&sales_ok=O" class="btn btn-primary">승인</a>
							<a href="${pageContext.request.contextPath}/member_manage/sales_request_update.do?id=${salesRequest.id}&sales_ok=R" class="btn btn-danger">거절</a>
						</td>
					</tr>
				</table>
				<div class="text-right">
					<a href="${pageContext.request.contextPath}/member_manage/sales_request_list.do" class="btn btn-primary">목록</a>
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
