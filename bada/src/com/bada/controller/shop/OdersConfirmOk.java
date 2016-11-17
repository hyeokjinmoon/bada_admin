package com.bada.controller.shop;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import com.bada.model.Product;
import com.bada.service.CartService;
import com.bada.service.OrdersService;
import com.bada.service.ProductService;
import com.bada.service.impl.CartServiceImpl;
import com.bada.service.impl.OrdersServiceImpl;
import com.bada.service.impl.ProductServiceImpl;

@WebServlet("/shop/order_confirm_ok.do")
public class OdersConfirmOk extends BaseController {

	private static final long serialVersionUID = -3787187577320423535L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	CartService cartService;
	OrdersService ordersService;
	ProductService productService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		cartService = new CartServiceImpl(sqlSession, logger);
		ordersService = new OrdersServiceImpl(sqlSession, logger);
		productService = new ProductServiceImpl(sqlSession, logger);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int order_id = web.getInt("order_id");
		int buyer_id = web.getInt("buyer_id");
		String product_id = web.getString("product_id");
		int add_id = web.getInt("add_id");
		String cart_id = web.getString("cart_id");
		String buyer_name = web.getString("buyer_name");
		String buyer_tel = web.getString("buyer_tel");
		String postcode = web.getString("postcode");
		String addr1 = web.getString("addr1");
		String addr2 = web.getString("addr2");
		String payment_type = web.getString("payment_type");
		int payment_price = web.getInt("payment_price");
		
		String addr = "(" + postcode + ") " + addr1 + " " + addr2;
		
		String[] product_ids = product_id.split(",");
		Product product = new Product();
		product.setProduct_status("C");
		try {
			if(product_ids.length > 0) {
				for(int i = 0; i < product_ids.length; i++) {
					product.setId(Integer.parseInt(product_ids[i]));
					productService.updateProductByPayment(product);
				}
			}
		} catch (Exception e) {
			sqlSession.close();
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		}
		
		String[] cart_ids = cart_id.split(",");
		Cart cart = new Cart();
		cart.setProduct_status("C");
		cart.setAdd_id(add_id);
		try {
			if(cart_ids.length > 0) {
				for(int i = 0; i < cart_ids.length; i++) {
					cart.setId(Integer.parseInt(cart_ids[i]));
					cartService.updateCartByPayment(cart);
				}
			}
		} catch (Exception e) {
			sqlSession.close();
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		}
		
		Orders orders = new Orders();
		orders.setId(order_id);
		orders.setBuyer_id(buyer_id);
		orders.setBuyer_name(buyer_name);
		orders.setBuyer_tel(buyer_tel);
		orders.setBuyer_addr(addr);
		orders.setPayment_type(payment_type);
		orders.setPayment_price(payment_price);
		if(payment_type.equals("C")) {
			orders.setDeposit_status("C");
		} else if(payment_type.equals("P")) {
			orders.setDeposit_status("W");
		}
		
		try {
			ordersService.updateOrdersByPayment(orders);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("order_id", orders.getId());
		web.printJsonRt("OK");
		
		return null;
	}

}
