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
import com.bada_admin.helper.RegexHelper;
import com.bada_admin.helper.WebHelper;
import com.bada_admin.model.NoticeFaq;
import com.bada_admin.service.NoticeFaqService;
import com.bada_admin.service.impl.NoticeFaqServiceImpl;

@WebServlet("/board_manage/noti_faq_update_ok.do")
public class NoticeFaqUpdateOk extends BaseController {

	private static final long serialVersionUID = -1166986385112409270L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	RegexHelper regex;
	NoticeFaqCommon board;
	NoticeFaqService noticeFaqService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		board = NoticeFaqCommon.getInstance();
		noticeFaqService = new NoticeFaqServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
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
		
		int id = web.getInt("id");
		String subject = web.getString("subject");
		String content = web.getString("content");
		
		if(!regex.isValue(subject)) {
			sqlSession.close();
			web.redirect(null, "제목을 입력해주세요.");
			return null;
		}
		
		if(!regex.isValue(content)) {
			sqlSession.close();
			web.redirect(null, "공지사항 내용을 입력해주세요.");
			return null;
		}
		
		logger.debug("category : " + category);
		logger.debug("id : " + id);
		logger.debug("subject : " + subject);
		logger.debug("content : " + content);
		
		NoticeFaq noticeFaq = new NoticeFaq();
		noticeFaq.setCategory(category);
		noticeFaq.setId(id);
		noticeFaq.setSubject(subject);
		noticeFaq.setContent(content);
		
		try {
			noticeFaqService.updateNoticeFaq(noticeFaq);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		web.redirect(web.getRootPath() + "/board_manage/noti_faq_view.do?category=" + noticeFaq.getCategory() + "&id=" + noticeFaq.getId(), "수정되었습니다."); 
		
		return null;
	}

}
