package com.bada_admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada_admin.model.QnaMemberJoin;
import com.bada_admin.service.QnaMemberService;

public class QnaMemberServiceImpl implements QnaMemberService {
	SqlSession sqlSession;
	Logger logger;
	
	public QnaMemberServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public List<QnaMemberJoin> selectQnaMemberJoinList(QnaMemberJoin qnaMemberJoin) throws Exception {
		List<QnaMemberJoin> result = null;
		try{
			result = sqlSession.selectList("QnaMemberJoinMapper.selectQnaMemberJoinList", qnaMemberJoin);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch(NullPointerException e) {
			throw new Exception("조회된 문의 목록이 없습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("문의 목록 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public QnaMemberJoin selectQnaMemberJoin(QnaMemberJoin qnaMemberJoin) throws Exception {
		QnaMemberJoin result = null;
		try {
			result = sqlSession.selectOne("QnaMemberJoinMapper.selectQnaMemberJoin", qnaMemberJoin);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch(NullPointerException e){
			throw new Exception("조회된 문의가 없습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("문의 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public String selectAnswerStatus(QnaMemberJoin qnaMemberJoin) throws Exception {
		String result = null;
		try {
			result = sqlSession.selectOne("QnaMemberJoinMapper.selectAnswerStatus", qnaMemberJoin);
		} catch (Exception e) {
			throw new Exception("답변 상태 조회에 실패했습니다.");
		}
		return result;
	}

}
