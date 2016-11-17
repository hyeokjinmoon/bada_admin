<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

            <%@ include file="/WEB-INF/views/inc/sidebar_shop.jsp" %>

            <!-- 메인 컨텐츠 영역 시작 -->
            <div class="col-sm-9 col-md-10 main-content">
                <div class="page-header clearfix">
                    <h2>상품 상세</h2>
                </div>
                <div class="table-response">
                	<table>
                		<tr>
                			<c:choose>
                				<c:when test="${product.product_img != null}">
		                			<c:url var="imgUrl" value="/download.do">
		                				<c:param name="file" value="${product.product_img}"/>
		                			</c:url>
		                			<td rowspan="7" align="center" width="300">
		                				<img src="${imgUrl}" class="img-responsive thumbnail" alt="${product.product_name}" width="200" />
		                			</td>
	                			</c:when>
	                			<c:otherwise>
		                			<td rowspan="7" align="center" width="300">
		                				<img class="img-responsive thumbnail" src="${pageContext.request.contextPath}/assets/img/basic_img.png" width="200" alt="상품 이미지"/>
		                			</td>
	                			</c:otherwise>
                			</c:choose>
                		</tr>
                		<tr>
                			<td valign="baseline" class="subject" width="70%" style="padding-left:20px;"><h3>${product.product_name}</h3></td>
                		</tr>
                		<tr>
                			<td valign="middle" style="padding-left:20px;"><h5>판매자 : 
                				<c:choose>
                					<c:when test="${product.seller == 'B' }">
                						<span class="label label-primary">BADA</span>
                					</c:when>
                					<c:otherwise>
                						<a data-toggle="popover" tabindex="0" data-html="true" data-container="body" data-toggle="popover" data-placement="bottom"  data-trigger="focus" data-content="<a href='${pageContext.request.contextPath}/member/message_answer.do?id=${product.seller_id}'>쪽지보내기</a>">
		                				${product.seller_name}(${product.seller_user_id })</a>
                					</c:otherwise>
                				</c:choose>
                				</h5>
                			</td>
                		</tr>
                		<tr>
                			<td valign="middle" style="padding-left:20px;"><h5>구매가 : <del><span class="text-success"><fmt:formatNumber value="${product.list_price}" groupingUsed="true"/></span></del> 원</h5></td>
                		</tr>
                		<tr>
                			<td valign="middle" style="padding-left:20px;"><h5>판매가 : <span class="text-danger"><fmt:formatNumber value="${product.sale_price}" groupingUsed="true"/></span> 원</h5></td>
                		</tr>
                		<tr>
                			<td valign="middle" style="padding-left:20px;"><h5>등록일시 : ${product.reg_date}</h5></td>
                		</tr>
                		<tr>
                			<td valign="middle" style="padding-left:20px;">
                				<c:choose>
	                				<c:when test="${product.product_status == 'C' }">
	                					<h4 class="text-danger">판매완료</h4>
	                				</c:when>
                				 	<c:otherwise>
		                				<button type="button" class="btn btn-info" id="orders">지금구매</button>
		                				<button type="button" class="btn btn-warning" id="insert_cart">장바구니</button>
                					</c:otherwise>
                				</c:choose>
                			</td>
                		</tr>
                	</table>
                </div>
                <div class="page-header">
                	<h3>상품 정보</h3>
                </div>
                <div class="table-responsive" id="product_info">
                	
                </div>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->

        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    <script type="text/x-handlebars-template" id="info_template">
    	{{#channel.item}}
		<table>
			<tr>
				<td rowspan="5"><img src="{{cover_l_url}}" alt="{{title}}" /></td>
			</tr>
			<tr>
				<td style="padding-left:20px;">저자 : {{author}}</td>
			</tr>
			<tr>
				<td style="padding-left:20px;">출판일 : {{pub_date}}</td>
			</tr>
			<tr>
				<td style="padding-left:20px;">판매가 : {{sale_price}} 원</td>
			</tr>
			<tr>
				<td style="padding-left:20px;">설명 : {{description}}</td>
			</tr>
		</table>
		{{/channel.item}}
	</script>
    <script type="text/javascript">
    	$(function() {
    		
    		$("#orders").on('click', function(e) {
    			e.preventDefault();
    			
    			if(${loginInfo.id == null}) {
    				swal('로그인 후 이용가능합니다.');
    				return false;
    			}
    			if(${loginInfo.id == product.seller_id}) {
    				swal('회원님의 상품입니다.');
    				return false;
    			}
    			
    			$.get("${pageContext.request.contextPath}/shop/cart_insert.do", {
    				product_id : "${product.id}",
    				add_id : "${loginInfo.id}"
    			}, function(res) {
    				if(res.rt != 'OK'){
    					alert(res.rt);
    					return false;
    				}
    				window.location.href="${pageContext.request.contextPath}/shop/order_confirm.do?add_id=${loginInfo.id}&cart_id="+res.cart_id;;
    			});
    			
    			
    		});
    		
    		
    		$("#insert_cart").on('click', function(e) {
    			e.preventDefault();
    			
    			if(${loginInfo.id == null}) {
    				swal('로그인 후 이용가능합니다.');
    				return false;
    			}
    			if(${loginInfo.id == product.seller_id}) {
    				swal('회원님의 상품입니다.');
    				return false;
    			}
    			
   				$.get("${pageContext.request.contextPath}/shop/cart_insert.do", {
    				product_id : "${product.id}",
    				add_id : "${loginInfo.id}"
    			}, function(res) {
    				if(res.rt != 'OK'){
    					alert(res.rt);
    					return false;
    				}
    				swal({
					  	title: "장바구니에 담았습니다.",
					  	text: "장바구니로 이동하시겠습니까?",
					  	type: "info",
					  	showCancelButton: true,
					  	confirmButtonClass: "btn-info",
					  	confirmButtonText: "장바구니 이동",
					  	closeOnConfirm: true,
					  	cancelButtonClass: "btn-warning",
					  	cancelButtonText: "계속 쇼핑"
   					},
   					function(){
   					  	window.location.href="${pageContext.request.contextPath}/shop/cart_list.do?add_id=${loginInfo.id}";
   					});
    			});
   			});
    		
    		$.get("${pageContext.request.contextPath}/shop/product_info.do", {
    			csurl: 'http://apis.daum.net/search/book',
    			apikey: '382d9c576439bf6472525618ea814aff',
    			q: '${product.product_name}',
    			result: 1, 
    			output: 'json'
    		}, function(res) {
    			
    			var template = Handlebars.compile($("#info_template").html());
    			var html = template(res);
    			
    			$("#product_info").append(html);
    		});
    		
    	});
    </script>
</body>

</html>
