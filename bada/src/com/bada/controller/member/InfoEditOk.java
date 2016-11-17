package com.bada.controller.member;

import java.io.IOException;
import java.util.HashMap;
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
import com.bada.model.Member;
import com.bada.service.MemberService;
import com.bada.service.impl.MemberServiceImpl;

@WebServlet("/member/info_edit_ok.do")
public class InfoEditOk extends BaseController {

	private static final long serialVersionUID = -3147119297875172735L;
	SqlSession sqlSession;
	Logger logger;
	WebHelper web;
	RegexHelper regex;
	UploadHelper upload;
	MemberService memberService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		upload = UploadHelper.getInstance();
		memberService = new MemberServiceImpl(sqlSession, logger);
		
		if(web.getSession("loginInfo") == null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "로그인 후 이용가능합니다.");
			return null;
		}
		
		Map<String, String> paramMap = new HashMap<String, String>();
		
		try {
			upload.multipartRequest(request);
		} catch (Exception e) {
			sqlSession.close();
			web.redirect(null, "multipart 데이터가 아닙니다.");
			return null;
		}
		
		paramMap = upload.getParamMap();
		int id = Integer.parseInt(paramMap.get("id"));
		String name = paramMap.get("name");
		String tel = paramMap.get("tel");
		String postcode = paramMap.get("postcode");
		String addr1 = paramMap.get("addr1");
		String addr2 = paramMap.get("addr2");
		String email = paramMap.get("email");
		
		logger.debug("id : " + id);
		logger.debug("name : " + name);
		logger.debug("tel : " + tel);
		logger.debug("postcode : " + postcode);
		logger.debug("addr1 : " + addr1);
		logger.debug("addr2 : " + addr2);
		logger.debug("email : " + email);
		
		/* 이름 유효성 검사 */
		if(!regex.isValue(name)) {
			sqlSession.close();
			web.redirect(null, "이름을 입력해주세요.");
			return null;
		}
		
		if(!regex.isKorEng(name)) {
			sqlSession.close();
			web.redirect(null, "이름은 한글과 영어만 입력 가능합니다.");
			return null;
		}
		
		if(name.length() < 2 || name.length() > 5) {
			sqlSession.close();
			web.redirect(null, "이름은 2~5글자 까지만 가능합니다.");
			return null;
		}
		
		/* 이메일 유효성 검사 */
		if(!regex.isValue(email)) {
			sqlSession.close();
			web.redirect(null, "이메일을 입력해주세요.");
			return null;
		}
		
		if(!regex.isEmail(email)) {
			sqlSession.close();
			web.redirect(null, "이메일형식이 잘못되었습니다.");
			return null;
		}
		
		/* 연락처 유효성 검사 */
		if(!regex.isValue(tel)) {
			sqlSession.close();
			web.redirect(null, "연락처를 입력해주세요.");
			return null;
		}
		
		if(!regex.isCellPhone(tel) && !regex.isTel(tel)) {
			sqlSession.close();
			web.redirect(null, "연락처형식이 잘못되었습니다.");
			return null;
		}
		
		List<FileInfo> fileList = upload.getFileList();
		String profile_img = null;
		if(fileList.size() > 0) {
			FileInfo info = fileList.get(0);
			profile_img = info.getFileDir() + "/" + info.getFileName();
		}
		
		Member member = new Member();
		member.setId(id);
		member.setName(name);
		member.setTel(tel);
		member.setPostcode(postcode);
		member.setAddr1(addr1);
		member.setAddr2(addr2);
		member.setEmail(email);
		member.setProfile_img(profile_img);
		
		try {
			memberService.updateMember(member);
		} catch (Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		web.redirect(web.getRootPath() + "/member/my_info.do", "수정되었습니다.");
		
		return null;
	}

}
