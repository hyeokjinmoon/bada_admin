package com.bada_admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada_admin.model.Member;
import com.bada_admin.service.MemberService;

public class MemberServiceImpl implements MemberService {

	SqlSession sqlSession;
	Logger logger;
	
	public MemberServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public Member selectAdminLoginInfo(Member member) throws Exception {
		Member result = null;
		try{
			result = sqlSession.selectOne("MemberMapper.selectAdminLoginInfo", member);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("로그인 정보가 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("로그인 정보 검색에 실패했습니다.");
		}
		return result;
	}

	@Override
	public List<Member> selectMemberList(Member member) throws Exception {
		List<Member> result = null;
		try {
			result = sqlSession.selectList("MemberMapper.selectMemberList", member);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 회원 목록이 없습니다.");
		} catch (Exception e) {
			throw new Exception("회원 목록 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public Member selectMember(Member member) throws Exception {
		Member result = null;
		try {
			result = sqlSession.selectOne("MemberMapper.selectMember", member);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 회원이 없습니다.");
		} catch (Exception e) {
			throw new Exception("회원 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectMemberCount(Member member) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("MemberMapper.selectMemberCount", member);
			if(result == 0){
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 회원 수가 없습니다.");
		} catch (Exception e) {
			throw new Exception("회원수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateMember(Member member) throws Exception {
		try {
			int result = sqlSession.update("MemberMapper.updateMember", member);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("수정할 회원 정보가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("회원 정보 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public String selectMemberName(Member member) throws Exception {
		String result = null;
		try {
			result = sqlSession.selectOne("MemberMapper.selectMemberName", member);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 회원 이름이 없습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("회원 이름 조회에 실패했습니다.");
		}
		return result;
	}

}
