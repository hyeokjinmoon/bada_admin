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
import com.bada.helper.RegexHelper;
import com.bada.helper.WebHelper;
import com.bada.model.Qna;
import com.bada.service.QnaService;
import com.bada.service.impl.QnaServiceImpl;

@WebServlet("/board/qna_edit_ok.do")
public class QnaEditOk extends BaseController {

	private static final long serialVersionUID = 2167727656179232462L;
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
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		String subject = web.getString("subject");
		String req_type = web.getString("req_type");
		String content = web.getString("content");
		
		if(!regex.isValue(subject)) {
			sqlSession.close();
			web.redirect(null, "제목을 입력해주세요.");
			return null;
		}
		if(!regex.isValue(req_type)) {
			sqlSession.close();
			web.redirect(null, "문의 종류를 선택해주세요.");
			return null;
		}
		if(!regex.isValue(content)) {
			sqlSession.close();
			web.redirect(null, "문의 내용을 입력해주세요.");
			return null;
		}
		
		Qna qna = new Qna();
		qna.setId(id);
		qna.setSubject(subject);
		qna.setReq_type(req_type);
		qna.setContent(content);
		
		try {
			qnaService.updateQna(qna);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		String url = web.getRootPath() + "/board/qna_view.do?id=" + qna.getId();
		web.redirect(url, "수정되었습니다.");
		
		return null;
	}

}
