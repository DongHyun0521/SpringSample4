// SpringSample4 - com.mbc.pro.dao - BbsDaoImpl.java
package com.mbc.pro.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mbc.pro.dto.BbsDto;
import com.mbc.pro.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {
	@Autowired
	SqlSession session;
	
	String ns = "Bbs.";

	@Override
	public List<BbsDto> bbsList(BbsParam param) {
		System.out.println("BbsDaoImpl: bbsList() | " + new Date());
		return session.selectList(ns + "bbsList", param);
	}

	@Override
	public int getAllBbs(BbsParam param) {
		System.out.println("BbsDaoImpl: getAllBbs() | " + new Date());
		return session.selectOne(ns + "getAllBbs", param);
	}
	
	// ==========================================================================================

	@Override
	public int bbsWrite(BbsDto dto) {
		System.out.println("BbsDaoImpl: bbsWrite() | " + new Date());
		return session.insert(ns + "bbsWrite", dto);
	}
	
	// ==========================================================================================
	
	@Override
	public BbsDto bbsDetail(int seq) {
		System.out.println("BbsDaoImpl: bbsDetail() | " + new Date());
		return session.selectOne(ns + "bbsDetail", seq);
	}
	
	@Override
	public void readCount(int seq) {
		session.update(ns + "readcount", seq);
	}
	
	// ==========================================================================================

	@Override
	public int bbsUpdate(BbsDto dto) {
		return session.update(ns + "bbsUpdate", dto);
	}
	
	// ==========================================================================================

	@Override
	public void bbsDelete(int seq) {
		session.update(ns + "bbsDelete", seq);
	}
	
	// ==========================================================================================

	@Override
	public void answerUpdate(BbsDto parent) {
		session.update(ns + "answerUpdate", parent);
	}

	@Override
	public int answerWrite(BbsDto child) {
		return session.insert(ns + "answerWrite", child);
	}
}