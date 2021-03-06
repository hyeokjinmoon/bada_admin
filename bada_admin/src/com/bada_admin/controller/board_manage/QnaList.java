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
import com.bada_admin.model.QnaMemberJoin;
import com.bada_admin.service.QnaMemberService;
import com.bada_admin.service.QnaService;
import com.bada_admin.service.impl.QnaMemberServiceImpl;
import com.bada_admin.service.impl.QnaServiceImpl;

@WebServlet("/board_manage/qna_list.do")
public class QnaList extends BaseController {

	private static final long serialVersionUID = 3625862733263441967L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	PageHelper pageHelper;
	QnaService qnaService;
	QnaMemberService qnaMemberService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		pageHelper = PageHelper.getInstance();
		qnaService = new QnaServiceImpl(sqlSession, logger);
		qnaMemberService = new QnaMemberServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후에 이용가능합니다.");
			return null;
		}
		
		int page = web.getInt("page", 1);
		int totalCount = 0;
		
		QnaMemberJoin qnaMemberJoin = new QnaMemberJoin();
		
		
		List<QnaMemberJoin> qnaMemberJoinList = null;
		
		try {
			totalCount = qnaService.selectQnaCount(null);
			pageHelper.pageProcess(page, totalCount, 7, 5);
			
			qnaMemberJoin.setLimitStart(pageHelper.getLimitStart());
			qnaMemberJoin.setListCount(pageHelper.getListCount());
			
			qnaMemberJoinList = qnaMemberService.selectQnaMemberJoinList(qnaMemberJoin);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("qnaMemberJoinList", qnaMemberJoinList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "board_manage/qna_list";
	}

}
