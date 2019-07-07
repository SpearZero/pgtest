package com.pgtest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pgtest.dto.MerchandiseDTO;
import com.pgtest.dto.PaidResultDTO;

public interface MerchandiseMapper {
	
	public int insertMerchandiseNumAndId(@Param("merchandiseNum")int merchandiseNum,
			@Param("merchandiseId")String merchandiseId);
	
	public int generateMerchandiseNum();
	
	public String getMerchandiseUid(int key);
	
	public int insertMerchandisePrice(@Param("merchandiseId")String merchandiseId,
			@Param("merchandisePrice")Long merchandisePrice);
	
	public Long getMerchandisePrice(String merchandiseId);
	
	public int insertMerchandiseInfo(MerchandiseDTO dto);
	
	public List<PaidResultDTO> getPaidResults(String email);
	
	public MerchandiseDTO getMerchandiseUsingImpUid(String imp_uid);
	
	public int getMerchandiseNumUsingImpUid(String imp_uid);
	
	public int insertRefundInfo(@Param("merchandise_num")int merchandiseNum, @Param("reason")String reason);
	
	public int updateMerchandiseStatus(int merchandiseNum);
}
