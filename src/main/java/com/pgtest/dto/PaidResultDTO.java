package com.pgtest.dto;

public class PaidResultDTO {
	private int merchandise_num;
	private String imp_uid;
	private String merchant_uid;
	private String name;
	private int amount;
	private String status;
	
	public PaidResultDTO() {}

	public PaidResultDTO(int merchandise_num, String imp_uid, String merchant_uid, String name, int amount,
			String status) {
		this.merchandise_num = merchandise_num;
		this.imp_uid = imp_uid;
		this.merchant_uid = merchant_uid;
		this.name = name;
		this.amount = amount;
		this.status = status;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PaidResultDTO [merchandise_num=" + merchandise_num + ", imp_uid=" + imp_uid + ", merchant_uid="
				+ merchant_uid + ", name=" + name + ", amount=" + amount + ", status=" + status + "]";
	}
}
