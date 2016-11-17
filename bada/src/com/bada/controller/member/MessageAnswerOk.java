package com.bada.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada.dao.MyBatisConnectionFactory;
import com.bada.helper.BaseController;
import com.bada.helper.RegexHelper;
import com.bada.helper.WebHelper;
import com.bada.model.Member;
import com.bada.model.Message;
import com.bada.service.MemberService;
import com.bada.service.MessageService;
import com.bada.service.impl.MemberServiceImpl;
import com.bada.service.impl.MessageServiceImpl;

@WebServlet("/member/message_answer_ok.do")
public class MessageAnswerOk extends BaseController {

	private static final long serialVersionUID = -3658677083819679475L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	RegexHelper regex;
	MemberService memberService;
	MessageService messageService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		memberService = new MemberServiceImpl(sqlSession, logger);
		messageService = new MessageServiceImpl(sqlSession, logger);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		String content = web.getString("content"); 
		int sender_id = loginInfo.getId();
		int receiver_id = web.getInt("receiver_id");
		
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
		
		web.redirect(web.getRootPath() + "/member/send_message_list.do", "쪽지를 보냈습니다.");
		
		return null;
	}

}
