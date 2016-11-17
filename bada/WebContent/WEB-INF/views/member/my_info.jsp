<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                    <h2>내 정보</h2>
                </div>
                <div class="table-responsive">
	                <table class="table table-bordered">
						<tr>
							<th class="info text-center">이름</th>
							<td>${infoItem.name }</td>
						</tr>
						<tr>
							<th class="info text-center">아이디</th>
							<td>${infoItem.user_id }</td>
						</tr>
						<tr>
							<th class="info text-center">이메일</th>
							<td>${infoItem.email }</td>
						</tr>
						<tr>
							<th class="info text-center">주소</th>
							<c:choose>
								<c:when test="${infoItem.postcode == null }">
									<td>주소 없음</td>
								</c:when>
								<c:otherwise>
									<td>(${infoItem.postcode})&nbsp;${infoItem.addr1}&nbsp;${infoItem.addr2}</td>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr>
							<th class="info text-center">연락처</th>
							<td>${infoItem.tel}</td>
						</tr>
						<tr>
							<th class="info text-center">가입일</th>
							<td>${infoItem.reg_date }</td>
						</tr>
						<tr>
							<th class="info text-center">프로필이미지</th>
							<c:choose>
								<c:when test="${infoItem.profile_img == null }">
									<td>
										<img class="thumbnail" src="${pageContext.request.contextPath}/assets/img/basic_user_img.gif" alt="상품 이미지" width="100"/>이미지가 없습니다.
									</td>
								</c:when>
								<c:otherwise>
									<td>
										<c:url var="imgUrl" value="/download.do">
											<c:param name="file" value="${infoItem.profile_img}"/>
										</c:url>
										<img src="${imgUrl}" alt="프로필 이미지" class="thumbnail" width="100"/>
									</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</table>
				</div>
				<a href="${pageContext.request.contextPath}/member/info_edit.do" class="btn btn-warning">수정하기</a>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
</body>

</html>

