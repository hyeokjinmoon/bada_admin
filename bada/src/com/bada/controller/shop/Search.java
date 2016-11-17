package com.bada.controller.shop;

import java.io.IOException;

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

@WebServlet("/shop/search.do")
public class Search extends BaseController {

	private static final long serialVersionUID = -1646313602620088075L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	ProductService productService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		productService = new ProductServiceImpl(sqlSession, logger);
		
		String category = web.getString("category");
		String keyword = web.getString("keyword");
		logger.debug("category : " + category);
		logger.debug("keyword : " + keyword); 
		if(category.equals("A")) {
			category = null;
		}
		
		int totalCount = 0;
		
		Product product = new Product();
		product.setCategory(category);
		product.setKeyword(keyword);
		try {
			totalCount = productService.selectProductSaleCategoryCount(product);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		if(category == null) {
			category = "A";
		}
		
		request.setAttribute("category", category);
		request.setAttribute("keyword", keyword);
		request.setAttribute("totalCount", totalCount);
		
		return "shop/search";
	}

}
