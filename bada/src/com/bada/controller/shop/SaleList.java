package com.bada.controller.shop;

import java.io.IOException;
import java.util.List;

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
import com.bada.model.Member;
import com.bada.model.Product;
import com.bada.service.ProductService;
import com.bada.service.impl.ProductServiceImpl;

@WebServlet("/shop/sale_list.do")
public class SaleList extends BaseController {

	private static final long serialVersionUID = 3068352777920743073L;
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
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int seller_id = loginInfo.getId();
		int page = web.getInt("page", 1);
		int totalCount = 0;
		
		Product product = new Product();
		product.setSeller_id(seller_id);
		
		List<Product> productList = null;
		
		try {
			totalCount = productService.selectProductCountByMember(product);
			pageHelper.pageProcess(page, totalCount, 8, 5);
			product.setLimitStart(pageHelper.getLimitStart());
			product.setListCount(pageHelper.getListCount());
			
			productList = productService.selectProductListByMember(product);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("productList", productList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "shop/sale_list";
	}

}
