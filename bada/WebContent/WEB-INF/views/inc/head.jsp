<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BaDa</title>
   
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css">

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/sweetalert.css">
<style type="text/css">
 	.autocomplete-suggestions { border: 1px solid #3399FF; background: #FFF; overflow: auto; }
	.autocomplete-suggestion { padding: 2px 5px; white-space: nowrap; overflow: hidden; }
	.autocomplete-selected { background: #F0F0F0; }
	.autocomplete-suggestions strong { font-weight: normal; color: #3399FF; }
 </style>

<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.2/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/sweetalert.min.js"></script> 
<script src="${pageContext.request.contextPath}/assets/js/handlebars.js"></script> 
<script src="${pageContext.request.contextPath}/assets/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/validate.messages_ko.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.autocomplete.min.js"></script>

<!-- ckeditor -->
<script src="http://cdn.ckeditor.com/4.5.11/basic/ckeditor.js"></script>
<script type="text/javascript">
	$(function() {
		// 팝오버
		$('[data-toggle="popover"]').popover();
		
		// validate 플러그인의 기본 설정 옵션 추가
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
		
		$("#login_form").validate({
			rules : {
                 user_id : {
                     required :true,
                 },
                 user_pw : {
                     required : true,
                 }
			},
			messages : {
                 user_id : {
                     required :"아이디를 입력하세요.",
                 },
                 user_pw : {
                     required : "비밀번호를 입력하세요.",
                 }
			}
		});
		
	});
  
</script>
    