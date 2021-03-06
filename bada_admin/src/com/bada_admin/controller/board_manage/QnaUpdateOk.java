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
import com.bada_admin.model.Qna;
import com.bada_admin.service.QnaService;
import com.bada_admin.service.impl.QnaServiceImpl;

@WebServlet("/board_manage/qna_update_ok.do")
public class QnaUpdateOk extends BaseController {

	private static final long serialVersionUID = 585084337898012169L;
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
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후에 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		String answer = web.getString("answer");
		
		if(!regex.isValue(answer)) {
			sqlSession.close();
			web.redirect(null, "답변을 적어주세요.");
			return null;
		}
		
		Qna qna = new Qna();
		qna.setId(id);
		qna.setAnswer(answer);
		
		try {
			qnaService.updateAnswer(qna);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		web.redirect(web.getRootPath() + "/board_manage/qna_view.do?id=" + qna.getId(), "수정하였습니다.");
		
		return null;
	}

}
