package com.bada.model;

public class Qna {
	private int id;
	private String subject;
	private String req_type;
	private String content;
	private String answer;
	private String answer_status;
	private String reg_date;
	private String edit_date;
	private int request_id;
	private int answer_id;
	private String request_name;
	private String answer_name;
	private int limitStart;
	private int listCount;
	
	public String getRequest_name() {
		return request_name;
	}
	public String getAnswer_name() {
		return answer_name;
	}
	public void setRequest_name(String request_name) {
		this.request_name = request_name;
	}
	public void setAnswer_name(String answer_name) {
		this.answer_name = answer_name;
	}
	public int getId() {
		return id;
	}
	public String getSubject() {
		return subject;
	}
	public String getReq_type() {
		return req_type;
	}
	public String getContent() {
		return content;
	}
	public String getAnswer() {
		return answer;
	}
	public String getAnswer_status() {
		return answer_status;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getEdit_date() {
		return edit_date;
	}
	public int getRequest_id() {
		return request_id;
	}
	public int getAnswer_id() {
		return answer_id;
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
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setReq_type(String req_type) {
		this.req_type = req_type;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setAnswer_status(String answer_status) {
		this.answer_status = answer_status;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public void setEdit_date(String edit_date) {
		this.edit_date = edit_date;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	@Override
	public String toString() {
		return "Qna [id=" + id + ", subject=" + subject + ", req_type=" + req_type + ", content=" + content
				+ ", answer=" + answer + ", answer_status=" + answer_status + ", reg_date=" + reg_date + ", edit_date="
				+ edit_date + ", request_id=" + request_id + ", answer_id=" + answer_id + ", limitStart=" + limitStart
				+ ", listCount=" + listCount + ", request_name=" + request_name + ", answer_name=" + answer_name + "]";
	}
	
}
