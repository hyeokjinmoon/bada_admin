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
import com.bada.helper.WebHelper;
import com.bada.model.Member;
import com.bada.model.Message;
import com.bada.service.MessageService;
import com.bada.service.impl.MessageServiceImpl;

@WebServlet("/member/message_delete.do")
public class MessageDelete extends BaseController {

	private static final long serialVersionUID = 8908177791898104105L;
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
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		String flag = web.getString("flag");
		logger.debug("id : " + id);
		Message message = new Message();
		message.setId(id);
		
		try {
			messageService.deleteMessage(message);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		String url = web.getRootPath();
		if(flag.equals("receive")) {
			url += "/member/receive_message_list.do";
		} else {
			url += "/member/send_message_list.do";
		}
		
		web.redirect(url, "삭제되었습니다.");
		
		return null;
	}

}
