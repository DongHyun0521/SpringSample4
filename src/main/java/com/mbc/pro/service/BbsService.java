// SpringSample4 - com.mbc.pro.service - BbsService.java
package com.mbc.pro.service;

import java.util.List;

import com.mbc.pro.dto.BbsDto;
import com.mbc.pro.dto.BbsParam;

public interface BbsService {
	List<BbsDto> bbsList(BbsParam param);
	int getAllBbs(BbsParam param);
	
	boolean bbsWrite(BbsDto dto);
	BbsDto bbsDetail(int seq);
	boolean bbsUpdate(BbsDto dto);
	void bbsDelete(int seq);
	
	boolean answer(int seq, BbsDto dto);
}
