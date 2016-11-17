package com.bada_admin.controller.shop_manage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.bada_admin.model.Orders;
import com.bada_admin.service.OrdersService;
import com.bada_admin.service.impl.OrdersServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/shop_manage/orders_before_month.do")
public class OrdersBeforeMonth extends BaseController {

	private static final long serialVersionUID = 3491103151102123023L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	OrdersService ordersService;
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		ordersService = new OrdersServiceImpl(sqlSession, logger);
		response.setContentType("application/json");
		
//		if(web.getSession("loginInfo") == null) {
//			sqlSession.close();
//			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
//			return null;
//		}
		
		int month = web.getInt("month");
		
		List<Orders> ordersList = null;
		Orders orders = new Orders();
		orders.setMonth(month);
		
		try {
			ordersList = ordersService.selectOrderListBeforeMonth(orders);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ordersList", ordersList);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), map);
		
		return null;
	}

}
