// SpringSample4 - com.mbc.pro.dao - BbsDao.java
package com.mbc.pro.dao;

import java.util.List;

import com.mbc.pro.dto.BbsDto;
import com.mbc.pro.dto.BbsParam;

public interface BbsDao {
	List<BbsDto> bbsList(BbsParam param);	
	int getAllBbs(BbsParam param);
	
	int bbsWrite(BbsDto dto);
	
	BbsDto bbsDetail(int seq);
	void readCount(int seq);
	
	int bbsUpdate(BbsDto dto);
	void bbsDelete(int seq);
	
	void answerUpdate(BbsDto parent);
	int answerWrite(BbsDto child);
}
