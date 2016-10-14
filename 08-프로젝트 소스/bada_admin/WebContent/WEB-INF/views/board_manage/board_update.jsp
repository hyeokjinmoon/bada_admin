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
                  <h1>공지사항 수정</h1>
                </div>
                <form class="form-horizontal" id="myform">
                    <div class="form-group">
                        <label for="n_title" class="col-md-2">제목</label>
                        <div class="col-md-8"><input type="text" name="n_title" id="n_title" class="form-control"></div>
                    </div>
                    <div class="form-group">
                        <label for="n_content" class="col-md-2">공지사항 내용</label>
                        <div class="col-md-8">
                            <textarea name="n_content" id="n_content" rows="10" class="form-control ckeditor"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-8">
                            <button type="button" class="btn btn-info btn-lg" id="n_update">수정완료</button>
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


        <script type="text/javascript">
			$(function(){
			  $("#n_update").click(function(){
				  swal({
				  /*버튼 클릭시 출력되는 메시지*/
				      title: "수정확인",
				      text: "수정하시겠습니까?",
				     showCancelButton: true,
				  /*확인버튼에 대한 설정*/
				    confirmButtonClass: "btn-info",
				     confirmButtonText: "수정완료",
				  /*취소 버튼에 대한 설정*/
				    cancelButtonClass:"btn-warning",
				    cancelButtonText:"아니요",
				    closeOnConfirm: false,
				    closeOnCancel:true,
				  /*확인버튼 누를경우 동작하는 기능*/
				  },function(isConfirm){
				    if(isConfirm){
				         swal({title:"수정확인",
				              text:"수정이 완료되었습니다.",
				              type:"success",
				              confirmButtonText:"확인",
				              confirmButtonClass:"btn-info"})
				    }

				  });
			  });
			  });
			$(function(){
			  $("#d_update").click(function(){
			  swal({
			  /*버튼 클릭시 출력되는 메시지*/
			      title: "삭제확인",
			      text: "삭제하시겠습니까?",
			     showCancelButton: true,
			  /*확인버튼에 대한 설정*/
			    confirmButtonClass: "btn-danger",
			     confirmButtonText: "삭제완료",
			  /*취소 버튼에 대한 설정*/
			    cancelButtonClass:"btn-warning",
			    cancelButtonText:"아니요",
			    closeOnConfirm: false,
			    closeOnCancel:true,
			  /*확인버튼 누를경우 동작하는 기능*/
			  },function(isConfirm){
			    if(isConfirm){
			         swal({title:"삭제확인",
			              text:"삭제이 완료되었습니다.",
			              type:"success",
			              confirmButtonText:"확인",
			              confirmButtonClass:"btn-info"})
			    }

			  });
			  });
			  });
        </script>
</body>

</html>
