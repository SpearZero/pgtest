package com.pgtest.service;

import java.util.List;

import com.pgtest.dto.MerchandiseDTO;
import com.pgtest.dto.PaidResultDTO;

public interface MerchandiseService {
	
	public String getGeneratedMerchandiseUid();
	
	public int generateMerchandiseNum();

	public int insertMerchandisePrice(String merchandiseId, Long merchandisePrice);
	
	public Long getMerchandisePrice(String merchandiseId);
	
	public int insertMerchandiseInfo(MerchandiseDTO dto);
	
	public List<PaidResultDTO> getPaidResults(String email);
	
	public MerchandiseDTO getMerchandiseUsingImpUid(String imp_uid);
	
	public int insertRefundInfo(String imp_uid, String reason);
}
