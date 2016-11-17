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

@WebServlet("/shop_manage/delivery_update.do")
public class DeliveryUpdate extends BaseController {

	private static final long serialVersionUID = 7718596597762304315L;
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
		String delivery_status = web.getString("delivery_status");
		
		Orders orders = new Orders();
		orders.setId(id);
		orders.setDelivery_status(delivery_status);
		
		try {
			ordersService.updateDeliveryStatus(orders);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		String url = web.getRootPath() + "/shop_manage/delivery_view.do?id=" + orders.getId();
		web.redirect(url, "배송 상황이 수정되었습니다.");
		
		return null;
	}

}
