package com.bada_admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada_admin.model.Message;
import com.bada_admin.service.MessageService;

public class MessageServiceImpl implements MessageService {

	SqlSession sqlSession;
	Logger logger;
	
	public MessageServiceImpl(SqlSession sqlSession, Logger logger){
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public List<Message> selectMessageList(Message message) throws Exception {
		List<Message> result = null;
		try {
			result = sqlSession.selectList("MessageMapper.selectMessageList", message);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회할 쪽지 목록이 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("쪽지 목록 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public Message selectMessage(Message message) throws Exception {
		Message result = null;
		try {
			result = sqlSession.selectOne("MessageMapper.selectMessage", message);
			if(result == null){
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회할 쪽지 내용이 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("쪽지 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void insertMessage(Message message) throws Exception {
		try{
			int result = sqlSession.insert("MessageMapper.insertMessage", message);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("입력 없음");
		} catch(Exception e) {
			sqlSession.rollback();
			throw new Exception("입력 실패");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public int selectMessageCount(Message message) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("MessageMapper.selectMessageCount", message);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("쪽지 카운트 없음");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("쪽지 카운트 조회에 실패했습니다.");
		}
		return result;
	}

}
