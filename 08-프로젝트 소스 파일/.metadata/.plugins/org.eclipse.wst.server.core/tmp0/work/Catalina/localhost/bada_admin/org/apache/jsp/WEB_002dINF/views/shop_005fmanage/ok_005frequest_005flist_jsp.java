/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.37
 * Generated at: 2016-10-16 12:40:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.shop_005fmanage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ok_005frequest_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/inc/topnav.jsp", Long.valueOf(1476617369000L));
    _jspx_dependants.put("/WEB-INF/inc/sidenav.jsp", Long.valueOf(1476574985000L));
    _jspx_dependants.put("/WEB-INF/inc/footer.jsp", Long.valueOf(1476279054000L));
    _jspx_dependants.put("/WEB-INF/inc/head.jsp", Long.valueOf(1476544710000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ko\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    ");
      out.write("<meta charset=\"utf-8\"/>\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n");
      out.write("<title>BaDa ADMIN</title>\n");
      out.write("\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no\">\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css\">\n");
      out.write("<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- 기본 css -->\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/css/common_admin.css\">\n");
      out.write("\n");
      out.write("<!--[if lt IE 9]>\n");
      out.write("\t<script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.2/html5shiv.js\"></script>\n");
      out.write("\t<script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\n");
      out.write("<![endif]-->\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- 다음 주소 api -->\n");
      out.write("<script src=\"http://dmaps.daum.net/map_js_init/postcode.v2.js\"></script>\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/js/daumPostCode.js\"></script>\n");
      out.write("\n");
      out.write("<!-- sweetalert -->\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/css/sweetalert.css\">\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/assets/js/sweetalert.min.js\"></script>\n");
      out.write("\n");
      out.write("<!-- ckeditor -->\n");
      out.write("<script src=\"http://cdn.ckeditor.com/4.5.11/basic/ckeditor.js\"></script>\n");
      out.write("\n");
      out.write("<!-- google analytics -->\n");
      out.write("<script>\n");
      out.write("\t(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n");
      out.write("\t(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n");
      out.write("\tm=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n");
      out.write("\t})(window,document,'script','https://www.google-analytics.com/analytics.js','ga');\n");
      out.write("\t\n");
      out.write("\tga('create', 'UA-85741327-1', 'auto');\n");
      out.write("\tga('send', 'pageview');\n");
      out.write("</script>\n");
      out.write("    \t\n");
      out.write("\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    ");
      out.write("<!-- 로고, 상단 네비게이션 바 -->\n");
      out.write("<nav class=\"navbar navbar-inverse navbar-fixed-top\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"navbar-header\">\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("                <span class=\"sr-only\">메뉴 열기</span>\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("            </button>\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">BaDa\n");
      out.write("                <span class=\"small\">ADMIN</span>\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"navbar-right\" style=\"margin-right: 50px;\">\n");
      out.write("\t    \t<a href=\"#\" class=\"dropdown-toggle navbar-link navbar-btn btn navbar-admin\" data-toggle=\"dropdown\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 님 <span class=\"caret\"></span></a>\n");
      out.write("\t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/logout.do\">로그아웃</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("      \t</div>\n");
      out.write("\t\t<div id=\"navbar\" class=\"navbar-collapse collapse\">\n");
      out.write("        \t<ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("        \t\t<li>\n");
      out.write("        \t\t\t<a href=\"#\" class=\"dropdown-toggle navbar-link\" data-toggle=\"dropdown\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginInfo.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 님 <span class=\"caret\"></span></a>\n");
      out.write("\t\t\t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/logout.do\">로그아웃</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("        \t\t</li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board_manage/dashboard.do\">대시보드</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#collapse-nav-item-shop\" data-toggle=\"collapse\">쇼핑몰 관리</a>\n");
      out.write("                    <ul class=\"nav navbar-nav-inner collapse\" id=\"collapse-nav-item-shop\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shop_manage/order_list.do\">주문목록</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shop_manage/trade_list.do\">거래목록</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shop_manage/product_list.do\">상품목록</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shop_manage/ok_request_list.do\">승인요청목록</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shop_manage/deposit_list.do\">입금현황</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shop_manage/delivery_list.do\">배송현황</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#collapse-nav-item-board\" data-toggle=\"collapse\">게시판 관리</a>\n");
      out.write("                    <ul class=\"nav navbar-nav-inner collapse\" id=\"collapse-nav-item-board\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board_manage/qna_list.do\">1:1문의</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board_manage/noti_faq_list.do?category=notice\">공지사항</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board_manage/noti_faq_list.do?category=faq\">자주묻는질문</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"#collapse-nav-item-member\" data-toggle=\"collapse\">회원 관리</a>\n");
      out.write("                    <ul class=\"nav navbar-nav-inner collapse\" id=\"collapse-nav-item-member\">\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member_manage/member_list.do\">회원목록</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member_manage/message_list.do\">쪽지목록</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>\n");
      out.write("<!-- 로고, 상단 네비게이션 바 끝 -->\n");
      out.write("<!-- 컨테이너 영역 -->\n");
      out.write("    <div class=\"container\">\n");
      out.write("        ");
      out.write("<!-- 사이드 네비게이션 바 -->\n");
      out.write("<div class=\"col-sm-2 col-md-2 sidebar\">\n");
      out.write("    <ul class=\"nav nav-sidebar\">\n");
      out.write("        <li>\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board_manage/dashboard.do\">대시보드</a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"#collapse-item-shop\" data-toggle=\"collapse\">쇼핑몰 관리</a>\n");
      out.write("            <ul class=\"nav nav-sidebar-inner collapse\" id=\"collapse-item-shop\">\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shop_manage/order_list.do\">주문목록</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shop_manage/trade_list.do\">거래목록</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shop_manage/product_list.do\">상품목록</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shop_manage/ok_request_list.do\">승인요청목록</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shop_manage/deposit_list.do\">입금현황</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/shop_manage/delivery_list.do\">배송현황</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"#collapse-item-board\" data-toggle=\"collapse\">게시판 관리</a>\n");
      out.write("            <ul class=\"nav nav-sidebar-inner collapse\" id=\"collapse-item-board\">\n");
      out.write("\t            <li>\n");
      out.write("\t                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board_manage/qna_list.do\">1:1문의</a>\n");
      out.write("\t            </li>\n");
      out.write("\t            <li>\n");
      out.write("\t                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board_manage/noti_faq_list.do?category=notice\">공지사항</a>\n");
      out.write("\t            </li>\n");
      out.write("\t            <li>\n");
      out.write("\t                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board_manage/noti_faq_list.do?category=faq\">자주묻는질문</a>\n");
      out.write("\t            </li>\n");
      out.write("            </ul>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"#collapse-item-user\" data-toggle=\"collapse\">회원 관리</a>\n");
      out.write("            <ul class=\"nav nav-sidebar-inner collapse\" id=\"collapse-item-user\">\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member_manage/member_list.do\">회원목록</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member_manage/message_list.do\">쪽지목록</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </li>\n");
      out.write("    </ul>\n");
      out.write("</div>\n");
      out.write("<!-- 사이트 네비게이션 바 끝 -->\n");
      out.write("<div class=\"row\">\n");
      out.write("            <!-- 메인 컨텐츠 영역 -->\n");
      out.write("            <div class=\"col-sm-offset-2 col-md-offset-2 main-content\">\n");
      out.write("\n");
      out.write("                <!-- 작성 영역 -->\n");
      out.write("                <div class=\"textps page-header\">\n");
      out.write("                  <h1>승인요청 관리</h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"dropps pull-right\">\n");
      out.write("                    <select name=\"telecom\" id=\"telecom\">\n");
      out.write("                        <option value=\"new\">최근 1개월</option>\n");
      out.write("                        <option value=\"top\">최근 3개월</option>\n");
      out.write("                        <option value=\"row\">최근 6개월</option>\n");
      out.write("                    </select>\n");
      out.write("                    </div>\n");
      out.write("                <!--메인영역-->\n");
      out.write("\n");
      out.write("                    <!-- 버튼 끝-->\n");
      out.write("                    <div class=\"table\">\n");
      out.write("                        <table class=\"table-hover table\">\n");
      out.write("                            <thead style=\"background-color : #ddd;\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td width=\"30%\" class=\"textheade\">표지</td>\n");
      out.write("                                    <td class=\"textheade\">제목</td>\n");
      out.write("                                    <td class=\"textheade\">가격</td>\n");
      out.write("                                    <td class=\"textheade\">요청일시</td>\n");
      out.write("                                    <td class=\"textheade\">구매자</td>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                \n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                <!--메인영역끝-->\n");
      out.write("                <!--페이저 시작-->\n");
      out.write("                 <nav class=\"pageps\">\n");
      out.write("                        <ul class=\"pagination\">\n");
      out.write("                           <li>\n");
      out.write("                           <a href=\"#\" aria-label=\"Previous\">\n");
      out.write("                            <span aria-hidden=\"true\">&laquo;</span>\n");
      out.write("                            </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"#\">1</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"#\">2</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"#\">3</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"#\">4</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"#\">5</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li><a href=\"#\" aria-label=\"Next\">\n");
      out.write("                            <span aria-hidden=\"true\">&raquo;</span>\n");
      out.write("                            </a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("                <!--페이저 끝-->\n");
      out.write("                ");
      out.write("<!-- Footer 영역 시작 -->\n");
      out.write("<hr>\n");
      out.write("<footer>\n");
      out.write("    <address>\n");
      out.write("        Copyright&copy; 2016 <strong class=\"text-primary\">BaDa</strong> All rights reserved.\n");
      out.write("    </address>\n");
      out.write("</footer>\n");
      out.write("<!-- Footer 영역 끝 -->");
      out.write("<!-- 작성 영역 끝 -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- 메인 컨텐츠 영역 끝 -->\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- 컨테이너 끝 -->\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
