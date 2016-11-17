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

            <%@ include file="/WEB-INF/views/inc/sidebar_info.jsp" %>

            <!-- 메인 컨텐츠 영역 시작 -->
            <div class="col-sm-9 col-md-10 main-content">
                <div class="page-header clearfix">
                    <h2>판매 및 신청 내역</h2>
                </div>
                <div class="table-responsive ">
                    <table class="table table-hover">
                        <thead>
                            <tr class="bg-primary">
                                <th class="text-center" width="40%">상품명</th>
                                <th class="text-center" width="30%">등록일시</th>
                                <th class="text-center" width="15%">승인상태</th>
                                <th class="text-center" width="15%">판매상태</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:choose>
                        		<c:when test="${fn:length(productList) == 0 }">
                        			<tr align="center"  valign="middle">
                        				<td colspan="4" height="150">
                        					<h4>신청 목록이 없습니다.</h4>
                        				</td>
                        			</tr>
                        		</c:when>
                        		<c:otherwise>
		                            <c:forEach var="product" items="${productList}">
		                            	<tr align="center">
											<td class="subject">
		                               	    	<c:url var="viewUrl" value="/shop/product_view.do">
		                               	    		<c:param name="id" value="${product.id}" />
								            	</c:url>
			                                	<a href="${viewUrl}">${product.product_name}</a>
		                                	</td>
		                                	<td>
				                               	${product.reg_date}
			                                </td>
			                                <td><!-- 승인 상태 : 승인="O", 승인대기="W", 거절="R" -->
			                                	<c:choose>
			                                		<c:when test="${product.ok_status == 'O'}">
			                                			<span class="text-success">승인</span>
			                                		</c:when>
			                                		<c:when test="${product.ok_status == 'W'}">
			                                			<span class="text-warning">승인대기</span>
			                                		</c:when>
			                                		<c:when test="${product.ok_status == 'R'}">
			                                			<span class="text-danger">승인거절</span>
			                                		</c:when>
			                                	</c:choose>
			                                </td>
			                                <td><!-- 제품 상태 : 판매중="S", 판매대기="W", 판매완료="C", 판매거절="R" -->
			                                	<c:choose>
			                                		<c:when test="${product.product_status == 'S'}">
			                                			<span class="text-primary">판매중</span>
			                                		</c:when>
			                                		<c:when test="${product.product_status == 'W'}">
			                                			<span class="text-warning">판매대기</span>
			                                		</c:when>
			                                		<c:when test="${product.product_status == 'C'}">
			                                			<span class="text-info">판매완료</span>
			                                		</c:when>
			                                		<c:when test="${product.product_status == 'R'}">
			                                			<span class="text-danger">판매거절</span>
			                                		</c:when>
			                                	</c:choose>
			                                </td>
										</tr>
		                            </c:forEach>
	                            </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>

                </div>
            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
            <!-- 페이지 번호 시작 -->
				<nav class="text-center">
					<ul class="pagination">
						<!-- 이전 그룹으로 이동 -->
						<c:choose>
							<c:when test="${pageHelper.prevPage > 0}">
								<!-- 이전 그룹에 대한 페이지 번호가 존재한다면? -->
								<!-- 이전 그룹으로 이동하기 위한 URL을 생성해서 "prevUrl"에 저장 -->
								<c:url var="prevUrl" value="/shop/sale_list.do">
									<c:param name="page" value="${pageHelper.prevPage}" />
								</c:url>
				
								<li><a href="${prevUrl}">&laquo;</a></li>
							</c:when>
				
							<c:otherwise>
								<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
								<li class='disabled'><a href="#">&laquo;</a></li>
							</c:otherwise>
						</c:choose>
							
						<!-- 페이지 번호 -->
						<!-- 현재 그룹의 시작페이지~끝페이지 사이를 1씩 증가하면서 반복 -->
						<c:forEach var="i" begin="${pageHelper.startPage}" end="${pageHelper.endPage}" step="1">
				
							<!-- 각 페이지 번호로 이동할 수 있는 URL을 생성하여 page_url에 저장 -->
							<c:url var="pageUrl" value="/shop/sale_list.do" >
								<c:param name="page" value="${i}"></c:param>
							</c:url>
								
							<!-- 반복중의 페이지 번호와 현재 위치한 페이지 번호가 같은 경우에 대한 분기 -->
							<c:choose>
								<c:when test="${pageHelper.page == i}">
									<li class='active'><a href="#">${i}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${pageUrl}">${i}</a></li>
								</c:otherwise>
							</c:choose>	
				
						</c:forEach>
							
						<!-- 다음 그룹으로 이동 -->
						<c:choose>
							<c:when test="${pageHelper.nextPage > 0}">
								<!-- 다음 그룹에 대한 페이지 번호가 존재한다면? -->
								<!-- 다음 그룹으로 이동하기 위한 URL을 생성해서 "nextUrl"에 저장 -->
								<c:url var="nextUrl" value="/shop/sale_list.do">
									<c:param name="page" value="${pageHelper.nextPage}"></c:param>
								</c:url>
				
								<li><a href="${nextUrl}">&raquo;</a></li>
							</c:when>
				
							<c:otherwise>
								<!-- 이전 그룹에 대한 페이지 번호가 존재하지 않는다면? -->
								<li class='disabled'><a href="#">&raquo;</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</nav>
				<!--// 페이지 번호 끝 -->

        </div>
        <!-- Grid Row 끝 -->

        <%@ include file="/WEB-INF/views/inc/footer.jsp" %>
    </div>
    
</body>

</html>
