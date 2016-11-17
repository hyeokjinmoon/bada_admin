package com.bada_admin.service;

import java.util.List;

import com.bada_admin.model.Cart;

public interface CartService {
	
	public List<Cart> selectOrderList(Cart cart) throws Exception;
	
	public int selectOrderCount(Cart cart) throws Exception;
	
	public List<Cart> selectCartInOrdersList(Cart cart) throws Exception;
	
	public List<Cart> selectTradeList(Cart cart) throws Exception;
	
	public int selectTradeCount(Cart cart) throws Exception;
	
	public List<Cart> selectTradeListInOrders(Cart cart) throws Exception;
	
	public void deleteCartUserOut(Cart cart) throws Exception;
}
