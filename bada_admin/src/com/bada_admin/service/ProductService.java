package com.bada_admin.service;

import java.util.List;

import com.bada_admin.model.Product;

public interface ProductService {
	
	public void insertProductMember(Product product) throws Exception;
	
	public void insertProductBada(Product product) throws Exception;
	
	public List<Product> selectProductList(Product product) throws Exception;
	
	public Product selectProduct(Product product) throws Exception;
	
	public int selectProductCount(Product product) throws Exception;
	
	public void updateProduct(Product product) throws Exception;
	
	public void updateProductOkStatus(Product product) throws Exception;
	
	public List<Product> selectProductOkStatusList(Product product) throws Exception;
	
	public Product selectProductOkStatus(Product product) throws Exception;
	
	public int selectProductOkStatusCount(Product product) throws Exception;
	
}
