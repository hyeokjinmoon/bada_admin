package com.bada_admin.controller.shop_manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada_admin.helper.BaseController;

@WebServlet("/shop_manage/trade_list.do")
public class TradeList extends BaseController {

	private static final long serialVersionUID = -5401190353289542799L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "shop_manage/trade_list";
	}

}
