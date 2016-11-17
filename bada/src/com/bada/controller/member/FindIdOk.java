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
import com.bada.service.MemberService;
import com.bada.service.impl.MemberServiceImpl;

@WebServlet("/member/find_id_ok.do")
public class FindIdOk extends BaseController {

	private static final long serialVersionUID = -2890503699593589820L;
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
			web.redirect(web.getRootPath() + "/shop/main.do", "이미 로그인 중입니다.");
			return null;
		}
		
		String email = web.getString("email");
		
		if(!regex.isValue(email)){
			sqlSession.close();
			web.redirect(null, "이메일을 입력하세요.");
			return null;
		}
		if(!regex.isEmail(email)) {
			sqlSession.close();
			web.redirect(null, "이메일 형식이 아닙니다.");
			return null;
		}
		
		Member member = new Member();
		member.setEmail(email);
		
		String user_id = null;
		try {
			user_id = memberService.selectFindId(member);
			if(user_id == null) {
				throw new Exception("해당하는 이메일이 없습니다.");
			}
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		String url = "%s/member/find_id_view.do?user_id=%s";
		url = String.format(url, web.getRootPath(), user_id);
		
		web.redirect(url, "아이디를 확인하세요.");
		
		return null;
	}

}
