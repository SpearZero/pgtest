package com.pgtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pgtest.dto.MerchandiseDTO;
import com.pgtest.dto.PaidResultDTO;
import com.pgtest.mapper.MerchandiseMapper;

@Service
public class MerchandiseServiceImpl implements MerchandiseService{
	
	@Autowired
	private MerchandiseMapper mapper;

	@Transactional
	@Override
	public String getGeneratedMerchandiseUid() {
		int mercahndiseNum = generateMerchandiseNum();
		String merchandiseId = mercahndiseNum + "_" + System.currentTimeMillis();
		
		mapper.insertMerchandiseNumAndId(mercahndiseNum, merchandiseId);
		return mapper.getMerchandiseUid(mercahndiseNum);
	}

	@Override
	public int generateMerchandiseNum() {
		return mapper.generateMerchandiseNum();
	}

	@Override
	public int insertMerchandisePrice(String merchandiseId, Long merchandisePrice) {
		return mapper.insertMerchandisePrice(merchandiseId, merchandisePrice);
	}

	@Override
	public Long getMerchandisePrice(String merchandiseId) {
		return mapper.getMerchandisePrice(merchandiseId);
	}

	@Override
	public int insertMerchandiseInfo(MerchandiseDTO dto) {
		return mapper.insertMerchandiseInfo(dto);
	}

	@Override
	public List<PaidResultDTO> getPaidResults(String email) {
		return mapper.getPaidResults(email);
	}

	@Override
	public MerchandiseDTO getMerchandiseUsingImpUid(String imp_uid) {
		return mapper.getMerchandiseUsingImpUid(imp_uid);
	}

	@Transactional
	@Override
	public int insertRefundInfo(String imp_uid, String reason) {
		int merchandiseNum = mapper.getMerchandiseNumUsingImpUid(imp_uid);
		int insertResult = mapper.insertRefundInfo(merchandiseNum, reason);
		int updateResult = mapper.updateMerchandiseStatus(merchandiseNum);
		
		return updateResult;
	}
}
