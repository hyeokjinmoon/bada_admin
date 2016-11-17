package com.bada.model;

public class Message {
	private int id;
	private String content;
	private String reg_date;
	private int sender_id;
	private int receiver_id;
	private String sender_name;
	private String receiver_name;
	private int limitStart;
	private int listCount;
	
	public String getSender_name() {
		return sender_name;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setSender_name(String sender_name) {
		this.sender_name = sender_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public int getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public int getSender_id() {
		return sender_id;
	}
	public int getReceiver_id() {
		return receiver_id;
	}
	public int getLimitStart() {
		return limitStart;
	}
	public int getListCount() {
		return listCount;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}
	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", reg_date=" + reg_date + ", sender_id=" + sender_id
				+ ", receiver_id=" + receiver_id + ", sender_name=" + sender_name + ", receiver_name=" + receiver_name
				+ ", limitStart=" + limitStart + ", listCount=" + listCount + "]";
	}
	
}
