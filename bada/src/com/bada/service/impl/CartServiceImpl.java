package com.bada.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada.model.Cart;
import com.bada.service.CartService;

public class CartServiceImpl implements CartService {

	SqlSession sqlSession;
	Logger logger;
	
	public CartServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public void insertCart(Cart cart) throws Exception {
		try {
			int result = sqlSession.insert("CartMapper.insertCart", cart);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("입력된 장바구니 내역이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("장바구니 입력에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Cart> selectCartListByAddId(Cart cart) throws Exception {
		List<Cart> result = null;
		try {
			result = sqlSession.selectList("CartMapper.selectCartListByAddId", cart);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("장바구니 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void deleteCart(Cart cart) throws Exception {
		try {
			int result = sqlSession.delete("CartMapper.deleteCart", cart);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("삭제할 장바구니 내역이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("장바구니 삭제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void updateCartByOrders(Cart cart) throws Exception {
		try {
			int result = sqlSession.update("CartMapper.updateCartByOrders", cart);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("주문할 장바구니 상품이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("장바구니 상품 주문에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Cart> selectCartListOrder(Cart cart) throws Exception {
		List<Cart> result = null;
		try {
			result = sqlSession.selectList("CartMapper.selectCartListOrder", cart);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("주문 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateCartByPayment(Cart cart) throws Exception {
		try {
			int result = sqlSession.update("CartMapper.updateCartByPayment", cart);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("결제할 장바구니 상품이 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new Exception("장바구니 상품 결제에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Cart> selectCartByOrdersList(Cart cart) throws Exception {
		List<Cart> result = null;
		try {
			result = sqlSession.selectList("CartMapper.selectCartByOrdersList", cart);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("결제 목록 조회에 실패했습니다.");
		}
		return result;
	}

}
