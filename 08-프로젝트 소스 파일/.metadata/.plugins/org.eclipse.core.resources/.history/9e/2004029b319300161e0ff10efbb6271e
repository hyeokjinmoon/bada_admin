package com.bada_admin.controller.board_manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada_admin.helper.BaseController;
import com.bada_admin.helper.WebHelper;

@WebServlet("/board_manage/board_list.do")
public class BoardList extends BaseController {

	private static final long serialVersionUID = -5515122200787012967L;
	WebHelper web;
	BoardCommon board;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		web = WebHelper.getInstance(request, response);
		board = BoardCommon.getInstance();
		
		String category = web.getString("category");
		request.setAttribute("category", category);
		
		try {
			String boardName = board.getBoardName(category);
			request.setAttribute("boardName", boardName);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		return "board_manage/board_list";
	}

}
