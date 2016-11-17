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

@WebServlet("/member/out_ok.do")
public class OutOk extends BaseController {

	private static final long serialVersionUID = -4932260004335596664L;
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
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		String user_pw = web.getString("user_pw");
		
		if(!regex.isValue(user_pw)) {
			sqlSession.close();
			web.redirect(null, "비밀번호를 입력하세요");
			return null;
		}
		
		Member member = new Member();
		member.setId(id);
		member.setUser_pw(user_pw);
		
		
		try {
			int count = memberService.selectPwCountById(member);
			if(count == 0) {
				throw new Exception("비밀번호를 확인해주세요.");
			}
			
			memberService.updateMemberOut(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		web.removeAllSession();
		
		web.redirect(web.getRootPath() + "/index", "탈퇴되었습니다.");
		
		return null;
	}

}
