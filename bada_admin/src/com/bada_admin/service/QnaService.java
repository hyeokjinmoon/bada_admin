package com.bada_admin.service;

import java.util.List;

import com.bada_admin.model.Qna;

public interface QnaService {
	
	public void insertQna(Qna qna) throws Exception;
	
	public List<Qna> selectQnaList(Qna qna) throws Exception;
	
	public int selectQnaCount(Qna qna) throws Exception;
	
	public void updateQnaAnswer(Qna qna) throws Exception;
	
	public void updateAnswer(Qna qna) throws Exception;
	
	public void deleteQna(Qna qna) throws Exception;
	
	public List<Qna> selectQnaDashboard(Qna qna) throws Exception;
	
	public void updateQnaUserOut(Qna qna) throws Exception;
	
	public void deleteQnaUserOut(Qna qna) throws Exception;
}
