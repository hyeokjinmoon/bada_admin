package com.bada_admin.service;

import java.util.List;

import com.bada_admin.model.QnaMemberJoin;

public interface QnaMemberService {
	
	public List<QnaMemberJoin> selectQnaMemberJoinList(QnaMemberJoin qnaMemberJoin) throws Exception;
	
	public QnaMemberJoin selectQnaMemberJoin(QnaMemberJoin qnaMemberJoin) throws Exception;
	
	public String selectAnswerStatus(QnaMemberJoin	qnaMemberJoin) throws Exception;
}
