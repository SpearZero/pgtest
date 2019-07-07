package com.pgtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgtest.mapper.PayMapper;

@Service
public class PayServiceImpl implements PayService{
	
	@Autowired
	private PayMapper mapper;

	@Override
	public int getPayNumber(String pgProvider, String payMethod) {
		return mapper.getPayNumber(pgProvider, payMethod);
	}
}
