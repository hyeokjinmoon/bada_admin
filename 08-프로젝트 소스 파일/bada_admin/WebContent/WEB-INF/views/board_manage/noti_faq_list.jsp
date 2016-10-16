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
                <div class="page-header">
                  <h1>${boardName} 목록</h1>
                </div>
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead style="background-color : #eee;">
                            <tr>

                                <th class="text-center" width="15%">No.</th>
                                <th class="text-center" width="40%">제목</th>
                                 <th class="text-center" width="15%">작성일</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr align="center">
                                <td>07</td>
                                <td><a href="#">제목입니다.</a></td>
                                <td>2016.09.13</td>
                            </tr>
                            <tr align="center">
                                <td>06</td>
                                <td><a href="#">제목입니다.</a></td>
                                <td>2016.09.13</td>
                            </tr>
                            <tr align="center">
                                 <td>05</td>
                                <td><a href="#">제목입니다.</a></td>
                                <td>2016.09.13</td>
                            </tr>
                            <tr align="center">
                                <td>04</td>
                                <td><a href="#">제목입니다.</a></td>
                                <td>2016.09.13</td>
                            </tr>
                            <tr align="center">
                                <td>03</td>
                                <td><a href="#">제목입니다.</a></td>
                                <td>2016.09.13</td>
                            </tr>
                            <tr align="center">
                                <td>02</td>
                                <td><a href="#">제목입니다.</a></td>
                                <td>2016.09.13</td>
                            </tr>
                            <tr align="center">
                                 <td>01</td>
                                <td><a href="#">제목입니다.</a></td>
                                <td>2016.09.13</td>
                            </tr>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="5" class="text-center">
                                    <nav aria-label="Page navigation">
                                      <ul class="pagination">
                                        <li class="previous disabled"><a href="#"><span aria-hidden="true">&larr;</span> 이전</a></li>
                                        <li class="active"><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li class="next"><a href="#">다음 <span aria-hidden="true">&rarr;</span></a></li>
                                      </ul>
                                    </nav>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                    <div class="delete-btn">
                        <a href="${pageContext.request.contextPath}/board_manage/noti_faq_write.do?category=${category}" class="btn btn-primary" id="button">글작성</a>
                     </div>
                </div>
                <%@ include file="/WEB-INF/inc/footer.jsp" %>
                <!-- 작성 영역 끝 -->
			</div>
            <!-- 메인 컨텐츠 영역 끝 -->
        </div>
    </div>
    <!-- 컨테이너 끝 -->

</body>

</html>
