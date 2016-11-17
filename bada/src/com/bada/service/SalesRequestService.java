package com.bada.service;

import java.util.List;

import com.bada.model.SalesRequest;

public interface SalesRequestService {
	
	public void insertSalesRequest(SalesRequest salesRequest) throws Exception;
	
	public List<SalesRequest> selectSalesRequestList(SalesRequest salesRequest) throws Exception;
	
	public int selectSalesRequestCount(SalesRequest salesRequest) throws Exception;
	
	public SalesRequest selectSaleRequestView(SalesRequest salesRequest) throws Exception;
	
	public void updateSalesRequest(SalesRequest salesRequest) throws Exception;
	
	public void deleteSalesRequest(SalesRequest salesRequest) throws Exception;
	
}
