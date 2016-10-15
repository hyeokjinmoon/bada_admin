package com.bada_admin.controller.shop_manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada_admin.helper.BaseController;

@WebServlet("/shop_manage/ok_request_view.do")
public class OkRequestView extends BaseController {

	private static final long serialVersionUID = 6103137953682435243L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "shop_manage/ok_request_view";
	}

}
