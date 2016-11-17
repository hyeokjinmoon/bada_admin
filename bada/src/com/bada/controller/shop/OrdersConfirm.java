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

@WebServlet("/shop/order_confirm.do")
public class OrdersConfirm extends BaseController {

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
		
		int add_id = web.getInt("add_id");
		String cart_id = web.getString("cart_id");
		
		String[] cart_ids = null;
		if(cart_id != null) {
			cart_ids = cart_id.split(",");
		}
		String addr = "(" + loginInfo.getPostcode() + ") " + loginInfo.getAddr1() + " " + loginInfo.getAddr2(); 
		
		Orders orders = new Orders();
		orders.setBuyer_id(loginInfo.getId());
		orders.setBuyer_name(loginInfo.getName());
		orders.setBuyer_tel(loginInfo.getTel());
		orders.setBuyer_addr(addr);
		orders.setDeposit_status("W");
		orders.setDelivery_status("W");
		orders.setPayment_type("P");
		orders.setPayment_price(0);
		
		try {
			ordersService.insertOrders(orders);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		Cart cart = new Cart();
		cart.setAdd_id(add_id);
		cart.setOrder_id(orders.getId());
		
		List<Cart> cartList = null;
		try {
			if(cart_ids.length > 0) {
				for(int i = 0; i < cart_ids.length; i++) {
					cart.setId(Integer.parseInt(cart_ids[i]));
					cartService.updateCartByOrders(cart);
				}
			} else {
				cartService.updateCartByOrders(cart);
			}
			
			cartList = cartService.selectCartListOrder(cart);
			
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		int total_price = 0;
		String product_id = "";
		for(int i = 0; i < cartList.size(); i++) {
			total_price += cartList.get(i).getSale_price();
			product_id += cartList.get(i).getProduct_id() + ",";
		}
		
		
		request.setAttribute("cartList", cartList);
		request.setAttribute("total_price", total_price);
		request.setAttribute("order_id", orders.getId());
		request.setAttribute("cart_id", cart_id);
		request.setAttribute("product_id", product_id);
		
		return "shop/order_confirm";
	}

}
