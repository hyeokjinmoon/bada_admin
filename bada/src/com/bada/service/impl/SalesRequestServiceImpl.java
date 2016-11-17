package com.bada.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada.model.SalesRequest;
import com.bada.service.SalesRequestService;

public class SalesRequestServiceImpl implements SalesRequestService {

	SqlSession sqlSession;
	Logger logger;
	
	public SalesRequestServiceImpl(SqlSession sqlSession, Logger logger) {
		super();
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void insertSalesRequest(SalesRequest salesRequest) throws Exception {
		try {
			int result = sqlSession.insert("SalesRequestMapper.insertSalesRequest", salesRequest);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("입력된 판매 신청이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("판매 신청 입력에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<SalesRequest> selectSalesRequestList(SalesRequest salesRequest) throws Exception {
		List<SalesRequest> result = null;
		try {
			result = sqlSession.selectList("SalesRequestMapper.selectSalesRequestList", salesRequest);
		} catch (Exception e) {
			e.printStackTrace();
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
	public SalesRequest selectSaleRequestView(SalesRequest salesRequest) throws Exception {
		SalesRequest result = null;
		try {
			result = sqlSession.selectOne("SalesRequestMapper.selectSaleRequestView", salesRequest);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 판매신청 내역이 없습니다.");
		} catch (Exception e) {
			throw new Exception("판매신청 내역 조회에 실패했습니다.");
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
			throw new Exception("수정할 판매 신청이 없습니다.");
		}  catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("판매 신청 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void deleteSalesRequest(SalesRequest salesRequest) throws Exception {
		try {
			int result = sqlSession.update("SalesRequestMapper.deleteSalesRequest", salesRequest);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("삭제할 판매 신청이 없습니다.");
		}  catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("판매 신청 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

}
