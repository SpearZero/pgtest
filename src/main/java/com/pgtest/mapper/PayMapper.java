package com.pgtest.mapper;

import org.apache.ibatis.annotations.Param;

public interface PayMapper {
	
	public int getPayNumber(@Param("pgProvider")String pgProvider, @Param("payMethod")String payMethod);
}
