package com.bada_admin.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada_admin.model.Message;
import com.bada_admin.service.MessageService;
import com.bada_admin.service.impl.MessageServiceImpl;

public class ConnectionTest {
	public static void main(String[] args) {
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
		Logger logger = LogManager.getFormatterLogger(ConnectionTest.class.getName());
		MessageService service = new MessageServiceImpl(sqlSession, logger);
		
		
		Message message = new Message();
		message.setContent("쪽지 보내기 테스트");
		message.setReceiver_id(1);
		message.setSender_id(2);
		
		
		try {
			for(int i = 1; i <= 10; i++){
				service.insertMessage(message);
			}
		} catch (Exception e) {
			sqlSession.close();
			System.out.println(e.getLocalizedMessage());
		}
		
		sqlSession.close();
	}
	
	
	
	
}
