package com.pgtest.service;

import com.pgtest.dto.OrdererDTO;

public interface OrdererService {
	
	public boolean isOrdererExist(String email);
	
	public int insertOrderer(OrdererDTO dto);
	
	public int getOrdererNum(String email);
}
