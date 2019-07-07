package com.pgtest.dto;

public class MerchandiseDTO {
	private int merchandise_num;
	private String imp_uid;
	private String merchant_uid;
	private String name;
	private Long amount;
	private String status;
	private int pay;
	private int orderer;
	
	public MerchandiseDTO() {}

	public MerchandiseDTO(int merchandise_num, String imp_uid, String merchant_uid, String name, Long amount,
			String status, int pay, int orderer) {
		this.merchandise_num = merchandise_num;
		this.imp_uid = imp_uid;
		this.merchant_uid = merchant_uid;
		this.name = name;
		this.amount = amount;
		this.status = status;
		this.pay = pay;
		this.orderer = orderer;
	}

	public int getMerchandise_num() {
		return merchandise_num;
	}
	
	public void setMerchandise_num(int merchandise_num) {
		this.merchandise_num = merchandise_num;
	}
	
	public String getImp_uid() {
		return imp_uid;
	}
	
	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}
	
	public String getMerchant_uid() {
		return merchant_uid;
	}
	
	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}
	
	public Long getAmount() {
		return amount;
	}
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getPay() {
		return pay;
	}
	
	public void setPay(int pay) {
		this.pay = pay;
	}
	
	public int getOrderer() {
		return orderer;
	}
	
	public void setOrderer(int orderer) {
		this.orderer = orderer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MerchandiseDTO [merchandise_num=" + merchandise_num + ", imp_uid=" + imp_uid + ", merchant_uid="
				+ merchant_uid + ", name=" + name + ", amount=" + amount + ", status=" + status + ", pay=" + pay
				+ ", orderer=" + orderer + "]";
	}
}
