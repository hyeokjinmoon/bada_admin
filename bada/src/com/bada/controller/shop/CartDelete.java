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
import com.bada.service.CartService;
import com.bada.service.impl.CartServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/shop/cart_delete.do")
public class CartDelete extends BaseController {

	private static final long serialVersionUID = -1093406441251486328L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	CartService cartService;
	
	@Override
	public synchronized String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		cartService = new CartServiceImpl(sqlSession, logger);
		
		int cart_id = web.getInt("cart_id");
		
		Cart cart = new Cart();
		cart.setId(cart_id);
		
		try {
			cartService.deleteCart(cart);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("cart_id", cart_id);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), data);
		
		return null;
	}

}
