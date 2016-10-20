package com.bada_admin.service;

import java.util.List;

import com.bada_admin.model.Message;

public interface MessageService {
	
	public List<Message> selectMessageList(Message message) throws Exception;
	
	public Message selectMessage(Message message) throws Exception;
	
	public void insertMessage(Message message) throws Exception;
	
	public int selectMessageCount(Message message) throws Exception;
}
