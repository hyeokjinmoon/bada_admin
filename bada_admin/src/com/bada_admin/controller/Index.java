package com.bada_admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada_admin.helper.BaseController;
import com.bada_admin.helper.WebHelper;

@WebServlet("/index")
public class Index extends BaseController {

	private static final long serialVersionUID = 7976784466598066397L;
	Logger logger;
	WebHelper web;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		
		if(web.getSession("loginInfo") != null) {
			web.redirect(web.getRootPath() + "/board_manage/dashboard.do", "이미 로그인중입니다.");
			return null;
		}
		
		return "index";
	}

}
