package com.bada_admin.controller.board_manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada_admin.helper.BaseController;

@WebServlet("/board_manage/qna_list.do")
public class QnaList extends BaseController {

	private static final long serialVersionUID = 3625862733263441967L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "board_manage/qna_list";
	}

}
