package com.bada_admin.model;

public class NoticeFaq {
	private int id;
	private String category;
	private String subject;
	private String content;
	private String reg_date;
	private String edit_date;
	private int admin_id;
	private int limitStart;
	private int listCount;
	
	public int getId() {
		return id;
	}
	public String getCategory() {
		return category;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getEdit_date() {
		return edit_date;
	}
	public int getAdmin_id() {
		return admin_id;
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
	public void setCategory(String category) {
		this.category = category;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public void setEdit_date(String edit_date) {
		this.edit_date = edit_date;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	@Override
	public String toString() {
		return "NoticeFaq [id=" + id + ", category=" + category + ", subject=" + subject + ", content=" + content
				+ ", reg_date=" + reg_date + ", edit_date=" + edit_date + ", admin_id=" + admin_id + ", limitStart="
				+ limitStart + ", listCount=" + listCount + "]";
	}
	
}	
