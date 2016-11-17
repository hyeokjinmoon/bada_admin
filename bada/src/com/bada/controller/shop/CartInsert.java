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
import com.bada.model.Product;
import com.bada.service.CartService;
import com.bada.service.ProductService;
import com.bada.service.impl.CartServiceImpl;
import com.bada.service.impl.ProductServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/shop/cart_insert.do")
public class CartInsert extends BaseController {

	private static final long serialVersionUID = -8703302768602634662L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	ProductService productService;
	CartService cartService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		productService = new ProductServiceImpl(sqlSession, logger);
		cartService = new CartServiceImpl(sqlSession, logger);
		
		int product_id = web.getInt("product_id");
		int add_id = web.getInt("add_id");
		
		Product product = new Product();
		product.setId(product_id);
		
		Product insertItem = null;
		
		try {
			insertItem = productService.selectProductCartInsert(product);
		} catch (Exception e) {
			sqlSession.close();
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		}
		
		Cart cart = new Cart();
		cart.setProduct_name(insertItem.getProduct_name());
		cart.setSeller_id(insertItem.getSeller_id());
		cart.setSeller(insertItem.getSeller());
		cart.setAdd_id(add_id);
		cart.setCategory(insertItem.getCategory());
		cart.setList_price(insertItem.getList_price());
		cart.setSale_price(insertItem.getSale_price());
		cart.setOk_status(insertItem.getOk_status());
		cart.setProduct_img(insertItem.getProduct_img());
		cart.setProduct_status(insertItem.getProduct_status());
		cart.setProduct_id(insertItem.getId());
		
		try {
			cartService.insertCart(cart);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("cart_id", cart.getId());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), data);
		
		return null;
	}

}
