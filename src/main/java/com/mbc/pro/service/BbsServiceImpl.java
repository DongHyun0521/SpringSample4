// SpringSample4 - com.mbc.pro.service - BbsServiceImpl.java
package com.mbc.pro.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.pro.dao.BbsDao;
import com.mbc.pro.dto.BbsDto;
import com.mbc.pro.dto.BbsParam;

@Service
public class BbsServiceImpl implements BbsService {
	@Autowired
	BbsDao dao;

	@Override
	public List<BbsDto> bbsList(BbsParam param) {
		System.out.println("BbsServiceImpl: bbsList() | " + new Date());
		return dao.bbsList(param);
	}

	@Override
	public int getAllBbs(BbsParam param) {
		System.out.println("BbsServiceImpl: getAllBbs() | " + new Date());
		return dao.getAllBbs(param);
	}
	
	// ==========================================================================================

	@Override
	public boolean bbsWrite(BbsDto dto) {
		System.out.println("BbsServiceImpl: bbsWrite() | " + new Date());
		return dao.bbsWrite(dto) > 0;
	}
	
	// ==========================================================================================
	
	@Override
	public BbsDto bbsDetail(int seq) {
		dao.readCount(seq);
		return dao.bbsDetail(seq);
	}
	
	// ==========================================================================================
	
	@Override
	public boolean bbsUpdate(BbsDto dto) {
	    // 0보다 크면 수정 성공
	    return dao.bbsUpdate(dto) > 0;
	}
	
	// ==========================================================================================

	@Override
	public void bbsDelete(int seq) {
		dao.bbsDelete(seq);
	}
	
	// ==========================================================================================
	
	@Override
	public boolean answer(int seq, BbsDto dto) {
		BbsDto parent = dao.bbsDetail(seq);
		
		dao.answerUpdate(parent);	// step 1씩 밀어내기
		
		dto.setRef(parent.getRef());
		dto.setStep(parent.getStep() + 1);
		dto.setDepth(parent.getDepth() + 1);
		dto.setParent(seq);
		
		return dao.answerWrite(dto) > 0;
	}
}
