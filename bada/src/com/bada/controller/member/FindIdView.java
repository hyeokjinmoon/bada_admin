package com.bada.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada.helper.BaseController;
import com.bada.helper.WebHelper;

@WebServlet("/member/find_id_view.do")
public class FindIdView extends BaseController {

	private static final long serialVersionUID = -1990106022869006762L;
	WebHelper web;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		web = WebHelper.getInstance(request, response);
		
		if(web.getSession("loginInfo") != null) {
			web.redirect(web.getRootPath() + "/shop/main.do", "이미 로그인 중입니다.");
			return null;
		}

		String user_id = web.getString("user_id");
		
		request.setAttribute("user_id", user_id);
		
		return "member/find_id_view";
	}

}
