package com.bada.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada.helper.BaseController;
import com.bada.helper.WebHelper;

@WebServlet("/member/join.do")
public class Join extends BaseController {

	private static final long serialVersionUID = 7870027293516636080L;
	WebHelper web;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		web = WebHelper.getInstance(request, response);
		
		if(web.getSession("loginInfo") != null) {
			web.redirect(web.getRootPath() + "/shop/main.do", "이미 로그인 중 입니다.");
			return null;
		}
		
		return "member/join";
	}

}
