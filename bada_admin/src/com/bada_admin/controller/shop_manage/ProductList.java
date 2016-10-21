package com.bada_admin.controller.shop_manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada_admin.dao.MyBatisConnectionFactory;
import com.bada_admin.helper.BaseController;
import com.bada_admin.helper.PageHelper;
import com.bada_admin.helper.WebHelper;
import com.bada_admin.model.Product;
import com.bada_admin.service.ProductService;
import com.bada_admin.service.impl.ProductServiceImpl;

@WebServlet("/shop_manage/product_list.do")
public class ProductList extends BaseController {

	private static final long serialVersionUID = 7886702281616363934L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	PageHelper pageHelper;
	ProductService productService;
	
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		pageHelper = PageHelper.getInstance();
		productService = new ProductServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int page = web.getInt("page", 1);
		int totalCount = 0;
		
		Product product = new Product();
		
		List<Product> productList = null;
		try {
			totalCount = productService.selectProductCount(product);
			pageHelper.pageProcess(page, totalCount, 7, 5);
			product.setLimitStart(pageHelper.getLimitStart());
			product.setListCount(pageHelper.getListCount());
			
			productList = productService.selectProductList(product);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null; 
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("productList", productList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "shop_manage/product_list";
	}

}
