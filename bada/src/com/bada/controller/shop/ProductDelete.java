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

@WebServlet("/shop/product_delete.do")
public class ProductDelete extends BaseController {

	private static final long serialVersionUID = -6509225232846615531L;
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
		
		int id = web.getInt("id");
		
		Product product = new Product();
		product.setId(id);
		
		try {
			productService.deleteProduct(product);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		String url = web.getRootPath() + "/shop/sale_list.do";
		web.redirect(url, "삭제되었습니다.");
		
		return null;
	}

}
