package com.bada_admin.controller;

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
import com.bada_admin.model.Member;
import com.bada_admin.service.MemberService;
import com.bada_admin.service.impl.MemberServiceImpl;

@WebServlet("/login_ok.do")
public class LoginOk extends BaseController {

	private static final long serialVersionUID = -1607996584263050057L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	MemberService memberService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		memberService = new MemberServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") != null){
			web.redirect("/board_manage/dashboard.do", "이미 로그인중입니다.");
			return null;
		}
		
		String user_id = web.getString("user_id");
		String user_pw = web.getString("user_pw");
		
		Member member = new Member();
		member.setUser_id(user_id);
		member.setUser_pw(user_pw);
		
		Member loginInfo = null;
		
		try {
			loginInfo = memberService.selectAdminLoginInfo(member);
		} catch(Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		web.setSession("loginInfo", loginInfo);
		
		sqlSession.close();
		web.redirect(web.getRootPath() + "/board_manage/dashboard.do", null);
		
		return null;
	}

}
