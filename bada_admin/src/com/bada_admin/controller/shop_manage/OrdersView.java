package com.bada_admin.controller.shop_manage;

import java.io.IOException;

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

@WebServlet("/shop_manage/orders_view.do")
public class OrdersView extends BaseController {

	private static final long serialVersionUID = 2366157725016305820L;
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
		
		if(web.getSession("loginInfo") == null){
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		if(id == 0) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "주문 번호가 없습니다.");
			return null;
		}
		
		Orders orders = new Orders();
		orders.setId(id);
		
		Orders ordersView = null;
		try {
			ordersView = ordersService.selectOrderDetail(orders);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("orders", ordersView);
		
		return "shop_manage/orders_view";
	}

}
