package com.pgtest.mapper;

import com.pgtest.dto.OrdererDTO;

public interface OrdererMapper {
	
	public int isOrdererExist(String email);
	
	public int insertOrderer(OrdererDTO dto);
	
	public int getOrdererNum(String email);
}
