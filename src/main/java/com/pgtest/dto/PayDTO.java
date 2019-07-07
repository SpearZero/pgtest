package com.pgtest.dto;

public class PayDTO {
	private String pg_provider;
	private String pay_method;
	
	public String getPg_provider() {
		return pg_provider;
	}
	
	public void setPg_provider(String pg_provider) {
		this.pg_provider = pg_provider;
	}
	
	public String getPay_method() {
		return pay_method;
	}
	
	public void setPay_method(String pay_method) {
		this.pay_method = pay_method;
	}

	@Override
	public String toString() {
		return "PayDTO [pg_provider=" + pg_provider + ", pay_method=" + pay_method + "]";
	}
}
