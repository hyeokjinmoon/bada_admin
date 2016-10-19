<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/inc/head.jsp" %>
	<script type="text/javascript">
	        $(function() {
	            $("#p_register").click(function() {
	                swal({
	                    title: "상품 등록",
	                    text: "상품을 등록하시겠습니까?",
	                    showCancelButton: true,
	                    closeOnConfirm: false,
	                    showLoaderOnConfirm: true
	                }, function() {
	                    setTimeout(function() {
	                        swal("상품이 등록되었습니다.");
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
                    <h1>배송 상황 수정</h1>
                </div>
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="b_title" class="col-md-2 text-right">상품명</label>
                        <div class="col-md-8"><input type="text" name="b_title" id="b_title" class="form-control"></div>
                    </div>
                    <div class="form-group">
                        <label for="p_price" class="col-md-2 text-right">판매자</label>
                        <div class="col-md-8"><input type="text" name="p_price" id="p_price" class="form-control"></div>
                    </div>
                    <div class="form-group">
                        <label for="s_price" class="col-md-2 text-right">구매자</label>
                        <div class="col-md-8">
                            <input type="text" name="s_price" id="s_price" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="s_price" class="col-md-2 text-right">금액</label>
                        <div class="col-md-8">
                            <input type="text" name="s_price" id="s_price" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="s_price" class="col-md-2 text-right">거래일시</label>
                        <div class="col-md-8">
                            <input type="text" name="s_price" id="s_price" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="s_price" class="col-md-2 text-right">배송상황</label>
                        <div class="col-md-8">
                            <select class="form-control">
                                <option>-----선택해주세요-----</option>
                                <option>배송대기</option>
                                <option>배송중</option>
                                <option>배송완료</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-8">
                            <button type="button" class="btn btn-info pull-right">수정완료</button>
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
