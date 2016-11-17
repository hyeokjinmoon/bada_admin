package com.bada_admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada_admin.model.SalesRequest;
import com.bada_admin.service.SalesRequestService;

public class SalesRequestServiceImpl implements SalesRequestService {

	SqlSession sqlSession;
	Logger logger;
	
	public SalesRequestServiceImpl(SqlSession sqlSession, Logger logger) {
		super();
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public List<SalesRequest> selectSalesRequestList(SalesRequest salesRequest) throws Exception {
		List<SalesRequest> result = null;
		try {
			result = sqlSession.selectList("SalesRequestMapper.selectSalesRequestList", salesRequest);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 판매 신청이 없습니다.");
		} catch (Exception e) {
			throw new Exception("판매 신청 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectSalesRequestCount(SalesRequest salesRequest) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("SalesRequestMapper.selectSalesRequestCount", salesRequest);
		} catch (Exception e) {
			throw new Exception("판매 신청 수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public SalesRequest selectSalesRequestView(SalesRequest salesRequest) throws Exception {
		SalesRequest result = null;
		try {
			result = sqlSession.selectOne("SalesRequestMapper.selectSalesRequestView", salesRequest);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 판매 신청이 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("판매 신청 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateSalesRequest(SalesRequest salesRequest) throws Exception {
		try {
			int result = sqlSession.update("SalesRequestMapper.updateSalesRequest", salesRequest);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("수정된 판매 신청이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("판매 신청 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void deleteSalesRequestUserOut(SalesRequest salesRequest) throws Exception {
		try {
			int result = sqlSession.delete("SalesRequestMapper.deleteSalesRequestUserOut", salesRequest);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("삭제된 판매 신청이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("판매 신청 삭제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

}
