package com.bada.controller.board;

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
import com.bada.model.NoticeFaq;
import com.bada.service.NoticeFaqService;
import com.bada.service.impl.NoticeFaqServiceImpl;

@WebServlet("/board/notice_faq_list.do")
public class NoticeFaqList extends BaseController {

	private static final long serialVersionUID = -6019525773692608557L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	PageHelper pageHelper;
	NoticeFaqService noticeFaqService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		pageHelper = PageHelper.getInstance();
		noticeFaqService = new NoticeFaqServiceImpl(sqlSession, logger);
		
		String category = web.getString("category");
		request.setAttribute("category", category);
		
		logger.debug("category : " + category);
		
		int page = web.getInt("page", 1);
		int totalCount = 0;
		
		NoticeFaq noticeFaq = new NoticeFaq();
		noticeFaq.setCategory(category);
		
		List<NoticeFaq> noticeFaqList = null;
		try {
			totalCount = noticeFaqService.selectNoticeFaqCount(noticeFaq);
			pageHelper.pageProcess(page, totalCount, 8, 5);
			
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
		
		return "board/notice_faq_list";
	}

}
