<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/views/inc/head.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/multi-columns-row.css">
	<script src="${pageContext.request.contextPath}/assets/js/handlebars.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/ie-row-fix.js"></script>
</head>

<body>

    <%@ include file="/WEB-INF/views/inc/topnav.jsp" %>

    <div class="container">

        <!-- Grid Row 시작 -->
        <div class="row">

            <%@ include file="/WEB-INF/views/inc/sidebar_shop.jsp" %>

            <!-- 메인 컨텐츠 영역 시작 -->
            <div class="col-sm-9 col-md-10 main-content multi-columns-row">
                <div class="page-header clearfix">
		        	<h3 class="text-info">전체 상품 : <small>${totalCount} 건</small></h3>
				</div>
				<c:if test="${totalCount == 0 }">
				<div class="text-center">
					<h4>조회된 상품이 없습니다.</h4>
				</div>
				</c:if>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
		</div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    
    <script id="product-template" type="text/x-handlebars-template">
		{{#productList}}
		<div class="col-xs-12 col-sm-6 col-md-3 col-lg-3">
		    <div class="thumbnail">
		    	<a href="${pageContext.request.contextPath}/shop/product_detail.do?id={{id}}">
					{{#if product_img}}
						<img class="img-thumbnail" src="${pageContext.request.contextPath}/download.do?file={{product_img}}" alt="{{product_name}}" />
					{{else}}
						<img class="img-thumbnail" src="${pageContext.request.contextPath}/assets/img/basic_img.png" alt="상품 이미지"/>
					{{/if}}
				</a>
		    	<div class="caption text-center clearfix">
		    		<h5 class="subject">{{product_name}}</h5>
		    		{{#isBada seller}}
						<p class="pull-left"><span class="label label-primary">BADA</span></p>
					{{else}}
						<p class="pull-left">{{seller_name}}</p>
					{{/isBada}}
					<p class="pull-right"><span class="text-danger">{{currency sale_price}}</span> 원</p>
		    	</div>
		    </div>
		</div>
		{{/productList}}
    </script>
    
    <script type="text/javascript">
    	$(function() {
    		var now_page = 1;
    		var page_count = 0;
    		
    		function select_product_list() {
    			
    			$.get('product_list.do',{
        			result : 16, 
        			page_no : now_page
        		}, function(res) {
        			page_count = res.page_count;
        			
        			var template = Handlebars.compile($("#product-template").html());
        			var html = template(res);
        			
        			$(".main-content").append(html);
        		});
    		};
    		
    		Handlebars.registerHelper('currency', function(x) {
				return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
			});
    		
    		Handlebars.registerHelper('isBada', function(seller, options) {
    			if(seller == 'B'){
    				return options.fn(this);
    			} else {
    				return options.inverse(this);
    			}
    		});
			
    		select_product_list();
    		
    		/** 브라우저의 스크롤 이벤트 */
    		$(window).scroll(function() {
    			// 스크롤이 맨 끝에 도착했는지를 판별하기 위한 연산식
    			var p = $(window).scrollTop() + $(window).height();
    			var h = $(document).height() - 5; 
    			
    			// 스크롤의 위치가 맨 끝에 도착했다면?
    			if(p >= h) {
    				// 다음과 연동할 경우 전체 페이지 수를 3으로 제한하고 있기 때문에
    				// 전체 페이지수가 3보다 크다면 강제로 3으로 설정
    				/* if (page_count > 3) {
    					page_count = 3;
    				} */

    				// 현재 페이지가 전체 페이지 수 보다 적은 경우만 다음페이지 요청
    				if (now_page < page_count) {
    	                now_page++;		// 페이지 번호를 증가함
    	                select_product_list();
    	            }
    	        }
    		}); // end scroll
    		
    	});
    </script>
</body>

</html>
