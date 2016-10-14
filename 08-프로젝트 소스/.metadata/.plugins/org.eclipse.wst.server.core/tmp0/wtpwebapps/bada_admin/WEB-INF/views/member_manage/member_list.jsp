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
                  <h1>회원목록</h1>
                </div>
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead style="background-color : #eee;">
                            <tr>

                                <th class="text-center" width="25%">아이디</th>
                                <th class="text-center" width="25%">이름</th>
                                <th class="text-center" width="25%">이메일</th>
                                <th class="text-center" width="25%">등록일</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr align="center">
                                <td class="text-center">유아인</td>
                                <td><a href="#">회원이름</a></td>
                                <td>이메일</td>
                                <td>2016.01.01</td>
                            </tr>
                            <tr align="center">
                            <td class="text-center">유아인</td>
                                <td><a href="#">회원이름</a></td>
                                <td>이메일</td>
                                <td>2016.01.01</td>
                            </tr>
                            <tr align="center">
                            <td class="text-center">유아인</td>
                                <td><a href="#">회원이름</a></td>
                                <td>이메일</td>
                                <td>2016.01.01</td>
                            </tr>
                            <tr align="center">
                            <td class="text-center">유아인</td>
                                <td><a href="#">회원이름</a></td>
                                <td>이메일</td>
                                <td>2016.01.01</td>
                            </tr>
                            <tr align="center">
                            <td class="text-center">유아인</td>
                                <td><a href="#">회원이름</a></td>
                                <td>이메일</td>
                                <td>2016.01.01</td>
                            </tr>
                            <tr align="center">
                            <td class="text-center">유아인</td>
                                <td><a href="#">회원이름</a></td>
                                <td>이메일</td>
                                <td>2016.01.01</td>
                            </tr>
                            <tr align="center">
                            <td class="text-center">유아인</td>
                                <td><a href="#">회원이름</a></td>
                                <td>이메일</td>
                                <td>2016.01.01</td>
                            </tr>
                             <tr align="center">
                            <td class="text-center">유아인</td>
                                <td><a href="#">회원이름</a></td>
                                <td>이메일</td>
                                <td>2016.01.01</td>
                            </tr>
                             <tr align="center">
                            <td class="text-center">유아인</td>
                                <td><a href="#">회원이름</a></td>
                                <td>이메일</td>
                                <td>2016.01.01</td>
                            </tr>
                             <tr align="center">
                            <td class="text-center">유아인</td>
                                <td><a href="#">회원이름</a></td>
                                <td>이메일</td>
                                <td>2016.01.01</td>
                            </tr>
                             <tr align="center">
                            <td class="text-center">유아인</td>
                                <td><a href="#">회원이름</a></td>
                                <td>이메일</td>
                                <td>2016.01.01</td>
                            </tr>
                             <tr align="center">
                            <td class="text-center">유아인</td>
                                <td><a href="#">회원이름</a></td>
                                <td>이메일</td>
                                <td>2016.01.01</td>
                            </tr>

                        </tbody>
                        <tfoot class="clearfix">
                            <tr>
                                <td colspan="5" class="bor text-center">
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
