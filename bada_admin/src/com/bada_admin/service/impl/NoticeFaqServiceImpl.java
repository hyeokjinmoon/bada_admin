package com.bada_admin.service.impl;

import java.util.List;

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
	public void insertNoticeFaq(NoticeFaq noticeFaq) throws Exception {
		try {
			int result = sqlSession.insert("NoticeFaqMapper.insertNoticeFaq", noticeFaq);
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

	@Override
	public NoticeFaq selectNoticeFaqView(NoticeFaq noticeFaq) throws Exception {
		NoticeFaq result = null;
		try {
			result = sqlSession.selectOne("NoticeFaqMapper.selectNoticeFaqView", noticeFaq);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
			throw new Exception("조회할 게시물이 없습니다.");
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("게시물 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public NoticeFaq selectPrevNoticeFaqView(NoticeFaq noticeFaq) throws Exception {
		NoticeFaq result = null;
		try {
			result = sqlSession.selectOne("NoticeFaqMapper.selectPrevNoticeFaqView", noticeFaq);
		} catch (Exception e) {
			throw new Exception("이전 글 조회에 실패했습니다.");
		} 
		return result;
	}

	@Override
	public NoticeFaq selectNextNoticeFaqView(NoticeFaq noticeFaq) throws Exception {
		NoticeFaq result = null;
		try {
			result = sqlSession.selectOne("NoticeFaqMapper.selectNextNoticeFaqView", noticeFaq);
		} catch (Exception e) {
			throw new Exception("다음 글 조회에 실패했습니다.");
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
			throw new Exception("조회된 게시물 목록이 없습니다.");
		} catch (Exception e) {
			throw new Exception("게시물 목록 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public int selectNoticeFaqCount(NoticeFaq noticeFaq) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("NoticeFaqMapper.selectNoticeFaqCount", noticeFaq);
		} catch (Exception e){
			throw new Exception("게시물 수 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public void updateNoticeFaq(NoticeFaq noticeFaq) throws Exception {
		try {
			int result = sqlSession.update("NoticeFaqMapper.updateNoticeFaq", noticeFaq);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("수정할 게시물이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("게시물 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void deleteNoticeFaq(NoticeFaq noticeFaq) throws Exception {
		try {
			int result = sqlSession.delete("NoticeFaqMapper.deleteNoticeFaq", noticeFaq);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("삭제할 게시물이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("게시물 삭제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
		
	}

}
