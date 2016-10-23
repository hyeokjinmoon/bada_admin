package com.bada_admin.service;

import java.util.List;

import com.bada_admin.model.Member;

public interface MemberService {
	
	public Member selectAdminLoginInfo(Member member) throws Exception;
	
	public List<Member> selectMemberList(Member member) throws Exception;
	
	public Member selectMember(Member member) throws Exception;
	
	public int selectMemberCount(Member member) throws Exception;
	
	public void updateMember(Member member) throws Exception;
	
	public String selectMemberName(Member member) throws Exception;
	
	public List<Member> selectMemberDashboard(Member member) throws Exception;
	
}
