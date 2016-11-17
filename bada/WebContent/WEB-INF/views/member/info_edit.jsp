<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/views/inc/head.jsp" %>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/daumPostCode.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.form.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/additional-methods.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/ajax_helper.js"></script>
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
                    <h2>정보수정</h2>
                </div>
                <p class="col-md-offset-2 text-warning">*은 필수 입력입니다.(아이디는 변경할 수 없습니다.)</p>
                <form class="form-horizontal" id="edit-form" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/member/info_edit_ok.do">
                	<input type="hidden" name="id" value="${infoItem.id}" />
                    <div class="form-group">
                        <label for="user_id" class="col-md-2 col-md-2">아이디</label>
                        <div class="col-md-8"><input type="text" name="user_id" id="user_id" class="form-control" disabled value="${infoItem.user_id}"></div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-md-2 col-md-2">이름*</label>
                        <div class="col-md-8"><input type="text" name="name" id="name" class="form-control" value="${infoItem.name}"></div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-md-2 col-md-2">이메일*</label>
                        <div class="col-md-8"><input type="email" name="email" id="email" class="form-control" value="${infoItem.email}"></div>
                    </div>
                    <div class="form-group">
                        <label for="tel" class="col-md-2 col-md-2">연락처*</label>
                        <div class="col-md-8"><input type="tel" name="tel" id="tel" class="form-control" value="${infoItem.tel}"></div>
                    </div>
                    <div class="form-group">
                        <label for="postcode" class="col-md-2 col-md-2">우편번호*</label>
                        <div class="col-md-8 clearfix">
                            <input type="text" name="postcode" id="postcode" class="form-control pull-left" style="width:100px !important;margin-right: 5px;" value="${infoItem.postcode}">
                            <input type="button" value="우편번호 찾기" class="btn btn-warning" onclick='execDaumPostcode("postcode", "addr1", "addr2");'>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addr1" class="col-md-2 col-md-2">주소*</label>
                        <div class="col-md-8"><input type="text" name="addr1" id="addr1" class="form-control" value="${infoItem.addr1}"></div>
                    </div>
                    <div class="form-group">
                        <label for="addr2" class="col-md-2 col-md-2">상세주소*</label>
                        <div class="col-md-8"><input type="text" name="addr2" id="addr2" class="form-control" value="${infoItem.addr2}"></div>
                    </div>
                    <div class="form-group">
                        <label for="profile_img" class="col-md-2 col-md-2">프로필 사진</label>
                        <div class="col-md-8">
                        	<c:choose>
								<c:when test="${infoItem.profile_img == null }">
									<img class="thumbnail" src="${pageContext.request.contextPath}/assets/img/basic_user_img.gif" alt="이미지" width="100"/>이미지가 없습니다.
								</c:when>
								<c:otherwise>
									<c:url var="imgUrl" value="/download.do">
										<c:param name="file" value="${infoItem.profile_img}"/>
									</c:url>
									<img src="${imgUrl}" alt="프로필 이미지" class="thumbnail" width="100"/>
								</c:otherwise>
							</c:choose>
                            <input type="file" name="profile_img" id="profile_img" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-8">
                            <button type="submit" class="btn btn-primary">작성완료</button>
                            <button type="reset" class="btn btn-danger">다시작성</button>
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

            $.validator.addMethod( "kor", function( value, element ) {
                return this.optional( element ) || /^[ㄱ-ㅎ가-힣]*$/i.test( value );
            });

            $.validator.addMethod( "phone", function( value, element ) {
                return this.optional( element ) || /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/i.test( value ) || /^\d{2,3}\d{3,4}\d{4}$/i.test( value );
            });

            $("#edit-form").validate({
                //입력검사 규칙
                rules : {
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
                }
            });
        });
        $(document.body).on('click', '.dropdown-menu li', function(event) {

            var $target = $(event.currentTarget);

            $target.closest('.input-group-btn').find('[data-bind="label"]').text($target.text()).end().children('.dropdown-toggle').dropdown('toggle');

            return false;

        });
    </script>
</body>

</html>
