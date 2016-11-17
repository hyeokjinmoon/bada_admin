package com.bada.controller;

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
import com.bada.service.MemberService;
import com.bada.service.impl.MemberServiceImpl;

@WebServlet("/login_ok.do")
public class LoginOk extends BaseController {

	private static final long serialVersionUID = 8057113285047578742L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	RegexHelper regex;
	MemberService memberService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		memberService = new MemberServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") != null) {
			sqlSession.close();
			web.redirect(null, "이미 로그인 중 입니다.");
			return null;
		}
		
		String user_id = web.getString("user_id");
		String user_pw = web.getString("user_pw");
		
		if(!regex.isValue(user_id)) {
			sqlSession.close();
			web.redirect(null, "아이디를 입력해주세요.");
			return null;
		}
		if(!regex.isValue(user_pw)) {
			sqlSession.close();
			web.redirect(null, "비밀번호를 입력해주세요.");
			return null;
		}
		
		Member member = new Member();
		member.setUser_id(user_id);
		member.setUser_pw(user_pw);
		
		Member loginInfo = null;
		
		try {
			loginInfo = memberService.selectLoginInfo(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		web.setSession("loginInfo", loginInfo);
		
		web.redirect(request.getHeader("referer"), loginInfo.getName() + "님 환영합니다.");
		
		return null;
	}

}
