<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/inc/head.jsp" %>
	<script type="text/javascript">
	    $(function() {
	        $("#n_register").click(function() {
	            swal({
	                title: "공지사항 등록",
	                text: "이대로 등록하시겠습니까?",
	                showCancelButton: true,
	                closeOnConfirm: false,
	                showLoaderOnConfirm: true
	            },function() {
	                setTimeout(function(){
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
                  <h1>쪽지 작성</h1>
                </div>
                <form class="form-horizontal" id="myform">
                    <div class="form-group">
                        <label for="to_member" class="col-md-2">받는 사람</label>
                        <div class="col-md-8"><input type="text" name="to_member" id="to_member" class="form-control"></div>
                    </div>
                    <div class="form-group">
                        <label for="m_content" class="col-md-2">내용</label>
                        <div class="col-md-8">
                            <textarea name="m_content" id="m_content" rows="10" class="form-control ckeditor"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-8 text-right">
                            <button type="button" class="btn btn-info btn-lg" id="n_register">보내기</button>
                        </div>
                    </div>
                </form>
                <%@ include file="/WEB-INF/inc/footer.jsp" %>
                <!-- 작성 영역 끝 -->

            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->
</body>

</html>
