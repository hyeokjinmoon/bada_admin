<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">

    <head>
    	<%@ include file="/WEB-INF/inc/head.jsp" %>
        
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/sweetalert.css" />
        <script src="${pageContext.request.contextPath}/assets/js/sweetalert.min.js"></script>
        <script src="//cdn.ckeditor.com/4.5.11/standard/ckeditor.js"></script>
        <script type="text/javascript">
            $(function () {
                $("#n_register").click(function () {
                    swal({
                        title: "공지사항 등록",
                        text: "이대로 등록하시겠습니까?",
                        showCancelButton: true,
                        closeOnConfirm: false,
                        showLoaderOnConfirm: true
                    }, function () {
                        setTimeout(function () {
                            swal("등록되었습니다.");
                        }, 1000);
                    });
                });
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
                        <h1>공지사항 작성</h1>
                    </div>
                    <form class="form-horizontal" method="post" action="">
                        <div class="form-group">
                            <label for="n_title" class="col-md-2 text-right">제목</label>
                            <div class="col-md-8">
                                <input type="text" name="n_title" id="n_title" class="form-control"></div>
                            </div>
                            <div class="form-group">
                                <label for="n_content" class="col-md-2 text-right">내용</label>
                                <div class="col-md-8">
                                    <textarea name="n_content" id="n_content" rows="10" class="form-control ckeditor"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-2 col-md-8">
                                    <button type="button" class="btn btn-info pull-right" id="n_register">작성완료</button>
                                </div>
                            </div>
                        </form>
                        <!-- 작성 영역 끝 -->
					
						<%@ include file="/WEB-INF/inc/footer.jsp" %>
					
                    </div>
                    <!-- 메인 컨텐츠 영역 끝 -->
                </div>
            </div>
            <!-- 컨테이너 끝 -->

        </body>

    </html>
