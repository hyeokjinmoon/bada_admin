package com.bada.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada.model.Qna;
import com.bada.service.QnaService;

public class QnaServiceImpl implements QnaService {
	
	SqlSession sqlSession;
	Logger logger;
	
	public  QnaServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public void insertQna(Qna qna) throws Exception {
		try {
			int result = sqlSession.insert("QnaMapper.insertQna", qna);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("등록된 문의가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("문의 등록에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Qna> selectMemberQnaList(Qna qna) throws Exception {
		List<Qna> result = null;
		try {
			result = sqlSession.selectList("QnaMapper.selectMemberQnaList", qna);
		} catch (Exception e) {
			throw new Exception("문의 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectMemberQnaCount(Qna qna) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("QnaMapper.selectMemberQnaCount", qna);
		} catch (Exception e) {
			throw new Exception("문의수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public Qna selectQnaView(Qna qna) throws Exception {
		Qna result = null;
		try {
			result = sqlSession.selectOne("QnaMapper.selectQnaView", qna);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new Exception("조회할 문의가 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("문의 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void deleteQna(Qna qna) throws Exception {
		try {
			int result = sqlSession.delete("QnaMapper.deleteQna", qna);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("삭제된 문의가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("문의 삭제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void updateQna(Qna qna) throws Exception {
		try {
			int result = sqlSession.update("QnaMapper.updateQna", qna);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("수정된 문의가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("문의 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

}
