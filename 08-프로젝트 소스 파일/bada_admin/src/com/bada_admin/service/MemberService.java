package com.bada_admin.service;

import com.bada_admin.model.Member;

public interface MemberService {
	
	public Member selectAdminLoginInfo(Member member) throws Exception;
	
}
