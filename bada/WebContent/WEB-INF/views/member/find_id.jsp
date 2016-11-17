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

        <div class="page-header col-md-offset-3 col-md-6 clearfix">
            <h2>아이디 찾기</h2>
        </div>
        <div class="row">
	        <div class="col-md-offset-3 col-md-6">
	        	<p><strong>가입시 입력한 아이디는 bada***과 같은 형식으로 보여집니다.</strong></p>
	            <p>
	       	    	가입시 입력한 이메일 주소를 입력해주세요.
	            </p>
	            	
				<!-- 비밀번호 입력 폼 시작 -->
				<form name="myform" method="post" action="${pageContext.request.contextPath}/member/find_id_ok.do">
					<div class="form-group">
						<input type="email" name="email" class="form-control" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-info btn-block">아이디 찾기</button>
					</div>
				</form>
			</div>
		</div>
		<div class="col-md-offset-3 col-md-6">
       <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
       </div>
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

            $("#join_form").validate({
                //입력검사 규칙
                rules : {
                    email : {
                        required : true,
                        email : true
                    }
                },
                //규칙이 맞지 않을 경우 표시 할 메시지
                messages : {
                    email : {
                        required : "이메일을 입력하세요.",
                        email : "이메일 형식이 잘못되었습니다."
                    }
                },
                
            });
            // validate end
            
        });
    </script>
</body>

</html>
