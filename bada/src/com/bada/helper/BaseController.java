package com.bada.helper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 기본 컨트롤러. 모든 컨트롤러가 상속받을 컨트롤러
 */
public abstract class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Logger logger = null;
    /**
     * @see 현재 실행중인 컨트롤러의 이름을 출력
     */
    public BaseController() {
        String className = this.getClass().getName();
        logger = LogManager.getLogger(className);
    }

	/**
	 * @see doGet에서 pageInit호출
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.pageInit(request, response);
	}

	/**
	 * @see doPost에서 pageInit호출
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.pageInit(request, response);
	}
	
	/**
	 * doGet, doPost에서 호출할 메소드. 모든 방식을 이곳에서 처리한다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void pageInit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset-UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String url = request.getRequestURL().toString();
		
		if(request.getQueryString() != null) {
			url = url + "?" + request.getQueryString();
		}
		
		String methodName = request.getMethod();
		
		logger.info("[" + methodName + "]" + url);
		
		String view = this.doRun(request, response);
		
		if(view != null) {
			view = "/WEB-INF/views/" + view + ".jsp";
			logger.info("[View]" + view);
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
	
	public abstract String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
