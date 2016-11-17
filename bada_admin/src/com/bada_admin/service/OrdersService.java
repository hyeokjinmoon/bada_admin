package com.bada_admin.service;

import java.util.List;

import com.bada_admin.model.Orders;

public interface OrdersService {
	
	public List<Orders> selectOrdersList(Orders orders) throws Exception;
	
	public int selectOrdersCount(Orders orders) throws Exception;
	
	public List<Orders> selectOrdersDashboard(Orders orders) throws Exception;
	
	public List<Orders> selectOrderListBeforeMonth(Orders orders) throws Exception;
	
	public Orders selectOrderDetail(Orders orders) throws Exception;
	
	public void updateDeliveryStatus(Orders orders) throws Exception;
	
	public void updateDepositStatus(Orders orders) throws Exception;
	
	public List<Orders> selectOrdersTradeList(Orders orders) throws Exception;
	
	public int selectOrdersTradeCount(Orders orders) throws Exception;
	
	public void updateOrdersUserOut(Orders orders) throws Exception;
}
