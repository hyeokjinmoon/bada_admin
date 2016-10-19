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
import com.bada_admin.model.Member;
import com.bada_admin.model.Qna;
import com.bada_admin.service.QnaService;
import com.bada_admin.service.impl.QnaServiceImpl;

@WebServlet("/board_manage/qna_answer_ok.do")
public class QnaAnswerOk extends BaseController {

	private static final long serialVersionUID = -6832078135840842408L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	RegexHelper regex;
	QnaService qnaService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		qnaService = new QnaServiceImpl(sqlSession, logger);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후에 이용가능합니다.");
			return null;
		}
		
		String answer = web.getString("answer");
		int answer_id = loginInfo.getId();
		int id = web.getInt("id");
		
		Qna qna = new Qna();
		qna.setId(id);
		qna.setAnswer(answer);
		qna.setAnswer_id(answer_id);
		
		if(!regex.isValue(answer)) {
			sqlSession.close();
			web.redirect(null, "답변을 적어주세요.");
			return null;
		}
		
		try {
			qnaService.updateQnaAnswer(qna);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		web.redirect(web.getRootPath() + "/board_manage/qna_view.do?id=" + qna.getId(), "답변 완료 하였습니다.");
		
		return null;
	}

}
