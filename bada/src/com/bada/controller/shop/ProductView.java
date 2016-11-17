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
import com.bada.model.Member;
import com.bada.model.Product;
import com.bada.service.ProductService;
import com.bada.service.impl.ProductServiceImpl;

@WebServlet("/shop/product_view.do")
public class ProductView extends BaseController {

	private static final long serialVersionUID = 364541424376149469L;
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
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		
		Product product = new Product();
		product.setId(id);
		
		Product productView = null;
		try {
			productView = productService.selectProductView(product);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("product", productView);
		
		return "shop/product_view";
	}

}
