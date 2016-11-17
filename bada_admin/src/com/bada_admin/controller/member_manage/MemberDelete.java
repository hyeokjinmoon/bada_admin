package com.bada_admin.controller.member_manage;

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
import com.bada_admin.helper.WebHelper;
import com.bada_admin.model.Cart;
import com.bada_admin.model.Message;
import com.bada_admin.model.Orders;
import com.bada_admin.model.Product;
import com.bada_admin.model.Qna;
import com.bada_admin.model.SalesRequest;
import com.bada_admin.service.CartService;
import com.bada_admin.service.MemberService;
import com.bada_admin.service.MessageService;
import com.bada_admin.service.OrdersService;
import com.bada_admin.service.ProductService;
import com.bada_admin.service.QnaService;
import com.bada_admin.service.SalesRequestService;
import com.bada_admin.service.impl.CartServiceImpl;
import com.bada_admin.service.impl.MemberServiceImpl;
import com.bada_admin.service.impl.MessageServiceImpl;
import com.bada_admin.service.impl.OrdersServiceImpl;
import com.bada_admin.service.impl.ProductServiceImpl;
import com.bada_admin.service.impl.QnaServiceImpl;
import com.bada_admin.service.impl.SalesRequestServiceImpl;

@WebServlet("/member_manage/member_delete.do")
public class MemberDelete extends BaseController {

	private static final long serialVersionUID = 3378820998359426182L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	MemberService memberService;
	CartService cartService;
	MessageService messageService;
	OrdersService ordersService;
	ProductService productService;
	QnaService qnaService;
	SalesRequestService salesRequestService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		memberService = new MemberServiceImpl(sqlSession, logger);
		cartService = new CartServiceImpl(sqlSession, logger);
		messageService = new MessageServiceImpl(sqlSession, logger);
		ordersService = new OrdersServiceImpl(sqlSession, logger);
		productService = new ProductServiceImpl(sqlSession, logger);
		qnaService = new QnaServiceImpl(sqlSession, logger);
		salesRequestService = new SalesRequestServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		List<Integer> deleteList = null;
		
		try {
			deleteList = memberService.selectDeleteMember(null);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		try {
			for (int i = 0; i < deleteList.size(); i++) {
				int id = deleteList.get(i);
				
				Cart cart = new Cart();
				Message message = new Message();
				Orders orders = new Orders();
				Product product = new Product();
				Qna qna = new Qna();
				SalesRequest salesRequest = new SalesRequest();
				
				cart.setAdd_id(id);
				message.setSender_id(id);
				message.setReceiver_id(id);
				orders.setBuyer_id(id);
				product.setSeller_id(id);
				qna.setRequest_id(id);
				salesRequest.setMember_id(id);
				
				cartService.deleteCartUserOut(cart);
				messageService.updateMessageUserOut(message);
				messageService.deleteMessageUserOut(message);
				ordersService.updateOrdersUserOut(orders);
				productService.deleteProductUserOut(product);
				qnaService.updateQnaUserOut(qna);
				qnaService.deleteQnaUserOut(qna);
				salesRequestService.deleteSalesRequestUserOut(salesRequest);
			}
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		try {
			 memberService.deleteMember(null);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		web.redirect(web.getRootPath() + "/member_manage/member_list.do", "삭제되었습니다.");
		
		return null;
	}

}
