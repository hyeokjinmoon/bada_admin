package com.bada.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada.helper.BaseController;
import com.bada.helper.WebHelper;
import com.bada.model.Member;

@WebServlet("/member/sale_request.do")
public class SaleRequest extends BaseController {

	private static final long serialVersionUID = -4888463297057246742L;
	WebHelper web;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		web = WebHelper.getInstance(request, response);
		
		Member loginInfo = (Member) web.getSession("loginInfo");
		if(loginInfo == null) {
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		return "member/sale_request";
	}

}
