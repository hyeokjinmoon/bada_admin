package com.bada.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada.model.Orders;
import com.bada.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {

	SqlSession sqlSession;
	Logger logger;
	
	public OrdersServiceImpl(SqlSession sqlSession, Logger logger) {
		super();
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void insertOrders(Orders orders) throws Exception {
		try {
			int result = sqlSession.insert("OrdersMapper.insertOrders", orders);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("주문할 상품이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("상품 주문에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void updateOrdersByPayment(Orders orders) throws Exception {
		try {
			int result = sqlSession.update("OrdersMapper.updateOrdersByPayment", orders);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("결제할 주문이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("주문 결제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Orders> selectOrders(Orders orders) throws Exception {
		List<Orders> result = null;
		try {
			result = sqlSession.selectList("OrdersMapper.selectOrders", orders);
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
