package com.bada.controller.member;

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
import com.bada.helper.PageHelper;
import com.bada.helper.WebHelper;
import com.bada.model.Member;
import com.bada.model.Message;
import com.bada.service.MessageService;
import com.bada.service.impl.MessageServiceImpl;

@WebServlet("/member/receive_message_list.do")
public class ReceiveMessageList extends BaseController {

	private static final long serialVersionUID = 6818782358440257323L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	PageHelper pageHelper;
	MessageService messageService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		pageHelper = PageHelper.getInstance();
		messageService = new MessageServiceImpl(sqlSession, logger);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int receiver_id = loginInfo.getId();
		int page = web.getInt("page", 1);
		int totalCount = 0;
		
		Message message = new Message();
		message.setReceiver_id(receiver_id);
		
		List<Message> messageList = null;
		try {
			totalCount = messageService.selectReceiveMessageCount(message);
			pageHelper.pageProcess(page, totalCount, 8, 5);
			message.setLimitStart(pageHelper.getLimitStart());
			message.setListCount(pageHelper.getListCount());
			
			messageList = messageService.selectReceiveMessageList(message);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("messageList", messageList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "member/receive_message_list";
	}

}
