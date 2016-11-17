<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<%@ include file="/WEB-INF/views/inc/head.jsp"%>
</head>

<body>

	<%@ include file="/WEB-INF/views/inc/topnav.jsp"%>

	<div class="container">

		<!-- Grid Row 시작 -->
		<div class="row">

			<%@ include file="/WEB-INF/views/inc/sidebar_info.jsp"%>

			<!-- 메인 컨텐츠 영역 시작 -->
			<div class="col-sm-9 col-md-10 main-content">
				<div class="page-header clearfix">
					<h2>문의 내용</h2>
				</div>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">${qna.subject }</h3>
					</div>
					<div class="panel-body" style="min-height: 200px;">
						${qna.content}
					</div>
					<ul class="list-group">
						<li class="list-group-item">등록일 : ${qna.reg_date}</li>
						<c:choose>
							<c:when test="${qna.answer != null}">
								<li class="list-group-item">
									<p>${qna.edit_date}</p>
									<p>${qna.answer}</p>
								</li>
							</c:when>
						</c:choose>
					</ul>
				</div>
				<a href="${pageContext.request.contextPath}/board/qna_list.do" class="btn btn-primary">목록</a>
				<c:if test="${qna.answer_status eq 'N'}">
					<a href="${pageContext.request.contextPath}/board/qna_edit.do?id=${qna.id}" class="btn btn-warning">수정</a>
				</c:if>
				<a href="${pageContext.request.contextPath}/board/qna_delete.do?id=${qna.id}" class="btn btn-danger">삭제</a>
			</div>
			<!-- 메인 컨텐츠 영역 끝 -->

		</div>
		<!-- Grid Row 끝 -->

		<%@ include file="/WEB-INF/views/inc/footer.jsp"%>
	</div>

</body>

</html>
