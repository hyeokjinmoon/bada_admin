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
import com.bada_admin.model.Cart;
import com.bada_admin.model.Orders;
import com.bada_admin.service.CartService;
import com.bada_admin.service.OrdersService;
import com.bada_admin.service.impl.CartServiceImpl;
import com.bada_admin.service.impl.OrdersServiceImpl;

@WebServlet("/shop_manage/trade_list.do")
public class TradeList extends BaseController {

	private static final long serialVersionUID = -5401190353289542799L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	PageHelper pageHelper;
	CartService cartService;
	OrdersService ordersService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		pageHelper = PageHelper.getInstance();
		cartService = new CartServiceImpl(sqlSession, logger);
		ordersService = new OrdersServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null){
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int page = web.getInt("page", 1);
		int totalCount = 0;
		
		Orders orders = new Orders();
		List<Cart> cartList = null;
		List<Orders> tradeList = null;
		try {
			totalCount = ordersService.selectOrdersTradeCount(orders);
			pageHelper.pageProcess(page, totalCount, 8, 5);
			orders.setLimitStart(pageHelper.getLimitStart());
			orders.setListCount(pageHelper.getListCount());
			
			tradeList = ordersService.selectOrdersTradeList(orders);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		try {
			for(int i = 0; i < tradeList.size(); i++) {
				Cart cart = new Cart();
				cart.setOrder_id(tradeList.get(i).getId());
				cartList = cartService.selectTradeListInOrders(cart);
				tradeList.get(i).setCartList(cartList);
			}
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("tradeList", tradeList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "shop_manage/trade_list";
	}

}
