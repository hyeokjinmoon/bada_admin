package com.bada_admin.controller.member_manage;

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
import com.bada_admin.helper.PageHelper;
import com.bada_admin.helper.WebHelper;
import com.bada_admin.model.SalesRequest;
import com.bada_admin.service.SalesRequestService;
import com.bada_admin.service.impl.SalesRequestServiceImpl;

@WebServlet("/member_manage/sales_request_list.do")
public class SalesRequestList extends BaseController {

	private static final long serialVersionUID = 1319799647346022305L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	PageHelper pageHelper;
	SalesRequestService salesRequestService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		pageHelper = PageHelper.getInstance();
		salesRequestService = new SalesRequestServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int page = web.getInt("page", 1);
		int totalCount = 0;
		
		SalesRequest salesRequest = new SalesRequest();
		
		List<SalesRequest> salesRequestList = null;
		
		try {
			totalCount = salesRequestService.selectSalesRequestCount(salesRequest);
			pageHelper.pageProcess(page, totalCount, 8, 5);
			salesRequest.setLimitStart(pageHelper.getLimitStart());
			salesRequest.setListCount(pageHelper.getListCount());
			
			salesRequestList = salesRequestService.selectSalesRequestList(salesRequest);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("salesRequestList", salesRequestList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "member_manage/sales_request_list";
	}

}
