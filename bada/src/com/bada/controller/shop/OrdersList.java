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
import com.bada.model.Member;
import com.bada.model.Orders;
import com.bada.service.CartService;
import com.bada.service.OrdersService;
import com.bada.service.impl.CartServiceImpl;
import com.bada.service.impl.OrdersServiceImpl;

@WebServlet("/shop/order_list.do")
public class OrdersList extends BaseController {

	private static final long serialVersionUID = -4662674501525391465L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	CartService cartService;
	OrdersService ordersService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		cartService = new CartServiceImpl(sqlSession, logger);
		ordersService = new OrdersServiceImpl(sqlSession, logger);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int add_id = loginInfo.getId();
		int buyer_id = loginInfo.getId();
		
		Cart cart = new Cart();
		cart.setAdd_id(add_id);
		
		List<Cart> cartList = null;
		try {
			cartList = cartService.selectCartByOrdersList(cart);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		Orders orders = new Orders();
		orders.setBuyer_id(buyer_id);
		
		List<Orders> orderList = null;
		
		try {
			orderList = ordersService.selectOrders(orders);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("cartList", cartList);
		request.setAttribute("orderList", orderList);
		
		return "shop/order_list";
	}

}
