package com.bada_admin.service;

import java.util.List;

import com.bada_admin.model.Qna;

public interface QnaService {
	
	public void insertQna(Qna qna) throws Exception;
	
	public List<Qna> selectQnaList(Qna qna) throws Exception;
	
	public int selectQnaCount(Qna qna) throws Exception;
}
