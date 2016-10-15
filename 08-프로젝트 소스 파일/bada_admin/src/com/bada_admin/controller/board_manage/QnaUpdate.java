package com.bada_admin.controller.board_manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada_admin.helper.BaseController;

@WebServlet("/board_manage/qna_update.do")
public class QnaUpdate extends BaseController {

	private static final long serialVersionUID = -971133133560575265L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "board_manage/qna_update";
	}

}
