package com.bada.service;

import java.util.List;

import com.bada.model.NoticeFaq;

public interface NoticeFaqService {
	
	public int selectNoticeFaqCount(NoticeFaq noticeFaq) throws Exception;
	
	public List<NoticeFaq> selectNoticeFaqList(NoticeFaq noticeFaq) throws Exception;
	
	public NoticeFaq selectNoticeFaqView(NoticeFaq noticeFaq) throws Exception;
}
