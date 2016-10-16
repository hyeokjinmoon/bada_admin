package com.bada_admin.controller.board_manage;

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
import com.bada_admin.model.Member;
import com.bada_admin.model.NoticeFaq;
import com.bada_admin.service.NoticeFaqService;
import com.bada_admin.service.impl.NoticeFaqServiceImpl;

@WebServlet("/board_manage/noti_faq_view.do")
public class NoticeFaqView extends BaseController {

	private static final long serialVersionUID = -4787830536254533407L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	NoticeFaqCommon board;
	NoticeFaqService noticeFaqService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		board = NoticeFaqCommon.getInstance();
		noticeFaqService = new NoticeFaqServiceImpl(sqlSession, logger);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후에 이용가능합니다.");
			return null;
		}
		
		String category = web.getString("category");
		request.setAttribute("category", category);
		int board_id = web.getInt("id");
		logger.debug("id : " + board_id);
		logger.debug("category : " + category);
		
		try {
			String boardName = board.getBoardName(category);
			request.setAttribute("boardName", boardName);
			logger.debug("boardName : ", boardName);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		NoticeFaq noticeFaq = new NoticeFaq();
		noticeFaq.setCategory(category);
		noticeFaq.setId(board_id);
		
		NoticeFaq noticeFaqView = null;
		NoticeFaq prevNoticeFaqView = null;
		NoticeFaq nextNoticeFaqView = null;
		try {
			noticeFaqView = noticeFaqService.selectNoticeFaqView(noticeFaq);
			prevNoticeFaqView = noticeFaqService.selectPrevNoticeFaqView(noticeFaq);
			nextNoticeFaqView = noticeFaqService.selectNextNoticeFaqView(noticeFaq);
		} catch(Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("noticeFaqView", noticeFaqView);
		request.setAttribute("prevNoticeFaqView", prevNoticeFaqView);
		request.setAttribute("nextNoticeFaqView", nextNoticeFaqView);
		
		return "board_manage/noti_faq_view";
	}

}
