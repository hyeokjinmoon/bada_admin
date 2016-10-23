package com.bada_admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada_admin.model.Orders;
import com.bada_admin.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {

	SqlSession sqlSession;
	Logger logger;
	
	public OrdersServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public List<Orders> selectOrdersList(Orders orders) throws Exception {
		List<Orders> result = null;
		try {
			result = sqlSession.selectList("OrdersMapper.selectOrdersList", orders);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 주문 목록이 없습니다.");
		} catch (Exception e) {
			throw new Exception("주문 목록 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public int selectOrdersCount(Orders orders) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("OrdersMapper.selectOrdersCount", orders);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 주문수가 없습니다.");
		} catch (Exception e) {
			throw new Exception("주문수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public List<Orders> selectOrdersDashboard(Orders orders) throws Exception {
		List<Orders> result = null;
		try {
			result = sqlSession.selectList("OrdersMapper.selectOrdersDashboard", orders);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 주문 목록이 없습니다.");
		} catch (Exception e) {
			throw new Exception("주문 목록 조회에 실패했습니다.");
		}
		return result;
	}

}
