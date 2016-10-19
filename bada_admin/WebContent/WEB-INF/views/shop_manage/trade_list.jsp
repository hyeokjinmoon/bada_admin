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
                  <h1>최근 거래내역</h1>
                </div>
                <div class="dropps col-md-offset-10">
                        <select name="telecom" id="telecom" class="form-control">
                            <option value="new">최근 1개월</option>
                            <option value="top">최근 3개월</option>
                            <option value="row">최근 6개월</option>
                        </select>
                    </div>
                 <div class="table-responsive">
                    <table class="table table-hover">
                        <thead style="background-color : #eee;">
                            <tr>
                                <th class="text-center" width="15%">아이디</th>
                                <th class="text-center" width="20%">닉네임</th>
                                <th class="text-center" width="20%">SNS로그인</th>
                                <th class="text-center" width="20%">거래날짜</th>
                                <th class="text-center" width="15%">금액</th>
                                <th class="text-center" width="20%">거래상품</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr align="center">
                                <td>naver</td>
                                <td>daum</td>
                                <td>X</td>
                                <td>2016.09.01</td>
                                <td>20000원</td>
                                <td>자바의정석</td>

                            </tr>
                              <tr align="center">
                                <td>naver</td>
                                <td>daum</td>
                                <td>X</td>
                                <td>2016.09.01</td>
                                <td>20000원</td>
                                <td>자바의정석</td>

                            </tr>
                              <tr align="center">
                                <td>naver</td>
                                <td>daum</td>
                                <td>X</td>
                                <td>2016.09.01</td>
                                <td>20000원</td>
                                <td>자바의정석</td>

                            </tr>
                              <tr align="center">
                                <td>naver</td>
                                <td>daum</td>
                                <td>X</td>
                                <td>2016.09.01</td>
                                <td>20000원</td>
                                <td>자바의정석</td>

                            </tr>
                              <tr align="center">
                                <td>naver</td>
                                <td>daum</td>
                                <td>X</td>
                                <td>2016.09.01</td>
                                <td>20000원</td>
                                <td>자바의정석</td>

                            </tr>
                              <tr align="center">
                                <td>naver</td>
                                <td>daum</td>
                                <td>X</td>
                                <td>2016.09.01</td>
                                <td>20000원</td>
                                <td>자바의정석</td>

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
                    <div class="in write-btn">

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
