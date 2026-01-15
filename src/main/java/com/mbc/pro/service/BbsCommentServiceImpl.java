// SpringSample4 - com.mbc.pro.service - BbsCommentServiceImpl.java
package com.mbc.pro.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.pro.dao.BbsCommentDao;
import com.mbc.pro.dto.BbsComment;

@Service
public class BbsCommentServiceImpl implements BbsCommentService {
	@Autowired
	BbsCommentDao daoComm;
	
	@Override
	public boolean insertComment(BbsComment comm) {
		System.out.println("BbsCommentServiceImpl: insertComment() | " + new Date());
		return daoComm.insertComment(comm) > 0;
	}
	
	@Override
	public List<BbsComment> getAllBbsComment(int bbsSeq) {
		System.out.println("BbsCommentServiceImpl: getAllBbsComment() | " + new Date());
		return daoComm.getAllBbsComment(bbsSeq);
	}
}
