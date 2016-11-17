package com.bada.controller.shop;

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

import com.bada.dao.MyBatisConnectionFactory;
import com.bada.helper.BaseController;
import com.bada.helper.FileInfo;
import com.bada.helper.RegexHelper;
import com.bada.helper.UploadHelper;
import com.bada.helper.WebHelper;
import com.bada.model.Product;
import com.bada.service.ProductService;
import com.bada.service.impl.ProductServiceImpl;

@WebServlet("/shop/product_regist_ok.do")
public class ProductRegistrationOk extends BaseController {

	private static final long serialVersionUID = -5555158317699657130L;
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
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
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
		int list_price = Integer.parseInt(paramMap.get("list_price"));
		int sale_price = Integer.parseInt(paramMap.get("sale_price"));
		String category = paramMap.get("category");
		
		if(!regex.isValue(product_name)) {
			sqlSession.close();
			web.redirect(null, "상품명을 입력해주세요.");
			return null;
		}
		
		List<FileInfo> fileList = upload.getFileList();
		String product_img = null;
		if(fileList.size() > 0) {
			FileInfo f = fileList.get(0);
			product_img = f.getFileDir() + "/" + f.getFileName();
		}
		
		Product product = new Product();
		product.setProduct_name(product_name);
		product.setList_price(list_price);
		product.setSale_price(sale_price);
		product.setSeller_id(seller_id);
		product.setProduct_img(product_img);
		product.setCategory(category);
		
		logger.debug("seller_id : " + seller_id);
		logger.debug("product_name : " + product_name);
		logger.debug("list_price : " + list_price);
		logger.debug("sale_price : " + sale_price);
		logger.debug("product_img : " + product_img);
		
		try {
			productService.insertProduct(product);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		web.redirect(web.getRootPath() + "/shop/sale_list.do?seller_id=" + product.getSeller_id(), "판매 신청 하였습니다.");
		
		return null;
	}

}
