package com.bada.controller.board;

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
import com.bada.model.NoticeFaq;
import com.bada.service.NoticeFaqService;
import com.bada.service.impl.NoticeFaqServiceImpl;

@WebServlet("/board/notice_faq_view.do")
public class NoticeFaqView extends BaseController {

	private static final long serialVersionUID = -4611832652473953488L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	NoticeFaqService noticeFaqService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		noticeFaqService = new NoticeFaqServiceImpl(sqlSession, logger);
		
		String category = web.getString("category");
		int id = web.getInt("id");
		
		NoticeFaq noticeFaq = new NoticeFaq();
		noticeFaq.setId(id);
		noticeFaq.setCategory(category);
		
		NoticeFaq noticeFaqView = null;
		
		try {
			noticeFaqView = noticeFaqService.selectNoticeFaqView(noticeFaq);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("category", category);
		request.setAttribute("noticeFaqView", noticeFaqView);
		
		return "board/notice_faq_view";
	}

}
