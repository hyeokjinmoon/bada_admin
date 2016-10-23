package com.bada_admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada_admin.model.Qna;
import com.bada_admin.service.QnaService;

public class QnaServiceImpl implements QnaService {
	SqlSession sqlSession;
	Logger logger;
	
	public QnaServiceImpl(SqlSession sqlSession, Logger logger) {
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
			throw new Exception("저장된 질문이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("질문 저장에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Qna> selectQnaList(Qna qna) throws Exception {
		List<Qna> result = null;
		try {
			result = sqlSession.selectList("QnaMapper.selectQnaList", qna);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 문의 목록이 없습니다.");
		} catch (Exception e) {
			throw new Exception("문의 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectQnaCount(Qna qna) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("QnaMapper.selectQnaCount", qna);
		} catch (Exception e) {
			throw new Exception("문의 수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateQnaAnswer(Qna qna) throws Exception {
		try {
			int result = sqlSession.update("QnaMapper.updateQnaAnswer", qna);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("답변할 문의가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("문의 답변에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void updateAnswer(Qna qna) throws Exception {
		try {
			int result = sqlSession.update("QnaMapper.updateAnswer", qna);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("수정할 문의가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("문의 답변 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
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
			throw new Exception("삭제할 문의가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("문의 답변 삭제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Qna> selectQnaDashboard(Qna qna) throws Exception {
		List<Qna> result = null;
		try {
			result = sqlSession.selectList("QnaMapper.selectQnaDashboard", qna);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 문의 목록이 없습니다.");
		} catch (Exception e) {
			throw new Exception("문의 목록 조회에 실패했습니다.");
		}
		return result;
	}

}
