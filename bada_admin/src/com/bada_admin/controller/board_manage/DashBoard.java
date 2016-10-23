package com.bada_admin.controller.board_manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada_admin.dao.MyBatisConnectionFactory;
import com.bada_admin.helper.BaseController;
import com.bada_admin.helper.WebHelper;
import com.bada_admin.model.Member;
import com.bada_admin.model.Orders;
import com.bada_admin.model.Product;
import com.bada_admin.model.Qna;
import com.bada_admin.service.MemberService;
import com.bada_admin.service.OrdersService;
import com.bada_admin.service.ProductService;
import com.bada_admin.service.QnaService;
import com.bada_admin.service.impl.MemberServiceImpl;
import com.bada_admin.service.impl.OrdersServiceImpl;
import com.bada_admin.service.impl.ProductServiceImpl;
import com.bada_admin.service.impl.QnaServiceImpl;

@WebServlet("/board_manage/dashboard.do")
public class DashBoard extends BaseController {

	private static final long serialVersionUID = -2869124779717150415L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	MemberService memberService;
	QnaService qnaService;
	ProductService productService;
	OrdersService ordersService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		memberService = new MemberServiceImpl(sqlSession, logger);
		qnaService = new QnaServiceImpl(sqlSession, logger);
		productService = new ProductServiceImpl(sqlSession, logger);
		ordersService = new OrdersServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		List<Member> memberList = null;
		List<Qna> qnaList = null;
		List<Product> productList = null;
		List<Orders> ordersList = null;
		
		try {
			memberList = memberService.selectMemberDashboard(null);
			qnaList = qnaService.selectQnaDashboard(null);
			productList = productService.selectProductDashboard(null);
			ordersList = ordersService.selectOrdersDashboard(null);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("memberList", memberList);
		request.setAttribute("qnaList", qnaList);
		request.setAttribute("productList", productList);
		request.setAttribute("ordersList", ordersList);
		
		return "board_manage/dashboard";
	}

}
