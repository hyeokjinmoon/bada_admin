package com.bada.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada.dao.MyBatisConnectionFactory;
import com.bada.helper.BaseController;
import com.bada.helper.WebHelper;
import com.bada.model.Member;
import com.bada.model.SalesRequest;
import com.bada.service.SalesRequestService;
import com.bada.service.impl.SalesRequestServiceImpl;

@WebServlet("/member/sale_request_view.do")
public class SaleRequestView extends BaseController {

	private static final long serialVersionUID = -423487198628075837L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	SalesRequestService salesRequestService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		salesRequestService = new SalesRequestServiceImpl(sqlSession, logger);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		
		if(id == 0) {
			sqlSession.close();
			web.redirect(null, "신청 번호가 없습니다.");
			return null;
		}
		
		SalesRequest salesRequest = new SalesRequest();
		salesRequest.setId(id);
		
		SalesRequest sales = null;
		try {
			sales = salesRequestService.selectSaleRequestView(salesRequest);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("sales", sales);
		
		return "/member/sale_request_view";
	}

}
