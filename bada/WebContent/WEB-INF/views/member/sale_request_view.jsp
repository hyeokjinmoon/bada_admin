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
                    <h2>신청 상세</h2>
                </div>
                <div class="table-responsive">
	                <table class="table table-bordered">
						<tr>
							<th class="info text-center">신청유형</th>
							<td>
								<c:choose>
                               		<c:when test="${sales.sales_type == 'S'}">
                               			<span class="text-primary">단품(5권 이하)</span>
                               		</c:when>
                                	<c:when test="${sales.sales_type == 'B'}">
                               			<span class="text-primary">대량(6권 이상)</span>
                               		</c:when>
                                </c:choose>
							</td>
						</tr>
						<tr>
							<th class="info text-center">신청내용</th>
							<td>${sales.book_list }</td>
						</tr>
						<tr>
							<th class="info text-center">방문 수거 주소</th>
							<td>${sales.pickup_addr}</td>
						</tr>
						<tr>
							<th class="info text-center">수거가능일</th>
							<td>${sales.pickup_date}</td>
						</tr>
						<tr>
							<th class="info text-center">신청일시</th>
							<td>${sales.reg_date}</td>
						</tr>
						<tr>
							<th class="info text-center">신청상황</th>
							<td>
								<c:choose>
                               		<c:when test="${sales.sales_ok == 'W'}">
                               			<span class="text-warning">승인대기</span>
                               		</c:when>
                               		<c:when test="${sales.sales_ok == 'O'}">
                               			<span class="text-primary">승인</span>
                               		</c:when>
                               		<c:when test="${sales.sales_ok == 'R'}">
                               			<span class="text-danger">거절</span>
                               		</c:when>
                               	</c:choose>
							</td>
						</tr>
					</table>
				</div>
				<a href="${pageContext.request.contextPath}/member/sale_request_list.do" class="btn btn-primary">목록</a>
				<a href="${pageContext.request.contextPath}/member/sale_request_edit.do?id=${sales.id}" class="btn btn-warning">수정</a>
				<a href="${pageContext.request.contextPath}/member/sale_request_delete.do?id=${sales.id}" class="btn btn-danger">삭제</a>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->

        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    
</body>

</html>
