package com.bada_admin.controller.member_manage;

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
import com.bada_admin.model.Message;
import com.bada_admin.service.MessageService;
import com.bada_admin.service.impl.MessageServiceImpl;

@WebServlet("/member_manage/message_view.do")
public class MessageView extends BaseController {

	private static final long serialVersionUID = 2290886734958113255L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	MessageService messageService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		messageService = new MessageServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		
		Message message = new Message();
		message.setId(id);
		
		Message readMessage = null;
		try {
			readMessage = messageService.selectMessage(message);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("readMessage", readMessage);
		
		return "member_manage/message_view";
	}

}
