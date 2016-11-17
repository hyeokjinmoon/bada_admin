package com.bada.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada.helper.BaseController;
import com.bada.helper.WebHelper;

@WebServlet("/member/message_write.do")
public class MessageWrite extends BaseController {

	private static final long serialVersionUID = 6467665494911652203L;
	WebHelper web;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		web = WebHelper.getInstance(request, response);
		
		if(web.getSession("loginInfo") == null) {
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		return "member/message_write";
	}

}
