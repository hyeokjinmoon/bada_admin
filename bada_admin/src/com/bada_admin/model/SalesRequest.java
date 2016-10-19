package com.bada_admin.model;

public class SalesRequest {
	private int id;
	private String sales_type;
	private String book_list;
	private String reg_date;
	private String edit_date;
	private String pickup_date;
	private int member_id;
	private String sales_ok;
	private int limitStart;
	private int listCount;
	
	public int getLimitStart() {
		return limitStart;
	}
	public int getListCount() {
		return listCount;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getId() {
		return id;
	}
	public String getSales_type() {
		return sales_type;
	}
	public String getBook_list() {
		return book_list;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getEdit_date() {
		return edit_date;
	}
	public String getPickup_date() {
		return pickup_date;
	}
	public int getMember_id() {
		return member_id;
	}
	public String getSales_ok() {
		return sales_ok;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSales_type(String sales_type) {
		this.sales_type = sales_type;
	}
	public void setBook_list(String book_list) {
		this.book_list = book_list;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public void setEdit_date(String edit_date) {
		this.edit_date = edit_date;
	}
	public void setPickup_date(String pickup_date) {
		this.pickup_date = pickup_date;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public void setSales_ok(String sales_ok) {
		this.sales_ok = sales_ok;
	}
	@Override
	public String toString() {
		return "SalesRequest [id=" + id + ", sales_type=" + sales_type + ", book_list=" + book_list + ", reg_date="
				+ reg_date + ", edit_date=" + edit_date + ", pickup_date=" + pickup_date + ", member_id=" + member_id
				+ ", sales_ok=" + sales_ok + ", limitStart=" + limitStart + ", listCount=" + listCount + "]";
	}
	
}
