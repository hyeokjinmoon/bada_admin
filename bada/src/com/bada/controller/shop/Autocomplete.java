package com.bada.controller.shop;

import java.io.IOException;
import java.util.HashMap;
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
import com.bada.helper.WebHelper;
import com.bada.model.Product;
import com.bada.service.ProductService;
import com.bada.service.impl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/shop/autocomplete.do")
public class Autocomplete extends BaseController {

	private static final long serialVersionUID = -3800801599096126454L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	ProductService productService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		productService = new ProductServiceImpl(sqlSession, logger);
		
		String keyword = web.getString("query");
		
		Product product = new Product();
		product.setKeyword(keyword);
		
		Map<String, String> itemMap = null;
		
		try {
			itemMap = productService.selectProductName(product);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("suggestions", itemMap.values());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), data);
		
		return null;
	}

}
