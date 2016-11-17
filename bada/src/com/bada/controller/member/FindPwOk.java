package com.bada.controller.member;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada.dao.MyBatisConnectionFactory;
import com.bada.helper.BaseController;
import com.bada.helper.MailHelper;
import com.bada.helper.Util;
import com.bada.helper.WebHelper;
import com.bada.model.Member;
import com.bada.service.MemberService;
import com.bada.service.impl.MemberServiceImpl;


@WebServlet("/member/find_pw_ok.do")
public class FindPwOk extends BaseController {

	private static final long serialVersionUID = 8338296586718448201L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	MailHelper mail;
	Util util;
	MemberService memberService;
	
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		mail = MailHelper.getInstance();
		util = Util.getInstance();
		memberService = new MemberServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") != null) {
			web.redirect(web.getRootPath() + "/shop/main.do", "이미 로그인 중입니다.");
			return null;
		}
		
		if(web.getSession("loginInfo") != null) {
			web.redirect(web.getRootPath() + "/index.do", "이미 로그인 되었습니다.");
			return null;
		}
		
		String email = web.getString("email");
		logger.debug("email : " + email);
		
		if(email == null) {
			sqlSession.close();
			web.redirect(null, "이메일 주소를 입력하세요.");
			return null;
		}
		
		String newPassword = util.getRandomPassword();
		
		Member member = new Member();
		member.setEmail(email);
		member.setUser_pw(newPassword);
		
		try {
			memberService.updateMemberPwByEmail(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		String sender = "webmaster@bada.com";
		String subject = "바다 비밀번호 변경 안내";
		String content = "회원님의 새로운 비밀번호는 <strong>" + newPassword + "</strong> 입니다.";
		
		try {
			mail.sendMail(sender, email, subject, content);
		} catch (MessagingException e) {
			e.printStackTrace();
			web.redirect(null, "메일 발송에 실패했습니다. 관리자에게 문의하시기 바랍니다.");
			return null;
		}
		
		web.redirect(null, "새로운 비밀번호가 메일로 발송되었습니다.");
		
		
		return null;
	}

}
