package com.bada_admin.model;

public class Book {
	private int id;
	private String name;
	private int list_price;
	private int sale_price;
	private String book_img;
	private String reg_date;
	private String edit_date;
	private String seller;
	private String ok_status;
	private int seller_id;
	private int limitStart;
	private int listCount;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getList_price() {
		return list_price;
	}
	public int getSale_price() {
		return sale_price;
	}
	public String getBook_img() {
		return book_img;
	}
	public String getReg_date() {
		return reg_date;
	}
	public String getEdit_date() {
		return edit_date;
	}
	public String getSeller() {
		return seller;
	}
	public String getOk_status() {
		return ok_status;
	}
	public int getSeller_id() {
		return seller_id;
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
	public void setName(String name) {
		this.name = name;
	}
	public void setList_price(int list_price) {
		this.list_price = list_price;
	}
	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public void setEdit_date(String edit_date) {
		this.edit_date = edit_date;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public void setOk_status(String ok_status) {
		this.ok_status = ok_status;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", list_price=" + list_price + ", sale_price=" + sale_price
				+ ", book_img=" + book_img + ", reg_date=" + reg_date + ", edit_date=" + edit_date + ", seller="
				+ seller + ", ok_status=" + ok_status + ", seller_id=" + seller_id + ", limitStart=" + limitStart
				+ ", listCount=" + listCount + "]";
	}
	
}
