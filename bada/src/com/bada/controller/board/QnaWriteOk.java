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

@WebServlet("/board/qna_write_ok.do")
public class QnaWriteOk extends BaseController {

	private static final long serialVersionUID = -7555977460355859340L;
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
		
		int request_id = web.getInt("request_id");
		String subject = web.getString("subject");
		String req_type = web.getString("req_type");
		String content = web.getString("content");
		
		logger.debug("request_id : " + request_id);
		logger.debug("subject : " + subject);
		logger.debug("req_type : " + req_type);
		logger.debug("content : " + content);
		
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
		qna.setRequest_id(request_id);
		qna.setSubject(subject);
		qna.setReq_type(req_type);
		qna.setContent(content);
		
		try {
			qnaService.insertQna(qna);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		web.redirect(web.getRootPath() + "/board/qna_list.do", "문의가 등록되었습니다.");
		
		return null;
	}

}
