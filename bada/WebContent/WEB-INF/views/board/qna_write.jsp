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
                    <h2>1:1 문의</h2>
                </div>
				<form class="form-horizontal" id="qna_form" method="post" action="${pageContext.request.contextPath}/board/qna_write_ok.do">
					<input type="hidden" name="request_id" value="${loginInfo.id}"/>
					<div class="form-group">
				    	<label for="subject" class="col-md-2 text-right">제목</label>
					    <div class="col-md-8">
					        <input type="text" name="subject" id="subject" class="form-control">
					    </div>
				    </div>
				    <div class="form-group">
				    	<label for="subject" class="col-md-2 text-right">문의종류</label>
					    <div class="col-md-8">
					        <select name="req_type" id="req_type" class="form-control">
					        	<option value="">--문의 종류를 선택해주세요.--</option>
					        	<option value="S">판매관련</option>
					        	<option value="D">환불</option>
					        	<option value="R">배송관련</option>
					        	<option value="E">기타</option>
					        </select>
					    </div>
				    </div>
				    <div class="form-group">
				        <label for="content" class="col-md-2 text-right">내용</label>
				        <div class="col-md-8">
				            <textarea name="content" id="content" class="form-control ckeditor"></textarea>
				        </div>
				    </div>
				    <div class="form-group">
				        <div class="col-md-offset-2 col-md-8">
				            <button type="submit" class="btn btn-info">작성완료</button>
				            <button type="reset" class="btn btn-warning">다시작성</button>
				        </div>
				    </div>
				</form>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
		</div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    <script type="text/javascript">
		 $(function() {
			// 플러그인의 기본 설정 옵션 추가
		    jQuery.validator.setDefaults({
		        onkeyup : false,
		        onclick : false,
		        onfocusout : false,
		        showErrors : function(errorMap, errorList){
		            if(this.numberOfInvalids()) {
		                swal({
		                    title : "에러",
		                    text : errorList[0].message,
		                    type : "error"
		                }, function() {
		                    setTimeout(function() {
		                        $(errorList[0].element).focus();
		                    },100);
		                });
		            }
		        }
		    });
			
		 	$("#qna_form").validate({
		    	//입력검사 규칙
	            rules : {
	            	subject : {
	                    required : true
	                },
	                req_type : {
	                    required : true
	                },
	                content : {
	                    required :true
	                }
	            },
	            //규칙이 맞지 않을 경우 표시 할 메시지
	            messages : {
	            	subject : {
	                    required : "문의 제목을 입력하세요."
	                },
	                req_type : {
	                    required : "문의 종류를 선택해주세요."
	                },
	                content : {
	                	required : "문의 내용을 작성해주세요."
	                }
	            }
		    });
		 	
		});
    </script>
</body>

</html>
