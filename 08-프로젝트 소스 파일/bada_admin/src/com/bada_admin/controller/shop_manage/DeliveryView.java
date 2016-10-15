package com.bada_admin.controller.shop_manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada_admin.helper.BaseController;

@WebServlet("/shop_manage/delivery_view.do")
public class DeliveryView extends BaseController {

	private static final long serialVersionUID = 6823517047751980491L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "shop_manage/delivery_view";
	}

}
