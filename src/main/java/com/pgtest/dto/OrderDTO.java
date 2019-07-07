package com.pgtest.dto;

public class OrderDTO {
	
	private String buyer_name;
	private String buyer_tel;
	private String buyer_email;
	private String buyer_address;
	private String buyer_postal;
	private String merchandise_name;
	private String merchandise_uid;
	private Long merchandise_price;
	private String pay_method;
	
	public String getBuyer_name() {
		return buyer_name;
	}
	
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	
	public String getBuyer_tel() {
		return buyer_tel;
	}
	
	public void setBuyer_tel(String buyer_tel) {
		this.buyer_tel = buyer_tel;
	}
	
	public String getBuyer_email() {
		return buyer_email;
	}
	
	public void setBuyer_email(String buyer_email) {
		this.buyer_email = buyer_email;
	}
	
	public String getBuyer_address() {
		return buyer_address;
	}
	
	public void setBuyer_address(String buyer_address) {
		this.buyer_address = buyer_address;
	}
	
	public String getBuyer_postal() {
		return buyer_postal;
	}
	
	public void setBuyer_postal(String buyer_postal) {
		this.buyer_postal = buyer_postal;
	}

	public String getMerchandise_name() {
		return merchandise_name;
	}

	public void setMerchandise_name(String merchandise_name) {
		this.merchandise_name = merchandise_name;
	}

	public Long getMerchandise_price() {
		return merchandise_price;
	}

	public void setMerchandise_price(Long merchandise_price) {
		this.merchandise_price = merchandise_price;
	}

	public String getPay_method() {
		return pay_method;
	}

	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	public String getMerchandise_uid() {
		return merchandise_uid;
	}

	public void setMerchandise_uid(String merchandise_uid) {
		this.merchandise_uid = merchandise_uid;
	}

	@Override
	public String toString() {
		return this.buyer_name + " : " + this.buyer_tel + " : " + this.buyer_email + " : " + 
			   this.buyer_address + " : " + this.buyer_postal + " : " + this.merchandise_name + " : " +
			   this.merchandise_price + " : " + this.pay_method + " : " + this.merchandise_uid;
	}
}
