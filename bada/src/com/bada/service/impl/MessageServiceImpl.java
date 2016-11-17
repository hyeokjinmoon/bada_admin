package com.bada.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada.model.Message;
import com.bada.service.MessageService;

public class MessageServiceImpl implements MessageService {

	SqlSession sqlSession;
	Logger logger;
	
	public MessageServiceImpl(SqlSession sqlSession, Logger logger) {
		super();
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void insertMessage(Message message) throws Exception {
		try {
			int result = sqlSession.insert("MessageMapper.insertMessage", message);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("입력할 쪽지가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("쪽지 입력에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Message> selectSendMessageList(Message message) throws Exception {
		List<Message> result = null;
		try {
			result = sqlSession.selectList("MessageMapper.selectSendMessageList", message);
		} catch (Exception e) {
			throw new Exception("보낸 쪽지 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectSendMessageCount(Message message) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("MessageMapper.selectSendMessageCount", message);
		} catch (Exception e) {
			throw new Exception("보낸 쪽지수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public List<Message> selectReceiveMessageList(Message message) throws Exception {
		List<Message> result = null;
		try {
			result = sqlSession.selectList("MessageMapper.selectReceiveMessageList", message);
		} catch (Exception e) {
			throw new Exception("받은 쪽지 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectReceiveMessageCount(Message message) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("MessageMapper.selectReceiveMessageCount", message);
		} catch (Exception e) {
			throw new Exception("받은 쪽지수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public Message selectMessage(Message message) throws Exception {
		Message result = null;
		try {
			result = sqlSession.selectOne("MessageMapper.selectMessage", message);
		} catch (Exception e) {
			throw new Exception("쪽지 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void deleteMessage(Message message) throws Exception {
		try {
			int result = sqlSession.delete("MessageMapper.deleteMessage", message);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("삭제할 쪽지가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("쪽지 삭제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

}
