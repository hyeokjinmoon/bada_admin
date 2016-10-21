package com.bada_admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bada_admin.helper.BaseController;
import com.bada_admin.helper.UploadHelper;
import com.bada_admin.helper.WebHelper;

@WebServlet("/download.do")
public class Download extends BaseController {

	private static final long serialVersionUID = 788977139083197914L;
	
	Logger logger;
	WebHelper web;
	UploadHelper upload;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		upload = UploadHelper.getInstance();
		
		String filePath = web.getString("file");
		// String originName = web.getString("origin");
		
		if(filePath != null) {
			try {
				logger.debug("Create Thumbnail Image : " + filePath);
				upload.printFileStream(response, filePath, 320, 180, true);
				// upload.printFileStream(response, filePath, originName);
			} catch(Exception e) {
				logger.debug(e.getLocalizedMessage());
			}
		}
		
		return null;
	}

}
