<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/inc/head.jsp" %>
	<script type="text/javascript">
            $(function() {
                $("#p_update").click(function() {
                    swal({
                        title: "등록 상품 수정",
                        text: "이대로 수정하시겠습니까?",
                        showCancelButton: true,
                        closeOnConfirm: false,
                        showLoaderOnConfirm: true
                    },function() {
                        setTimeout(function(){
                            swal("수정되었습니다.");
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
                  <h1>상품 수정(바다)</h1>
                </div>
                <p class="col-md-offset-2 text-warning">*은 필수 입력입니다.</p>
                <form class="form-horizontal" id="myform">
                    <div class="form-group">
                        <label for="b_title" class="col-md-2">도서명*</label>
                        <div class="col-md-8"><input type="text" name="b_title" id="b_title" class="form-control"></div>
                    </div>
                    <div class="form-group">
                        <label for="p_price" class="col-md-2">정가*</label>
                        <div class="col-md-4"><input type="text" name="p_price" id="p_price" class="form-control"></div>
                    </div>
                    <div class="form-group">
                        <label for="s_price" class="col-md-2">판매가*</label>
                        <div class="col-md-4">
                            <input type="text" name="s_price" id="s_price" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="profile_img" class="col-md-2">도서 이미지</label>
                        <div class="col-md-8">
                            <img class="thumbnail" src="../assets/img/profile.png" alt="프로필 이미지" width="50px" />
                            <input type="file" name="profile_img" id="profile_img" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-8">
                            <button type="button" class="btn btn-info btn-lg" id="p_update">상품수정</button>
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
