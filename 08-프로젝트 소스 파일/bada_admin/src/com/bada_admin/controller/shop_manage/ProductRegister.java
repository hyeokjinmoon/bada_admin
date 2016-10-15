package com.bada_admin.controller.shop_manage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bada_admin.helper.BaseController;

@WebServlet("/shop_manage/product_register.do")
public class ProductRegister extends BaseController {

	private static final long serialVersionUID = 4036885142324274792L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "shop_manage/product_register";
	}

}
