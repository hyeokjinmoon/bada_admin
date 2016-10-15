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
                  <h1>쪽지보기</h1>
                </div>
                <table class="table table-bordered">
					<tr>
						<th class="info text-center" width="100">보낸사람</th>
						<td>이민구</td>
					</tr>
					<tr>
						<th class="info text-center">받는사람</th>
						<td>문혁진</td>
					</tr>
					<tr>
						<th class="info text-center" height="100" style="vertical-align:middle;">내용</th>
						<td style="vertical-align:middle;">중고라고해도 너무한듯</td>
					</tr>
					<tr>
						<th class="info text-center">작성일</th>
						<td>2016-10-10</td>
					</tr>
				</table>
				<div class="text-right">
					<a href="#" class="btn btn-primary">목록</a>
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
