package com.bada.service;

import java.util.List;

import com.bada.model.Qna;

public interface QnaService {
	
	public void insertQna(Qna qna) throws Exception;
	
	public List<Qna> selectMemberQnaList(Qna qna) throws Exception;
	
	public int selectMemberQnaCount(Qna qna) throws Exception;
	
	public Qna selectQnaView(Qna qna) throws Exception;
	
	public void deleteQna(Qna qna) throws Exception;
	
	public void updateQna(Qna qna) throws Exception;
}
