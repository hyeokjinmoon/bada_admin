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
import com.bada.model.Qna;
import com.bada.service.QnaService;
import com.bada.service.impl.QnaServiceImpl;

@WebServlet("/board/qna_delete.do")
public class QnaDelete extends BaseController {

	private static final long serialVersionUID = 3835566353759066931L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	QnaService qnaService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		qnaService = new QnaServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		if(id == 0) {
			sqlSession.close();
			web.redirect(null, "문의 번호가 없습니다.");
			return null;
		}
		
		Qna qna = new Qna();
		qna.setId(id);
		
		try {
			qnaService.deleteQna(qna);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		String url = web.getRootPath() + "/board/qna_list.do";
		web.redirect(url, "삭제되었습니다.");
		
		return null;
	}

}
