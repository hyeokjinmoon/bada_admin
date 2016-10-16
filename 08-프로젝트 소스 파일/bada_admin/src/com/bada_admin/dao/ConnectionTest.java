package com.bada_admin.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada_admin.model.NoticeFaq;
import com.bada_admin.service.NoticeFaqService;
import com.bada_admin.service.impl.NoticeFaqServiceImpl;

public class ConnectionTest {
	public static void main(String[] args) {
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		Logger logger = LogManager.getFormatterLogger(ConnectionTest.class.getName());
		NoticeFaqService service = new NoticeFaqServiceImpl(sqlSession, logger);
		
		NoticeFaq noticeFaq = new NoticeFaq();
		noticeFaq.setCategory("notice");
		noticeFaq.setId(4);
		
		NoticeFaq result = null;
		try {
			result = service.selectNoticeFaqView(noticeFaq);
		} catch (Exception e) {
			sqlSession.close();
			System.out.println(e.getLocalizedMessage());
		}
		System.out.println(result.toString());
		sqlSession.close();
	}
	
	
	
	
}
