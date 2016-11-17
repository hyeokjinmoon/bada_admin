package com.bada_admin.controller.member_manage;

import java.io.IOException;

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
import com.bada_admin.model.SalesRequest;
import com.bada_admin.service.SalesRequestService;
import com.bada_admin.service.impl.SalesRequestServiceImpl;

@WebServlet("/member_manage/sales_request_view.do")
public class SalesRequestView extends BaseController {

	private static final long serialVersionUID = 3212331174454253301L;
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
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		
		if(id == 0) {
			sqlSession.close();
			web.redirect(null, "조회할 판매 신청이 없습니다.");
			return null;
		}
		
		SalesRequest salesRequest = new SalesRequest();
		salesRequest.setId(id);
		
		SalesRequest salesRequestView = null;
		
		try {
			salesRequestView = salesRequestService.selectSalesRequestView(salesRequest);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("salesRequest", salesRequestView);
		
		return "member_manage/sales_request_view";
	}

}
