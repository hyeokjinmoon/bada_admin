package com.bada_admin.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada_admin.model.Qna;
import com.bada_admin.service.QnaService;
import com.bada_admin.service.impl.QnaServiceImpl;

public class ConnectionTest {
	public static void main(String[] args) {
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		Logger logger = LogManager.getFormatterLogger(ConnectionTest.class.getName());
		QnaService service = new QnaServiceImpl(sqlSession, logger);
		
		Qna qna = new Qna();

		qna.setSubject("문의 테스트");
		qna.setContent("문의 테스트");
		qna.setReq_type("E");
		qna.setRequest_id(2);
		qna.setAnswer_status("N");
		try {
			for(int i = 1; i <= 10; i++){
				service.insertQna(qna);
			}
		} catch (Exception e) {
			sqlSession.close();
			System.out.println(e.getLocalizedMessage());
		}
		
		sqlSession.close();
	}
	
	
	
	
}
