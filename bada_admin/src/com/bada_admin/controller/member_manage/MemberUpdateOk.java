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
import com.bada_admin.model.Member;
import com.bada_admin.service.MemberService;
import com.bada_admin.service.impl.MemberServiceImpl;

@WebServlet("/member_manage/member_update_ok.do")
public class MemberUpdateOk extends BaseController {

	private static final long serialVersionUID = 5420939683595850259L;
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
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int id = web.getInt("id");
		String name = web.getString("name");
		String email = web.getString("email");
		String tel = web.getString("tel");
		String postcode = web.getString("postcode");
		String addr1 = web.getString("addr1");
		String addr2 = web.getString("addr2");
		
		if(!regex.isValue(name)){
			sqlSession.close();
			web.redirect(null, "이름을 입력해주세요.");
			return null;
		}
		if(!regex.isKorEng(name)) {
			sqlSession.close();
			web.redirect(null, "이름은 한글과 영문만 입력가능합니다.");
			return null;
		}
		
		if(!regex.isValue(email)) {
			sqlSession.close();
			web.redirect(null, "이메일을 입력해주세요.");
			return null;
		}
		if(!regex.isEmail(email)) {
			sqlSession.close();
			web.redirect(null, "이메일의 형식이 잘못되었습니다.");
			return null;
		}
		
		if(!regex.isValue(tel)) {
			sqlSession.close();
			web.redirect(null, "연락처를 입력해주세요.");
			return null;
		}
		if(!regex.isTel(tel)) {
			sqlSession.close();
			web.redirect(null, "연락처의 형식이 잘못되었습니다.");
			return null;
		}
		
		Member member = new Member();
		member.setId(id);
		member.setName(name);
		member.setEmail(email);
		member.setTel(tel);
		member.setPostcode(postcode);
		member.setAddr1(addr1);
		member.setAddr2(addr2);
		
		try {
			memberService.updateMember(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		String url = "%s/member_manage/member_view.do?id=%d";
		url = String.format(url, web.getRootPath(), id);
		
		web.redirect(url, "회원 정보가 수정되었습니다.");
		
		return null;
	}

}
