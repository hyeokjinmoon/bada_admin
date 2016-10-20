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
import com.bada_admin.helper.RegexHelper;
import com.bada_admin.helper.WebHelper;
import com.bada_admin.model.Message;
import com.bada_admin.service.MessageService;
import com.bada_admin.service.impl.MessageServiceImpl;

@WebServlet("/member_manage/message_write_ok.do")
public class MessageWriteOk extends BaseController {

	private static final long serialVersionUID = -88515476181031343L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	RegexHelper regex;
	MessageService messageService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		messageService = new MessageServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int sender_id = web.getInt("sender_id");
		int receiver_id = web.getInt("receiver_id");
		String content = web.getString("content");
		
		if(!regex.isValue(content)) {
			sqlSession.close();
			web.redirect(null, "내용을 입력해주세요.");
			return null;
		}
		
		Message message = new Message();
		message.setContent(content);
		message.setSender_id(sender_id);
		message.setReceiver_id(receiver_id);
		
		try {
			messageService.insertMessage(message);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		web.redirect(web.getRootPath() + "/member_manage/message_list.do", "쪽지를 보냈습니다.");
		
		return null;
	}

}
