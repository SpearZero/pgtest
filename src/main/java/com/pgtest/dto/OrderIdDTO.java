package com.pgtest.dto;

public class OrderIdDTO {
	
	private String imp_uid;
	private String merchant_uid;
	
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
	
	@Override
	public String toString() {
		return "OrderIdDTO [imp_uid=" + imp_uid + ", merchant_uid=" + merchant_uid + "]";
	}
}
