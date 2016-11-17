package com.bada.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import com.bada.model.Member;
import com.bada.service.MemberService;

public class MemberServiceImpl implements MemberService {

	SqlSession sqlSession;
	Logger logger;
	
	public MemberServiceImpl(SqlSession sqlSession, Logger logger){
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public void insertMember(Member member) throws Exception {
		try {
			int result = sqlSession.insert("MemberMapper.insertMember", member);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("입력된 회원정보가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("회원정보 입력에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public int selectUserIdCount(Member member) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("MemberMapper.selectUserIdCount", member);
		} catch (Exception e) {
			throw new Exception("아이디 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectEmailCount(Member member) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("MemberMapper.selectEmailCount", member);
		} catch (Exception e) {
			throw new Exception("이메일 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public Member selectLoginInfo(Member member) throws Exception {
		Member result = null;
		try {
			result = sqlSession.selectOne("MemberMapper.selectLoginInfo", member);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("회원 정보가 없습니다.");
		} catch (Exception e) {
			throw new Exception("회원 정보 조회에 실패했습니다.");
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
			throw new Exception("수정된 정보가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("정보 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public void updateMemberOut(Member member) throws Exception {
		try {
			int result = sqlSession.update("MemberMapper.updateMemberOut", member);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("수정된 정보가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("정보 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public int selectPwCountById(Member member) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("MemberMapper.selectPwCountById", member);
		} catch (Exception e) {
			throw new Exception("비밀번호 검색에 실패했습니다.");
		}
		return result;
	}

	@Override
	public String selectFindId(Member member) throws Exception {
		String result = null;
		try {
			result = sqlSession.selectOne("MemberMapper.selectFindId", member);
		} catch (Exception e) {
			throw new Exception("아이디 겁색에 실패했습니다.");
		}
		return result;
	}

	@Override
	public Member selectInfoItem(Member member) throws Exception {
		Member result = null;
		try {
			result = sqlSession.selectOne("MemberMapper.selectInfoItem", member);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 회원정보가 없습니다.");
		} catch (Exception e) {
			throw new Exception("회원정보 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateMemberPwByEmail(Member member) throws Exception {
		try {
			int result = sqlSession.update("MemberMapper.updateMemberPwByEmail", member);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("수정된 비밀번호가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("비밀번호 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public int selectIdByUserId(Member member) throws Exception {
		int result = 0;
		try {
			result = sqlSession.selectOne("MemberMapper.selectIdByUserId", member);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 회원아이디가 없습니다.");
		} catch (Exception e) {
			throw new Exception("회원아이디 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public String selectNameById(Member member) throws Exception {
		String result = null;
		try {
			result = sqlSession.selectOne("MemberMapper.selectNameById", member);
			if(result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("조회된 회원 이름이 없습니다.");
		} catch (Exception e) {
			throw new Exception("회원 이름 조회에 실패했습니다.");
		}
		
		return result;
	}

}
