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
import com.bada_admin.helper.PageHelper;
import com.bada_admin.helper.WebHelper;
import com.bada_admin.model.Member;
import com.bada_admin.model.NoticeFaq;
import com.bada_admin.service.NoticeFaqService;
import com.bada_admin.service.impl.NoticeFaqServiceImpl;

@WebServlet("/board_manage/noti_faq_list.do")
public class NoticeFaqList extends BaseController {

	private static final long serialVersionUID = -5515122200787012967L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	NoticeFaqCommon board;
	PageHelper pageHelper;
	NoticeFaqService noticeFaqService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		board = NoticeFaqCommon.getInstance();
		pageHelper = PageHelper.getInstance();
		noticeFaqService = new NoticeFaqServiceImpl(sqlSession, logger);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후에 이용가능합니다.");
			return null;
		}
		
		String category = web.getString("category");
		request.setAttribute("category", category);
		
		try {
			String boardName = board.getBoardName(category);
			request.setAttribute("boardName", boardName);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		int page = web.getInt("page", 1);
		int totalCount = 0;
		NoticeFaq noticeFaq = new NoticeFaq();
		noticeFaq.setCategory(category);
		
		
		List<NoticeFaq> noticeFaqList = null;
		
		try {
			totalCount = noticeFaqService.selectNoticeFaqCount(noticeFaq);
			
			pageHelper.pageProcess(page, totalCount, 7, 5);
			
			noticeFaq.setLimitStart(pageHelper.getLimitStart());
			noticeFaq.setListCount(pageHelper.getListCount());
			
			noticeFaqList = noticeFaqService.selectNoticeFaqList(noticeFaq);
			
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("noticeFaqList", noticeFaqList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "board_manage/noti_faq_list";
	}

}
