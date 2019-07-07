package com.pgtest.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderValidator {
	
	public boolean validator(OrderDTO dto) {
		boolean[] validate = new boolean[] {true, true, true, true, true};
		boolean result = true;
		
		validate[0] = isTelValid(dto);
		validate[1] = isEmailValid(dto);
		validate[2] = isPostalValid(dto);
		validate[3] = isPriceValid(dto);
		validate[4] = isBuyerNameAddrMerhchantNameEmpty(dto);
		
		for(boolean validResult : validate) {
			if(!validResult) {
				result = validResult;
			}
		}
		
		return result;
	}
	
	private boolean isBuyerNameAddrMerhchantNameEmpty(OrderDTO dto) {
		boolean[] validate = new boolean[] {true, true, true};
		boolean result = true;
		
		validate[0] = isEmptyOrNull(dto.getBuyer_name());
		validate[1] = isEmptyOrNull(dto.getBuyer_address());
		validate[2] = isEmptyOrNull(dto.getMerchandise_name());
		
		for(boolean validResult : validate) {
			if(!validResult) {
				result = validResult;
			}
		}
		
		return result;
	}
	
	private boolean isEmptyOrNull(String input) {
		boolean result = true;
		
		if(input.trim().equals("") || input == null) {
			result = false;
		}
		
		return result;
	}
	
	private boolean isTelValid(OrderDTO dto) {
		Pattern p = Pattern.compile("01[016789]-[1-9]{1}[0-9]{2,3}-[0-9]{4}");
		Matcher m = p.matcher(dto.getBuyer_tel());
		boolean result = m.find();
		
		if(!result) {
			dto.setBuyer_tel("");
		}
		
		// 찾는 결과가 없으면 false
		return result;
	}
	
	private boolean isEmailValid(OrderDTO dto) {
		Pattern p = Pattern.compile("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$");
		Matcher m = p.matcher(dto.getBuyer_email());
		boolean result = m.find();
		
		if(!result) {
			dto.setBuyer_email("");
		}
		
		return result;
	}
	
	private boolean isPostalValid(OrderDTO dto) {
		Pattern p = Pattern.compile("\\d{5}");
		Matcher m = p.matcher(dto.getBuyer_postal());
		boolean result = m.find();
		
		if(!result) {
			dto.setBuyer_postal("");
		}
		
		return result;
	}
	
	private boolean isPriceValid(OrderDTO dto) {
		boolean result = dto.getMerchandise_price() > 0 ? true : false;
		
		if(!result) {
			dto.setMerchandise_price(0L);
		}
		
		return result;
	}
}
