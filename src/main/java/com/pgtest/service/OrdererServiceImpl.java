package com.pgtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgtest.dto.OrdererDTO;
import com.pgtest.mapper.OrdererMapper;

@Service
public class OrdererServiceImpl implements OrdererService{

	@Autowired
	private OrdererMapper mapper;
	
	@Override
	public boolean isOrdererExist(String email) {
		int count = mapper.isOrdererExist(email);
		boolean result = count == 1 ? true : false; 
				
		return result;
	}

	@Override
	public int insertOrderer(OrdererDTO dto) {
		int result = mapper.insertOrderer(dto);
		return result;
	}

	@Override
	public int getOrdererNum(String email) {
		return mapper.getOrdererNum(email);
	}
}
