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
import com.bada_admin.helper.PageHelper;
import com.bada_admin.helper.WebHelper;
import com.bada_admin.model.Message;
import com.bada_admin.service.MessageService;
import com.bada_admin.service.impl.MessageServiceImpl;

@WebServlet("/member_manage/message_list.do")
public class MessageList extends BaseController {

	private static final long serialVersionUID = 5222984509848744122L;
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
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int page = web.getInt("page", 1);
		int totalCount = 0;
		
		List<Message> messageList = null;
		Message message = new Message();
		
		try {
			totalCount = messageService.selectMessageCount(message);
			pageHelper.pageProcess(page, totalCount, 7, 5);
			
			message.setLimitStart(pageHelper.getLimitStart());
			message.setListCount(pageHelper.getListCount());
			messageList = messageService.selectMessageList(message);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("messageList", messageList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "member_manage/message_list";
	}

}
