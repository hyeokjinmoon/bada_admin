package com.bada.controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import com.bada.service.MemberService;
import com.bada.service.impl.MemberServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/member/id_dupl_check.do")
public class IdDuplicateCheck extends BaseController {

	private static final long serialVersionUID = -929315297327343170L;
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
		response.setContentType("application/json");
		
		String user_id = web.getString("user_id");
		
		Member member = new Member();
		member.setUser_id(user_id);
		
		int count = 0;
		
		try {
			count = memberService.selectUserIdCount(member);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		data.put("count", count);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), data);
		
		return null;
	}

}
