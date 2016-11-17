package com.bada.model;

public class Cart {
	private int id;
	private String product_name;
	private int list_price;
	private int sale_price;
	private String product_img;
	private String reg_date;
	private String edit_date;
	private String seller;
	private String ok_status;
	private int seller_id;
	private String seller_name;
	private String product_status;
	private int order_id;
	private int add_id;
	private int limitStart;
	private int listCount;
	private String category;
	private int product_id;
	private String seller_user_id; 
	
	public String getSeller_user_id() {
		return seller_user_id;
	}
	public void setSeller_user_id(String seller_user_id) {
		this.seller_user_id = seller_user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getAdd_id() {
		return add_id;
	}
	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
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
	public String getSeller_name() {
		return seller_name;
	}
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
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

	public int getId() {
		return id;
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
	public int getOrder_id() {
		return order_id;
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
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", product_name=" + product_name + ", list_price=" + list_price + ", sale_price="
				+ sale_price + ", product_img=" + product_img + ", reg_date=" + reg_date + ", edit_date=" + edit_date
				+ ", seller=" + seller + ", ok_status=" + ok_status + ", seller_id=" + seller_id + ", seller_name="
				+ seller_name + ", product_status=" + product_status + ", order_id=" + order_id + ", add_id=" + add_id
				+ ", limitStart=" + limitStart + ", listCount=" + listCount + ", category=" + category + ", product_id="
				+ product_id + ", seller_user_id=" + seller_user_id + "]";
	}
	
}
