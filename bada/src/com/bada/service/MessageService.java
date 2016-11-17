package com.bada.service;

import java.util.List;

import com.bada.model.Message;

public interface MessageService {
	
	public void insertMessage(Message message) throws Exception;
	
	public List<Message> selectSendMessageList(Message message) throws Exception;
	
	public int selectSendMessageCount(Message message) throws Exception;
	
	public List<Message> selectReceiveMessageList(Message message) throws Exception;
	
	public int selectReceiveMessageCount(Message message) throws Exception;
	
	public Message selectMessage(Message message) throws Exception;
	
	public void deleteMessage(Message message) throws Exception;
}
