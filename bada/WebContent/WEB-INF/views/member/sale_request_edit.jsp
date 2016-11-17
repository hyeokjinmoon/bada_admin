<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/views/inc/head.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/classic.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/classic.date.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/classic.time.css">
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
                    <h2>판매 신청 수정</h2>
                </div>
                <p class="col-md-offset-2 text-warning">*은 필수 입력입니다.</p>
                <form class="form-horizontal" id="myform" method="post" action="${pageContext.request.contextPath}/member/sale_request_edit_ok.do">
                	<input type="hidden" name="member_id" value="${loginInfo.id }"/>
                	<input type="hidden" name="id" value="${sales.id }" />
                    <div class="form-group">
                        <label for="sale_type" class="col-md-2">신청종류*</label>
                        <div class="col-md-8"> 
                            <label for="s_type"><input type="radio" name="sales_type" value="S" <c:if test="${sales.sales_type == 'S' }">checked</c:if>> 단품(5권 이하)</label> &nbsp;&nbsp;&nbsp;
                            <label for="m_type"><input type="radio" name="sales_type" value="B" <c:if test="${sales.sales_type == 'B' }">checked</c:if>> 대량(6권 이상)</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="pickup_date" class="col-md-2">수거 가능일*</label>
                        <div class="col-md-4 input-group" style="padding-left : 15px">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                            <input type="text" name="pickup_date" id="pickup_date" class="form-control" value="${sales.pickup_date }">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="book_list" class="col-md-2">판매 도서 내역*</label>
                        <div class="col-md-8">
                            <textarea class="ckeditor" name="book_list" id="book_list" rows="8" class="form-control">${sales.book_list }</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2">방문 수거 주소*</label>
                        <div class="col-md-10 form-group">
                            <div class="col-md-8 clearfix" style="margin-bottom:15px;">
                                <input type="text" name="postcode" id="postcode" class="form-control pull-left" style="width: 120px; margin-right: 5px;" readonly value="${loginInfo.postcode }">
                                <input type="button" value="우편번호 찾기" class="btn btn-warning" onclick='execDaumPostcode("postcode", "addr1", "addr2");'>
                            </div>
                            <div class="col-md-8" style="margin-bottom:15px;"><input type="text" name="addr1" id="addr1" class="form-control" readonly value="${loginInfo.addr1 }"></div>
                            <div class="col-md-8"><input type="text" name="addr2" id="addr2" class="form-control" value="${loginInfo.addr2 }"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-8">
                            <button type="submit" class="btn btn-primary" id="sale_req">수정완료</button>
                        </div>
                    </div>
                </form>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->

        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
		
		<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/daumPostCode.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/picker.js"></script>
	    <script src="${pageContext.request.contextPath}/assets/js/picker.date.js"></script>
	    <script src="${pageContext.request.contextPath}/assets/js/picker.time.js"></script>
	    <script src="${pageContext.request.contextPath}/assets/js/pickadate.ko_KR.js"></script>
	    <script type="text/javascript">
	    	$(function() {
	    		 $("#pickup_date").pickadate({
	    			 format: 'yyyy-mm-dd',
	    			 formatSubmit: 'yyyy-mm-dd'
	    		 });
	    	});
	    </script>
    </div>
    
</body>

</html>
