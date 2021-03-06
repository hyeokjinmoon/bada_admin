package com.bada.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada.helper.BaseController;
import com.bada.helper.WebHelper;

@WebServlet("/logout.do")
public class Logout extends BaseController {

	private static final long serialVersionUID = -659047226277911062L;
	WebHelper web;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		web = WebHelper.getInstance(request, response);
		
		if(web.getSession("loginInfo") == null) {
			web.redirect(null, "로그인 후 이용가능합니다.");
			return null;
		}
		
		web.removeAllSession();
		
		web.redirect(web.getRootPath() + "/shop/main.do", "로그아웃 되었습니다.");
		return null;
	}

}
