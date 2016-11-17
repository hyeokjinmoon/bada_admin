<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/views/inc/head.jsp" %>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ajax_helper.css">
	
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/daumPostCode.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.form.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/additional-methods.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/ajax_helper.js"></script>
    
</head>

<body>

   <!-- 로고, 상단 네비게이션 바 -->
    <nav class="navbar navbar-topbar navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index"><strong style="color:#fff;">BaDa</strong></a>
            </div>
            
        </div>
    </nav>
    <div class="container">

        <div class="page-header col-md-offset-2">
            <h2>회원가입</h2>
        </div>
        <p class="col-md-offset-4 text-warning">*은 필수 입력입니다.</p>
        <form class="form-horizontal" id="join_form" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/member/join_ok.do">
            <input type="hidden" id="id_dupl" value="N" />
            <input type="hidden" id="email_dupl" value="N" />
            <div class="form-group">
                <label for="user_id" class="col-md-offset-2 col-md-2">아이디*</label>
                <div class="col-md-8">
                	<input type="text" name="user_id" id="user-id" class="form-control pull-left" style="width:200px !important;margin-right: 5px;">
                	<button type="button" class="btn btn-info" id="id_dupl_check">아이디 중복검사</button>
                </div>
            </div>
            <div class="form-group">
                <label for="user_pw" class="col-md-offset-2 col-md-2">비밀번호*</label>
                <div class="col-md-8"><input type="password" name="user_pw" id="user-pw" class="form-control"></div>
            </div>
            <div class="form-group">
                <label for="user_pw_re" class="col-md-offset-2 col-md-2">비밀번호 확인*</label>
                <div class="col-md-8"><input type="password" name="user_pw_re" id="user_pw_re" class="form-control"></div>
            </div>
            <div class="form-group">
                <label for="postcode" class="col-md-offset-2 col-md-2">우편번호*</label>
                <div class="col-md-8 clearfix">
                    <input type="text" name="postcode" id="postcode" class="form-control pull-left" style="width:100px !important;margin-right: 5px;">
                    <input type="button" value="우편번호 찾기" class="btn btn-warning" onclick='execDaumPostcode("postcode", "addr1", "addr2");'>
                </div>
            </div>
            <div class="form-group">
                <label for="addr1" class="col-md-offset-2 col-md-2">주소*</label>
                <div class="col-md-8"><input type="text" name="addr1" id="addr1" class="form-control"></div>
            </div>
            <div class="form-group">
                <label for="addr2" class="col-md-offset-2 col-md-2">상세주소*</label>
                <div class="col-md-8"><input type="text" name="addr2" id="addr2" class="form-control"></div>
            </div>
            <div class="form-group">
                <label for="name" class="col-md-offset-2 col-md-2">이름*</label>
                <div class="col-md-8"><input type="text" name="name" id="name" class="form-control"></div>
            </div>
            <div class="form-group">
                <label for="email" class="col-md-offset-2 col-md-2">이메일*</label>
                <div class="col-md-8">
                	<input type="email" name="email" id="email" class="form-control pull-left" style="width:200px !important;margin-right: 5px;">
                	<button type="button" class="btn btn-info" id="email_dupl_check">이메일 중복검사</button>
                </div>
            </div>
            <div class="form-group">
                <label for="tel" class="col-md-offset-2 col-md-2">연락처*</label>
                <div class="col-md-8"><input type="tel" name="tel" id="tel" class="form-control"></div>
            </div>
            <div class="form-group">
                <label for="profile_img" class="col-md-offset-2 col-md-2">프로필 사진</label>
                <div class="col-md-8">
                    <input type="file" name="profile_img" id="profile_img" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-4 col-md-8">
                    <button type="submit" class="btn btn-primary">가입하기</button>
                    <button type="reset" class="btn btn-danger">다시작성</button>
                </div>
            </div>
        </form>

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

            $.validator.addMethod( "kor", function( value, element ) {
            	return this.optional( element ) || /^[ㄱ-ㅎ가-힣]*$/i.test( value );
            });

            $.validator.addMethod( "phone", function( value, element ) {
            	return this.optional( element ) || /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/i.test( value ) || /^\d{2,3}\d{3,4}\d{4}$/i.test( value );
            });

            $("#join_form").validate({
                //입력검사 규칙
                rules : {
                    user_id : {
                        required :true,
                        alphanumeric : true
                    },
                    user_pw : {
                        required : true,
                        minlength : 4,
                        maxlength : 20
                    },
                    user_pw_re : {
                        required : true,
                        equalTo : "#user-pw"
                    },
                    name : {
                        required : true,
                        kor : true
                    },
                    email : {
                        required : true,
                        email : true
                    },
                    tel : {
                        required :true,
                        phone : true
                    },
                    profile_img :{
                        extension : "jpg|gif|png"
                    }
                },
                //규칙이 맞지 않을 경우 표시 할 메시지
                messages : {
                    user_id : {
                        required :"아이디를 입력하세요.",
                        alphanumeric : "아이디는 영문과 숫자만 입력가능합니다."
                    },
                    user_pw : {
                        required : "비밀번호를 입력하세요.",
                        minlength : "비밀번호는 4글자 이상 입력하셔야 합니다.",
                        maxlength : "비밀번호는 20자를 넘을 수 없습니다."
                    },
                    user_pw_re : {
                        required : "비밀번호 확인값을 입력하세요.",
                        equalTo : "비밀번호 확인이 잘못되었습니다."
                    },
                    name : {
                        required : "이름을 입력하세요.",
                        kor : "한글만 입력하세요."
                    },
                    email : {
                        required : "이메일을 입력하세요.",
                        email : "이메일 형식이 잘못되었습니다."
                    },
                    tel : {
                        required : "전화번호를 입력하세요.",
                        phone : "전화번호 형식이 잘못되었습니다."
                    },
                    profile_img :{
                        extension : "프로필 사진은 jpg, png, gif 형식만 업로드 가능합니다."
                    }
                },
                
            });
            // validate end
            
            //아이디 중복 검사
            $("#id_dupl_check").on('click', function(){
            	if($("#user-id").val() == ''){
            		swal('아이디를 입력해주세요.');
            		$("#user-id").focus();
            		return false;
            	}
            	$.get('id_dupl_check.do', {
            			user_id : $("#user-id").val()
            	}, function(res){
            		if(res.rt == 'OK') {
            			if(res.count == 0){
            				swal('사용가능한 아이디입니다.');
            				$("#id_dupl").val('Y');
            			} else {
            				swal('이미 사용중인 아이디입니다.');
            				$("#user-id").val('').focus();
            			}
            		}
            	});
            });
            
          	//이메일 중복 검사
            $("#email_dupl_check").on('click', function(){
            	if($("#email").val() == ''){
            		swal('이메일을 입력해주세요.');
            		$("#email").focus();
            		return false;
            	}
            	$.get('email_dupl_check.do', {
            			email : $("#email").val()
            	}, function(res){
            		if(res.rt == 'OK') {
            			if(res.count == 0){
            				swal('사용가능한 이메일입니다.');
            				$("#email_dupl").val('Y');
            			} else {
            				swal('이미 사용중인 이메일입니다.');
            				$("#email").val('').focus();
            			}
            		}
            	});
            });
          	
          	$("#join_form").ajaxForm({
          		beforeSubmit : function(arr, $form, options) {
          			$("#join_form").valid();
          			if($("#id_dupl").val() == 'N') {
                		swal('아이디 중복검사를 하지 않으셨습니다.');
                		return false;
                	}
                	if($("#email_dupl").val() == 'N') {
                		swal('이메일 중복검사를 하지 않으셨습니다.');
                		return false;
                	}
                },
                success : function(res) {
                	if(res.rt == 'OK') {
                		window.location.href = "../index";
                		alert('가입을 환영합니다.');
                	}
                	
                }
          	});
        });
    </script>
</body>

</html>
