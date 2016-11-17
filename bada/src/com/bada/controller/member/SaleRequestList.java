package com.bada.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada.dao.MyBatisConnectionFactory;
import com.bada.helper.BaseController;
import com.bada.helper.PageHelper;
import com.bada.helper.WebHelper;
import com.bada.model.Member;
import com.bada.model.SalesRequest;
import com.bada.service.SalesRequestService;
import com.bada.service.impl.SalesRequestServiceImpl;

@WebServlet("/member/sale_request_list.do")
public class SaleRequestList extends BaseController {

	private static final long serialVersionUID = -5387525140858555765L;
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
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int member_id = loginInfo.getId();
		
		int page = web.getInt("page", 1);
		int totalCount = 0;
		
		SalesRequest salesRequest = new SalesRequest();
		salesRequest.setMember_id(member_id);
		
		List<SalesRequest> salesList = null;
		try {
			totalCount = salesRequestService.selectSalesRequestCount(salesRequest);
			pageHelper.pageProcess(page, totalCount, 8, 5);
			salesRequest.setLimitStart(pageHelper.getLimitStart());
			salesRequest.setListCount(pageHelper.getListCount());
			
			salesList = salesRequestService.selectSalesRequestList(salesRequest);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("salesList", salesList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "/member/sale_request_list";
	}

}
