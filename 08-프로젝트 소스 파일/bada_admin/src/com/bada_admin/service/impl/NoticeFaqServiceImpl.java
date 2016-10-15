package com.bada_admin.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada_admin.model.NoticeFaq;
import com.bada_admin.service.NoticeFaqService;

public class NoticeFaqServiceImpl implements NoticeFaqService {
	SqlSession sqlSession;
	Logger logger;
	
	public NoticeFaqServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public void insertBoard(NoticeFaq noticeFaq) throws Exception {
		try {
			int result = sqlSession.insert("NoticeFaqMapper.insertBoard", noticeFaq);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("저장된 게시물이 없습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
			throw new Exception("게시물 저장에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

}
