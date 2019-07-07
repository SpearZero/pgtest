package com.pgtest.dto;

public class CancelDTO {
	private String imp_uid;
	private String merchant_uid;
	private double amount;
	private double tax_free;
	private double checksum;
	private String reason;
	
	public CancelDTO() {}

	public CancelDTO(String imp_uid, String merchant_uid, double amount, double tax_free, double checksum,
			String reason) {
		this.imp_uid = imp_uid;
		this.merchant_uid = merchant_uid;
		this.amount = amount;
		this.tax_free = tax_free;
		this.checksum = checksum;
		this.reason = reason;
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
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getTax_free() {
		return tax_free;
	}
	
	public void setTax_free(double tax_free) {
		this.tax_free = tax_free;
	}
	
	public double getChecksum() {
		return checksum;
	}
	
	public void setChecksum(double checksum) {
		this.checksum = checksum;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Override
	public String toString() {
		return "CancelDTO [imp_uid=" + imp_uid + ", merchant_uid=" + merchant_uid + ", amount=" + amount + ", tax_free="
				+ tax_free + ", checksum=" + checksum + ", reason=" + reason + "]";
	}
}
