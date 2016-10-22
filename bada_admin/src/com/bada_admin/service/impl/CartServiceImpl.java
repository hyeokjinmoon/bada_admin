package com.bada_admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada_admin.model.Cart;
import com.bada_admin.service.CartService;

public class CartServiceImpl implements CartService {
	
	SqlSession sqlSession;
	Logger logger;
	
	public CartServiceImpl(SqlSession sqlSession, Logger logger){
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public List<Cart> selectOrderList(Cart cart) throws Exception {
		List<Cart> result = null;
		try {
			result = sqlSession.selectList("CartMapper.selectOrderList", cart);
			if(result == null){
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회할 주문 목록이 없습니다.");
		} catch (Exception e) {
			throw new Exception("주문 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectOrderCount(Cart cart) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("CartMapper.selectOrderCount", cart);
			if(result == 0){
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회할 주문수가 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("주문수 조회에 실패했습니다.");
		}
		return result;
	}

}
