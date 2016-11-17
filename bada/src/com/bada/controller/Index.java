package com.bada.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada.helper.BaseController;
import com.bada.helper.WebHelper;
import com.bada.model.Member;

@WebServlet("/index")
public class Index extends BaseController {

	private static final long serialVersionUID = -4638419846684106574L;
	WebHelper web;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		web = WebHelper.getInstance(request, response);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		
		request.setAttribute("loginInfo", loginInfo);

		return "index";
	}

}
