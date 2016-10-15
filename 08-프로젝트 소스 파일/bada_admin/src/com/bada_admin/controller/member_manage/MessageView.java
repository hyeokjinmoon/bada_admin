package com.bada_admin.controller.member_manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada_admin.helper.BaseController;

@WebServlet("/member_manage/message_view.do")
public class MessageView extends BaseController {

	private static final long serialVersionUID = 2290886734958113255L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "member_manage/message_view";
	}

}
