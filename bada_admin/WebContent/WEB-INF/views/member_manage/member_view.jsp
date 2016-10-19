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
                  <h1>회원정보</h1>
                </div>
                <table class="table table-bordered">
					<tr>
						<th class="info text-center" width="100">회원일련번호</th>
						<td>${readMember.id}</td>
					</tr>
					<tr>
						<th class="info text-center">이름</th>
						<td>${readMember.name }</td>
					</tr>
					<tr>
						<th class="info text-center">아이디</th>
						<td>${readMember.user_id }</td>
					</tr>
					<tr>
						<th class="info text-center">이메일</th>
						<td>${readMember.email }</td>
					</tr>
					<tr>
						<th class="info text-center">주소</th>
						<c:choose>
							<c:when test="${readMember.postcode == null }">
								<td>주소 없음</td>
							</c:when>
							<c:otherwise>
								<td>${readMember.postcode} &nbsp; ${readMember.addr1}&nbsp;${readMember.addr2}</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th class="info text-center">연락처</th>
						<td>${readMember.tel}</td>
					</tr>
					<tr>
						<th class="info text-center">가입일</th>
						<td>${readMember.reg_date }</td>
					</tr>
					<tr>
						<th class="info text-center">정보수정일</th>
						<td>${readMember.edit_date }</td>
					</tr>
					<tr>
						<th class="info text-center">프로필이미지</th>
						<c:choose>
							<c:when test="${readMember.profile_img == null }">
								<td>이미지 없음</td>	
							</c:when>
							<c:otherwise>
								<td>
									<img src="${readMember.profile_img}" alt="프로필 이미지" class="thumbnail"/>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th class="info text-center">활성상태</th>
						<c:choose>
							<c:when test="${readMember.is_active == 'T' }">
								<td>유효</td>	
							</c:when>
							<c:when test="${readMember.is_active == 'F' }">
								<td>삭제대기</td>	
							</c:when>
						</c:choose>
					</tr>
				</table>
				<div class="text-right">
					<a href="${pageContext.request.contextPath}/member_manage/member_list.do" class="btn btn-primary">목록</a>
					<a href="${pageContext.request.contextPath}/member_manage/member_update.do?id=${readMember.id}" class="btn btn-warning">수정</a>
					<a href="#" class="btn btn-danger">삭제</a>
				</div>
                <!-- 작성 영역 끝 -->
                <%@ include file="/WEB-INF/inc/footer.jsp" %>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->
</body>

</html>
