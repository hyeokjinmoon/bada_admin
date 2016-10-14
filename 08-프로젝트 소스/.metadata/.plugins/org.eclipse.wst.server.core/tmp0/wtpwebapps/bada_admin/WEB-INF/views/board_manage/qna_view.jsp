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
                  <h1>1:1문의 <small>No.1</small></h1>
                </div>
                
                <div class="panel panel-default">
                    <div class="panel-heading clearfix">
                        <h3 class="panel-title pull-left">중고상품 등급 판정 기준은 무엇입니까?</h3>
                        <span class="pull-right">2016-10-10 12:00</span>
                    </div>
                    <div class="panel-body">
                    중고상품의 등급은 육안으로 확인 등 다양한 방법으로 판별합니다.
                    </div>
                    <div class="panel-footer">
					답변 내용
					</div>
                </div>
                <div class="pull-right">
	                <a href="#" class="btn btn-primary">목록</a>
	                <a href="#" class="btn btn-info">답변</a>
	                <a href="#" class="btn btn-warning">수정</a>
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
