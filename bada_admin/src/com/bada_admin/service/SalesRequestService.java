package com.bada_admin.service;

import java.util.List;

import com.bada_admin.model.SalesRequest;

public interface SalesRequestService {
	
	public List<SalesRequest> selectSalesRequestList(SalesRequest salesRequest) throws Exception;
	
	public int selectSalesRequestCount(SalesRequest salesRequest) throws Exception;
	
	public SalesRequest selectSalesRequestView(SalesRequest salesRequest) throws Exception;
	
	public void updateSalesRequest(SalesRequest salesRequest) throws Exception;
	
	public void deleteSalesRequestUserOut(SalesRequest salesRequest) throws Exception;
	
}
