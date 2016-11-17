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
import com.bada.model.Member;
import com.bada.model.Qna;
import com.bada.service.QnaService;
import com.bada.service.impl.QnaServiceImpl;

@WebServlet("/board/qna_list.do")
public class QnaList extends BaseController {

	private static final long serialVersionUID = 4825026746363310027L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	PageHelper pageHelper;
	QnaService qnaService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		pageHelper = PageHelper.getInstance();
		qnaService = new QnaServiceImpl(sqlSession, logger);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int request_id = loginInfo.getId();
		
		int page = web.getInt("page", 1);
		int totalCount = 0;
		
		Qna qna = new Qna();
		qna.setRequest_id(request_id);
		
		List<Qna> qnaList = null;
		
		try {
			totalCount = qnaService.selectMemberQnaCount(qna);
			pageHelper.pageProcess(page, totalCount, 8, 5);
			
			qna.setLimitStart(pageHelper.getLimitStart());
			qna.setListCount(pageHelper.getListCount());
			
			qnaList = qnaService.selectMemberQnaList(qna);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("qnaList", qnaList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "board/qna_list";
	}

}
