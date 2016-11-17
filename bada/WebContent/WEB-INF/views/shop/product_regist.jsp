<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/views/inc/head.jsp" %>
	<script src="${pageContext.request.contextPath}/assets/js/additional-methods.min.js"></script>
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
                    <h2>회원에게 판매(신청)</h2>
                </div>
                <p class="col-md-offset-2 text-warning">*은 필수 입력입니다.</p>
                <form class="form-horizontal" id="regi-form" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/shop/product_regist_ok.do">
                    <input type="hidden" name="seller_id" value="${loginInfo.id}" />
                    <div class="form-group">
                        <label for="product_name" class="col-md-2">도서명*</label>
                        <div class="col-md-8"><input type="text" name="product_name" id="product_name" class="form-control"></div>
                    </div>
                    <div class="form-group">
                        <label for="category" class="col-md-2">카테고리*</label>
                        <div class="col-md-8">
                        	<select name="category" id="category" class="form-control">
                        		<option value="E">미지정</option>
                        		<option value="S">학문</option>
                        		<option value="N">소설</option>
                        		<option value="D">자기계발</option>
                        		<option value="M">정기 간행물</option>
                        		<option value="C">어린이 도서</option>
                        	</select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="list_price" class="col-md-2">구매가*</label>
                        <div class="col-md-8"><input type="text" name="list_price" id="list_price" class="form-control"></div>
                    </div>
                    <div class="form-group">
                        <label for="sale_price" class="col-md-2">판매가*</label>
                        <div class="col-md-4">
                            <input type="text" name="sale_price" id="sale_price" class="form-control">
                        </div>
                        <div class="col-md-4">
                            <p class="text-danger">-판매 수수료는 10%입니다.</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="product_img" class="col-md-2">도서 이미지</label>
                        <div class="col-md-8">
                            <input type="file" name="product_img" id="product_img" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-8">
                            <button type="submit" class="btn btn-primary" id="sale_regist">판매등록</button>
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
			
		 	$("#regi-form").validate({
		    	//입력검사 규칙
	            rules : {
	            	product_name : {
	                    required : true
	                },
	                list_price : {
	                    required : true,
	                    number : true
	                },
	                sale_price : {
	                    required :true,
	                    number : true
	                },
	                category : {
	                	required : true
	                },
	                product_img :{
	                    extension : "jpg|gif|png"
	                }
	            },
	            //규칙이 맞지 않을 경우 표시 할 메시지
	            messages : {
	            	product_name : {
	                    required : "상품명을 입력하세요."
	                },
	                list_price : {
	                    required : "구매가를 입력하세요.",
	                    number : "숫자를 입력하셔야 합니다."
	                },
	                sale_price : {
	                	required : "판매가를 입력하세요.",
	                    number : "숫자를 입력하셔야 합니다."
	                },
	                category : {
	                	required : "카테고리를 선택해주세요."
	                },
	                profile_img :{
	                    extension : "상품 사진은 jpg, png, gif 형식만 업로드 가능합니다."
	                }
	            }
		    });
		 	
		});
    </script>
</body>

</html>
