package com.bada_admin.controller.shop_manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada_admin.dao.MyBatisConnectionFactory;
import com.bada_admin.helper.BaseController;
import com.bada_admin.helper.WebHelper;
import com.bada_admin.model.Product;
import com.bada_admin.service.ProductService;
import com.bada_admin.service.impl.ProductServiceImpl;

@WebServlet("/shop_manage/product_update.do")
public class ProductUpdate extends BaseController {

	private static final long serialVersionUID = 292979377465964065L;
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
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		
		Product product = new Product();
		product.setId(id);
		
		Product productItem = null;
		
		try {
			productItem = productService.selectProduct(product);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("product", productItem);
		
		return "shop_manage/product_update";
	}

}
