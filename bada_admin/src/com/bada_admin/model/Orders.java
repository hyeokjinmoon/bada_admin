package com.bada_admin.model;

import java.util.List;

public class Orders {
	private int id;
	private String order_date;
	private int buyer_id;
	private String buyer_name;
	private String buyer_tel;
	private String deposit_status;
	private String delivery_status;
	private String buyer_addr;
	private String payment_type;
	private int payment_price;
	private int limitStart;
	private int listCount;
	private List<Cart> cartList;
	private int month;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public List<Cart> getCartList() {
		return cartList;
	}
	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public String getBuyer_tel() {
		return buyer_tel;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public void setBuyer_tel(String buyer_tel) {
		this.buyer_tel = buyer_tel;
	}
	
	public int getId() {
		return id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public int getBuyer_id() {
		return buyer_id;
	}
	public String getDeposit_status() {
		return deposit_status;
	}
	public String getDelivery_status() {
		return delivery_status;
	}
	public String getBuyer_addr() {
		return buyer_addr;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public int getPayment_price() {
		return payment_price;
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
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}
	public void setDeposit_status(String deposit_status) {
		this.deposit_status = deposit_status;
	}
	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}
	public void setBuyer_addr(String buyer_addr) {
		this.buyer_addr = buyer_addr;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public void setPayment_price(int payment_price) {
		this.payment_price = payment_price;
	}
	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", order_date=" + order_date + ", buyer_id=" + buyer_id + ", buyer_name="
				+ buyer_name + ", buyer_tel=" + buyer_tel + ", deposit_status=" + deposit_status + ", delivery_status="
				+ delivery_status + ", buyer_addr=" + buyer_addr + ", payment_type=" + payment_type + ", payment_price="
				+ payment_price + ", limitStart=" + limitStart + ", listCount=" + listCount + ", cartList=" + cartList
				+ ", month=" + month + "]";
	}
	
}
