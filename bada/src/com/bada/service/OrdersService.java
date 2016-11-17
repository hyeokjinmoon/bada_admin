package com.bada.service;

import java.util.List;

import com.bada.model.Orders;

public interface OrdersService {

		public void insertOrders(Orders orders) throws Exception;
		
		public void updateOrdersByPayment(Orders orders) throws Exception;
		
		public List<Orders> selectOrders(Orders orders) throws Exception;
}
