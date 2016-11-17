package com.bada.controller.shop;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada.dao.MyBatisConnectionFactory;
import com.bada.helper.BaseController;
import com.bada.helper.PageHelper;
import com.bada.helper.WebHelper;
import com.bada.model.Product;
import com.bada.service.ProductService;
import com.bada.service.impl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/shop/search_list.do")
public class SearchList extends BaseController {

	private static final long serialVersionUID = -1646313602620088075L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	PageHelper pageHelper;
	ProductService productService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		pageHelper = PageHelper.getInstance();
		productService = new ProductServiceImpl(sqlSession, logger);
		
		int result = web.getInt("result");
		int page_no = web.getInt("page_no");
		String category = web.getString("category");
		String keyword = web.getString("keyword");
		
		if(category.equals("A")) {
			category = null;
		}
		
		Product product = new Product();
		product.setCategory(category);
		product.setKeyword(keyword);
		
		int count = 0;
		int page_count = 0;
		List<Product> productList = null;
		try {
			count = productService.selectProductSaleCategoryCount(product);
			pageHelper.pageProcess(page_no, count, result, 5);
			page_count = pageHelper.getTotalPage();
			
			product.setLimitStart(pageHelper.getLimitStart());
			product.setListCount(pageHelper.getListCount());
			productList = productService.selectProductSaleCategory(product);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("page_count", page_count);
		data.put("productList", productList);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), data);
		
		return null;
	}

}
