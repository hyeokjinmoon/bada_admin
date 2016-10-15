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
                        <h1>승인/거절</h1>
                    </div>
                        <!--메인영역 시작-->
                        <!--메인영역 사진-->
                    <div>
                        <div>
                            <img src="logo.png" alt="대표 사진" class="imgps col-md-6">
                        </div>
                        <div>
                            <ul>
                                 <li><h3>칭찬은 고래도 춤추게 한다</h3></li>
                                 <li><p>등록일:2016-09-19</p></li>
                                 <li><p>판매자: 해밍웨이</p></li>
                                 <li><p>정가: 300,000</p></li>
                                 <li><p>판매가:10,000</p></li>
                                 <li><button type="button" class="btn btn-info">승인</button>
                                 <button type="button" class="btn btn-info">거절</button></li>
                            </ul>

                        </div>
                        <hr/>
                     <!--책정보-->
                     <div>
                         <h1>책 정보</h1>
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
