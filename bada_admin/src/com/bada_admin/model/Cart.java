package com.bada_admin.model;

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
	private String buyer_name;
	private int limitStart;
	private int listCount;
	private int payment_price;
	
	public int getLimitStart() {
		return limitStart;
	}
	public int getPayment_price() {
		return payment_price;
	}
	public void setPayment_price(int payment_price) {
		this.payment_price = payment_price;
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
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
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
				+ seller_name + ", product_status=" + product_status + ", order_id=" + order_id + ", buyer_name="
				+ buyer_name + ", limitStart=" + limitStart + ", listCount=" + listCount + ", payment_price="
				+ payment_price + "]";
	}
	
}
