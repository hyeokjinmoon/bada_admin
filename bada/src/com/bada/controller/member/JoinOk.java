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
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/member/join_ok.do")
public class JoinOk extends BaseController {

	private static final long serialVersionUID = 1126541083170220445L;
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
		
		if(web.getSession("loginInfo") != null) {
			sqlSession.close();
			web.redirect(web.getRootPath() + "/shop/main.do", "이미 로그인 중 입니다.");
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
		
		String user_id = paramMap.get("user_id");
		String user_pw = paramMap.get("user_pw");
		String user_pw_re = paramMap.get("user_pw_re");
		String name = paramMap.get("name");
		String tel = paramMap.get("tel");
		String postcode = paramMap.get("postcode");
		String addr1 = paramMap.get("addr1");
		String addr2 = paramMap.get("addr2");
		String email = paramMap.get("email");
		
		logger.debug("user_id : " + user_id);
		logger.debug("user_pw : " + user_pw);
		logger.debug("user_pw_re : " + user_pw_re);
		logger.debug("name : " + name);
		logger.debug("tel : " + tel);
		logger.debug("postcode : " + postcode);
		logger.debug("addr1 : " + addr1);
		logger.debug("addr2 : " + addr2);
		logger.debug("email : " + email);
		
		/* 아이디 유효성 검사 */
		if(!regex.isValue(user_id)) {
			sqlSession.close();
			web.redirect(null, "아이디를 입력해주세요.");
			return null;
		}
		
		if(!regex.isEngNum(user_id)) {
			sqlSession.close();
			web.redirect(null, "아이디는 영문과 숫자의 조합으로 20자까지만 입력가능합니다.");
			return null;
		}
		
		if(user_id.length() > 20) {
			sqlSession.close();
			web.redirect(null, "아이디는 영문과 숫자의 조합으로 20자까지만 입력가능합니다.");
			return null;
		}
		
		/* 비밀번호 유효성 검사 */
		if(!regex.isValue(user_pw)) {
			sqlSession.close();
			web.redirect(null, "비밀번호를 입력해주세요.");
			return null;
		}
		
		if(!regex.isEngNum(user_pw)) {
			sqlSession.close();
			web.redirect(null, "비밀번호는 영문과 숫자의 조합으로 20자까지만 입력가능합니다.");
			return null;
		}
		
		if(user_pw.length() > 20) {
			sqlSession.close();
			web.redirect(null, "비밀번호는 영문과 숫자의 조합으로 20자까지만 입력가능합니다.");
			return null;
		}
		
		if(!user_pw.equals(user_pw_re)) {
			sqlSession.close();
			web.redirect(null, "비밀번호 확인이 잘못되었습니다.");
			return null;
		}
		
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
		member.setUser_id(user_id);
		member.setUser_pw(user_pw);
		member.setName(name);
		member.setTel(tel);
		member.setPostcode(postcode);
		member.setAddr1(addr1);
		member.setAddr2(addr2);
		member.setEmail(email);
		member.setProfile_img(profile_img);
		
		try {
			memberService.insertMember(member);
		} catch (Exception e) {
			web.printJsonRt(e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rt", "OK");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), data);
		
		return null;
	}

}
