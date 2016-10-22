package com.bada_admin.controller.shop_manage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada_admin.dao.MyBatisConnectionFactory;
import com.bada_admin.helper.BaseController;
import com.bada_admin.helper.FileInfo;
import com.bada_admin.helper.RegexHelper;
import com.bada_admin.helper.UploadHelper;
import com.bada_admin.helper.WebHelper;
import com.bada_admin.model.Product;
import com.bada_admin.service.ProductService;
import com.bada_admin.service.impl.ProductServiceImpl;

@WebServlet("/shop_manage/product_register_ok.do")
public class ProductRegisterOk extends BaseController {

	private static final long serialVersionUID = 1956304767922969860L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	RegexHelper regex;
	UploadHelper upload;
	ProductService productService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		upload = UploadHelper.getInstance();
		productService = new ProductServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
			web.redirect(web.getRootPath() + "/index", "로그인 후 이용가능합니다.");
			return null;
		}
		
		try {
			upload.multipartRequest(request);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, "multipart 데이터가 아닙니다.");
			return null;
		}
		
		Map<String, String> paramMap = upload.getParamMap();
		int seller_id = Integer.parseInt(paramMap.get("seller_id"));
		String product_name = paramMap.get("product_name");
		String list_price = paramMap.get("list_price");
		String sale_price = paramMap.get("sale_price");
		
		if(!regex.isValue(product_name)) {
			sqlSession.close();
			web.redirect(null, "상품명을 입력해주세요.");
			return null;
		}
		if(!regex.isValue(list_price)) {
			sqlSession.close();
			web.redirect(null, "정가를 입력해주세요.");
			return null;
		}
		if(!regex.isNum(list_price)) {
			sqlSession.close();
			web.redirect(null, "숫자만 입력가능합니다.");
			return null;
		}
		if(!regex.isValue(sale_price)) {
			sqlSession.close();
			web.redirect(null, "판매가를 입력해주세요.");
			return null;
		}
		if(!regex.isNum(sale_price)) {
			sqlSession.close();
			web.redirect(null, "숫자만 입력가능합니다.");
			return null;
		}

		logger.debug("seller_id : " + seller_id);
		logger.debug("product_name : " + product_name);
		logger.debug("list_price : " + list_price);
		logger.debug("sale_price : " + sale_price);
		
		String product_img = null;
		List<FileInfo> fileList = upload.getFileList();
		for(int i = 0; i < fileList.size(); i++) {
			FileInfo f = fileList.get(i);
			product_img = f.getFileDir() + "/" + f.getFileName();
		}
		
		Product product = new Product();
		product.setProduct_name(product_name);;
		product.setList_price(Integer.parseInt(list_price));
		product.setSale_price(Integer.parseInt(sale_price));
		product.setSeller_id(seller_id);
		product.setProduct_img(product_img);
		
		try {
			productService.insertProductBada(product);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		web.redirect(web.getRootPath() +"/shop_manage/product_view.do?id=" + product.getId(), "상품이 등록되었습니다.");
		
		return null;
	}

}
