<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
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
                    <h2>회원탈퇴</h2>
                </div>
                <div class="col-md-offset-3 col-md-6">
                	<p class="text"><strong>
                		탈퇴후 <span class="text-danger">1개월간</span> 회원정보를 보관합니다.
                        <br/>
                        따라서 <span class="text-danger">1개월간</span> 같은 <span class="text-info">아이디, 이메일</span>로 재가입 하실수 없습니다
                    </strong></p>
	                <p><strong>탈퇴를 위해서는 <span class="text-danger">비밀번호</span>를 입력해 주세요.</strong></p>
						
					<!-- 비밀번호 입력 폼 시작 -->
				
					<form name="myform" method="post" action="${pageContext.request.contextPath}/member/out_ok.do">
						<input type="hidden" name="id" value="${loginInfo.id}" />
						<div class="form-group">
							<input type="password" name="user_pw" class="form-control" />
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-danger btn-block">회원탈퇴</button>
						</div>
					</form>
				</div>
				<!--// 비밀번호 입력 폼 끝 -->
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->

        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    
</body>

</html>
