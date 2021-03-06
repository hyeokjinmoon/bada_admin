package com.bada_admin.controller.board_manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada_admin.helper.BaseController;
import com.bada_admin.helper.WebHelper;

@WebServlet("/board_manage/noti_faq_write.do")
public class NoticeFaqWrite extends BaseController{

	private static final long serialVersionUID = -5508198495604981345L;
	WebHelper web;
	NoticeFaqCommon board;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		web = WebHelper.getInstance(request, response);
		board = NoticeFaqCommon.getInstance();
		
		if(web.getSession("loginInfo") == null) {
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		String category = web.getString("category");
		request.setAttribute("category", category);
		
		try {
			String boardName = board.getBoardName(category);
			request.setAttribute("boardName", boardName);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		return "board_manage/noti_faq_write";
	}

}
