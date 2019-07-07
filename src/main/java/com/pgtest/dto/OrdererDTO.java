package com.pgtest.dto;

public class OrdererDTO {
	private int orderer_num;
	private String buyer_name;
	private String buyer_tel;
	private String buyer_email;
	private String buyer_addr;
	private String buyer_postcode;
	
	public OrdererDTO() {}

	public OrdererDTO(String buyer_name, String buyer_tel, String buyer_email, String buyer_addr,
			String buyer_postcode) {
		this.buyer_name = buyer_name;
		this.buyer_tel = buyer_tel;
		this.buyer_email = buyer_email;
		this.buyer_addr = buyer_addr;
		this.buyer_postcode = buyer_postcode;
	}
	
	public OrdererDTO(int orderer_num, String buyer_name, String buyer_tel, String buyer_email, String buyer_addr,
			String buyer_postcode) {
		this.orderer_num = orderer_num;
		this.buyer_name = buyer_name;
		this.buyer_tel = buyer_tel;
		this.buyer_email = buyer_email;
		this.buyer_addr = buyer_addr;
		this.buyer_postcode = buyer_postcode;
	}

	public int getOrderer_num() {
		return orderer_num;
	}
	
	public void setOrderer_num(int orderer_num) {
		this.orderer_num = orderer_num;
	}
	
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
	
	public String getBuyer_addr() {
		return buyer_addr;
	}
	
	public void setBuyer_addr(String buyer_addr) {
		this.buyer_addr = buyer_addr;
	}
	
	public String getBuyer_postcode() {
		return buyer_postcode;
	}
	
	public void setBuyer_postcode(String buyer_postcode) {
		this.buyer_postcode = buyer_postcode;
	}

	@Override
	public String toString() {
		return "OrdererDTO [orderer_num=" + orderer_num + ", buyer_name=" + buyer_name + ", buyer_tel=" + buyer_tel
				+ ", buyer_email=" + buyer_email + ", buyer_addr=" + buyer_addr + ", buyer_postcode=" + buyer_postcode
				+ "]";
	}
}
