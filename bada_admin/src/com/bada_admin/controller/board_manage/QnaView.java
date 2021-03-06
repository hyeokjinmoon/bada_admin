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
import com.bada_admin.model.QnaMemberJoin;
import com.bada_admin.service.QnaMemberService;
import com.bada_admin.service.impl.QnaMemberServiceImpl;

@WebServlet("/board_manage/qna_view.do")
public class QnaView extends BaseController {

	private static final long serialVersionUID = 8114085036628410673L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	QnaMemberService qnaMemberService;
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		qnaMemberService = new QnaMemberServiceImpl(sqlSession, logger);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후에 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		
		QnaMemberJoin qnaMemberJoin = new QnaMemberJoin();
		qnaMemberJoin.setId(id);
		
		QnaMemberJoin qna = null;
		try {
			if(qnaMemberService.selectAnswerStatus(qnaMemberJoin).equals("A")) {
				qnaMemberJoin.setAnswer_id(loginInfo.getId());
			}
			
			qna = qnaMemberService.selectQnaMemberJoin(qnaMemberJoin);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("qna", qna);
		
		return "board_manage/qna_view";
	}

}
