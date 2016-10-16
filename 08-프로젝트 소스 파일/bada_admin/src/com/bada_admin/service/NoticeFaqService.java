package com.bada_admin.service;

import com.bada_admin.model.NoticeFaq;

public interface NoticeFaqService {
	
	public void insertNoticeFaq(NoticeFaq noticeFaq) throws Exception;
	
	public NoticeFaq selectNoticeFaqView(NoticeFaq noticeFaq) throws Exception;
	
	public NoticeFaq selectPrevNoticeFaqView(NoticeFaq noticeFaq) throws Exception;
	
	public NoticeFaq selectNextNoticeFaqView(NoticeFaq noticeFaq) throws Exception;
}
