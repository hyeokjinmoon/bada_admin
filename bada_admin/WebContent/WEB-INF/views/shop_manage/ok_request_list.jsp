<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="/WEB-INF/inc/head.jsp" %>
    
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
                <div class="textps page-header">
                  <h1>승인요청 관리</h1>
                </div>
                <div class="dropps pull-right">
                    <select name="telecom" id="telecom">
                        <option value="new">최근 1개월</option>
                        <option value="top">최근 3개월</option>
                        <option value="row">최근 6개월</option>
                    </select>
                    </div>
                <!--메인영역-->

                    <!-- 버튼 끝-->
                    <div class="table">
                        <table class="table-hover table">
                            <thead style="background-color : #ddd;">
                                <tr>
                                    <td width="30%" class="textheade">표지</td>
                                    <td class="textheade">제목</td>
                                    <td class="textheade">가격</td>
                                    <td class="textheade">요청일시</td>
                                    <td class="textheade">구매자</td>
                                </tr>
                            </thead>
                            <tbody>
                                
                            </tbody>
                        </table>
                    </div>
                <!--메인영역끝-->
                <!--페이저 시작-->
                 <nav class="pageps">
                        <ul class="pagination">
                           <li>
                           <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            </a>
                            </li>
                            <li><a href="#">1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li><a href="#">4</a>
                            </li>
                            <li><a href="#">5</a>
                            </li>
                            <li><a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            </a></li>
                        </ul>
                    </nav>
                <!--페이저 끝-->
                <%@ include file="/WEB-INF/inc/footer.jsp" %>
                <!-- 작성 영역 끝 -->

            </div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->
</body>

</html>
