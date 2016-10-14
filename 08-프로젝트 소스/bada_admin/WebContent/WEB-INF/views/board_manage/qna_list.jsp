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
                  <h1>1:1문의</h1>
                </div>
                 <div class="table-responsive">
                    <table class="table table-hover">
                        <thead style="background-color : #eee;">
                            <tr>
                                <th class="text-center" width="20%">작성자</th>
                                <th class="text-center" width="15%">문의종류</th>
                                <th class="text-center" width="35%">문의내용</th>
                                <th class="text-center" width="20%">작성일시</th>
                                <th class="text-center" width="10%">답변</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr align="center">

                                <td>naver   </td>
                                <td>기타</td>
                                <td><a href="#">거래는 어떤식으로 이루어 지나요</a></td>
                                <td>2016.09.05  </td>
                                <td>O</td>

                            </tr>
                             <tr align="center">

                                <td>daum   </td>
                                <td>금액</td>
                                <td> <a href="#">금액은 어떤식으로 정해지나요 </a> </td>

                                <td>2016.07.05</td>
                                <td>X</td>

                            </tr>
                             <tr align="center">

                                <td> nate  </td>
                                <td>배송</td>

                                <td><a href="#">배송 언재쯤 되나요 </a> </td>



                                <td> 2016.07.05</td>
                                <td>X</td>

                            </tr>
                               <tr align="center">

                                <td> google@gmail.com   </td>
                                <td>환불</td>

                                <td><a href="#">환불가능 한가요? </a>  </td>


                                <td>2016.06.05</td>
                                <td>X</td>

                            </tr>
                                <tr align="center">

                                <td>tiese </td>
                                <td>환불</td>
                                <td><a href="#">환불가능 한가요? </a>  </td>



                                <td>2016.06.05</td>
                                <td>X</td>

                            </tr>
                               <tr align="center">

                                <td>  greencom  </td>
                                <td>환불</td>

                                <td><a href="#">환불가능 한가요?  </a> </td>

                                <td>2016.06.05</td>
                                <td>X</td>

                            </tr>
                               <tr align="center">

                                <td> chang  </td>
                                <td>환불</td>

                                <td><a href="#">환불가능 한가요? </a>  </td>


                               <td>2016.06.05</td>
                                <td>X</td>

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
