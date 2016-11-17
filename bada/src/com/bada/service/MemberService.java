package com.bada.service;

import com.bada.model.Member;

public interface MemberService {
	
	public void insertMember(Member member) throws Exception;
	
	public int selectUserIdCount(Member member) throws Exception;
	
	public int selectEmailCount(Member member) throws Exception;
	
	public Member selectLoginInfo(Member member) throws Exception;
	
	public void updateMember(Member member) throws Exception;
	
	public void updateMemberOut(Member member) throws Exception;
	
	public int selectPwCountById(Member member) throws Exception;
	
	public String selectFindId(Member member) throws Exception;
	
	public Member selectInfoItem(Member member) throws Exception;
	
	public void updateMemberPwByEmail(Member member) throws Exception;
	
	public int selectIdByUserId(Member member) throws Exception;
	
	public String selectNameById(Member member) throws Exception;
}
