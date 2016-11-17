package com.bada.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada.model.NoticeFaq;
import com.bada.service.NoticeFaqService;

public class NoticeFaqServiceImpl implements NoticeFaqService {

	SqlSession sqlSession;
	Logger logger;
	
	public NoticeFaqServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public int selectNoticeFaqCount(NoticeFaq noticeFaq) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("NoticeFaqMapper.selectNoticeFaqCount", noticeFaq);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 게시물 수가 없습니다.");
		} catch (Exception e) {
			throw new Exception("게시물수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public List<NoticeFaq> selectNoticeFaqList(NoticeFaq noticeFaq) throws Exception {
		List<NoticeFaq> result = null;
		try {
			result = sqlSession.selectList("NoticeFaqMapper.selectNoticeFaqList", noticeFaq);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 게시물이 없습니다.");
		} catch (Exception e) {
			throw new Exception("게시물 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public NoticeFaq selectNoticeFaqView(NoticeFaq noticeFaq) throws Exception {
		NoticeFaq result = null;
		try {
			result = sqlSession.selectOne("NoticeFaqMapper.selectNoticeFaqView", noticeFaq);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 게시물이 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시물 조회에 실패했습니다.");
		}
		return result;
	}

}
