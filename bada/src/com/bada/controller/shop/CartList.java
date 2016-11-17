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
import com.bada.helper.WebHelper;
import com.bada.model.Cart;
import com.bada.service.CartService;
import com.bada.service.impl.CartServiceImpl;

@WebServlet("/shop/cart_list.do")
public class CartList extends BaseController {

	private static final long serialVersionUID = 4334348061489707954L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	CartService cartService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		cartService = new CartServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int add_id = web.getInt("add_id");
		
		Cart cart = new Cart();
		cart.setAdd_id(add_id);
		
		List<Cart> cartList = null;
		try {
			cartList = cartService.selectCartListByAddId(cart);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("cartList", cartList);
		
		return "shop/cart_list";
	}

}
