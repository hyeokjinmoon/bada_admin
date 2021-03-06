package com.bada_admin.service;

import java.util.List;

import com.bada_admin.model.NoticeFaq;

public interface NoticeFaqService {
	
	public void insertNoticeFaq(NoticeFaq noticeFaq) throws Exception;
	
	public NoticeFaq selectNoticeFaqView(NoticeFaq noticeFaq) throws Exception;
	
	public NoticeFaq selectPrevNoticeFaqView(NoticeFaq noticeFaq) throws Exception;
	
	public NoticeFaq selectNextNoticeFaqView(NoticeFaq noticeFaq) throws Exception;
	
	public List<NoticeFaq> selectNoticeFaqList(NoticeFaq noticeFaq) throws Exception;
	
	public int selectNoticeFaqCount(NoticeFaq noticeFaq) throws Exception;
	
	public void updateNoticeFaq(NoticeFaq noticeFaq) throws Exception;
	
	public void deleteNoticeFaq(NoticeFaq noticeFaq) throws Exception;
}
