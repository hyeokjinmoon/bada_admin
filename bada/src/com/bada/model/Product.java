package com.bada.model;

public class Product {
	private int id;
	private String product_name;
	private int list_price;
	private int sale_price;
	private String product_img;
	private String reg_date;
	private String edit_date;
	private String seller;
	private String ok_status;
	private String product_status;
	private int seller_id;
	private int limitStart;
	private int listCount;
	private String seller_name;
	private String category;
	private String seller_user_id;
	private String keyword;
	private String value;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSeller_user_id() {
		return seller_user_id;
	}
	public void setSeller_user_id(String seller_user_id) {
		this.seller_user_id = seller_user_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
	}
	public int getId() {
		return id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public String getProduct_img() {
		return product_img;
	}
	public String getProduct_status() {
		return product_status;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}
	public int getList_price() {
		return list_price;
	}
	public int getSale_price() {
		return sale_price;
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
	public void setList_price(int list_price) {
		this.list_price = list_price;
	}
	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
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
		return "Product [id=" + id + ", product_name=" + product_name + ", list_price=" + list_price + ", sale_price="
				+ sale_price + ", product_img=" + product_img + ", reg_date=" + reg_date + ", edit_date=" + edit_date
				+ ", seller=" + seller + ", ok_status=" + ok_status + ", product_status=" + product_status
				+ ", seller_id=" + seller_id + ", limitStart=" + limitStart + ", listCount=" + listCount
				+ ", seller_name=" + seller_name + ", category=" + category + ", seller_user_id=" + seller_user_id
				+ ", keyword=" + keyword + ", value=" + value + "]";
	}
	
}
