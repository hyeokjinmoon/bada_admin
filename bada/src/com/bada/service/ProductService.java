package com.bada.service;

import java.util.List;
import java.util.Map;

import com.bada.model.Product;

public interface ProductService {
	
	public void insertProduct(Product product) throws Exception;
	
	public List<Product> selectProductListByMember(Product product) throws Exception;
	
	public int selectProductCountByMember(Product product) throws Exception;
	
	public Product selectProductView(Product product) throws Exception;
	
	public int selectProductSaleAllCount(Product product) throws Exception;
	
	public List<Product> selectProductSaleAll(Product product) throws Exception;
	
	public int selectProductSaleCategoryCount(Product product) throws Exception;
	
	public List<Product> selectProductSaleCategory(Product product) throws Exception;
	
	public Product selectProductDetail(Product product) throws Exception;
	
	public Product selectProductCartInsert(Product product) throws Exception;
	
	public void updateProductByPayment(Product product) throws Exception;
	
	public Map<String, String> selectProductName(Product product) throws Exception;
	
	public void deleteProduct(Product product) throws Exception;
}
