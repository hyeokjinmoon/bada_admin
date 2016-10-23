package com.bada_admin.service;

import java.util.List;

import com.bada_admin.model.Orders;

public interface OrdersService {
	
	public List<Orders> selectOrdersList(Orders orders) throws Exception;
	
	public int selectOrdersCount(Orders orders) throws Exception;
	
	public List<Orders> selectOrdersDashboard(Orders orders) throws Exception;
}
