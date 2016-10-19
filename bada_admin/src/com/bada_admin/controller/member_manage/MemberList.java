package com.bada_admin.controller.member_manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada_admin.dao.MyBatisConnectionFactory;
import com.bada_admin.helper.BaseController;
import com.bada_admin.helper.PageHelper;
import com.bada_admin.helper.WebHelper;
import com.bada_admin.model.Member;
import com.bada_admin.service.MemberService;
import com.bada_admin.service.impl.MemberServiceImpl;

@WebServlet("/member_manage/member_list.do")
public class MemberList extends BaseController {

	private static final long serialVersionUID = -8732490816604078135L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	PageHelper pageHelper;
	MemberService memberService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		pageHelper = PageHelper.getInstance();
		memberService = new MemberServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		int page = web.getInt("page", 1);
		int totalCount = 0;
		
		List<Member> memberList = null;
		Member member = new Member();
		try {
			totalCount = memberService.selectMemberCount(member);
			pageHelper.pageProcess(page, totalCount, 10, 5);
			member.setLimitStart(pageHelper.getLimitStart());
			member.setListCount(pageHelper.getListCount());
			
			memberList = memberService.selectMemberList(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		request.setAttribute("memberList", memberList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "member_manage/member_list";
	}

}
