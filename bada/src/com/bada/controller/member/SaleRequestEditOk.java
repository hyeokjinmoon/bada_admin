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
import com.bada.helper.RegexHelper;
import com.bada.helper.WebHelper;
import com.bada.model.Member;
import com.bada.model.SalesRequest;
import com.bada.service.SalesRequestService;
import com.bada.service.impl.SalesRequestServiceImpl;

@WebServlet("/member/sale_request_edit_ok.do")
public class SaleRequestEditOk extends BaseController {

	private static final long serialVersionUID = 5984497558635737961L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	RegexHelper regex;
	SalesRequestService salesRequestService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		salesRequestService = new SalesRequestServiceImpl(sqlSession, logger);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		String sales_type = web.getString("sales_type");
		String book_list = web.getString("book_list");
		String pickup_date = web.getString("pickup_date");
		int member_id = web.getInt("member_id");
		String postcode = web.getString("postcode");
		String addr1 = web.getString("addr1");
		String addr2 = web.getString("addr2");
		String pickup_addr = "(" + postcode + ") " + addr1 + " " + addr2; 
		
		if(!regex.isValue(sales_type)) {
			sqlSession.close();
			web.redirect(null, "신청 유형을 선택해주세요.");
			return null;
		}
		if(!regex.isValue(book_list)) {
			sqlSession.close();
			web.redirect(null, "판매 목록을 입력해주세요.");
			return null;
		}
		if(!regex.isValue(pickup_date)) {
			sqlSession.close();
			web.redirect(null, "수거 가능일을 지정해주세요.");
			return null;
		}
		if(!regex.isValue(pickup_addr)) {
			sqlSession.close();
			web.redirect(null, "방문 수거지를 입력해주세요.");
			return null;
		}
		
		SalesRequest salesRequest = new SalesRequest();
		salesRequest.setId(id);
		salesRequest.setBook_list(book_list);
		salesRequest.setMember_id(member_id);
		salesRequest.setPickup_addr(pickup_addr);
		salesRequest.setPickup_date(pickup_date);
		salesRequest.setSales_type(sales_type);
		
		try {
			salesRequestService.updateSalesRequest(salesRequest);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		String url = web.getRootPath() + "/member/sale_request_view.do?id=" + salesRequest.getId();
		
		web.redirect(url, "수정되었습니다.");
		
		return null;
	}

}
