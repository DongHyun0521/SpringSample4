// SpringSample4 - com.mbc.pro.dao - BbsCommentDaoImpl.java
package com.mbc.pro.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mbc.pro.dto.BbsComment;

@Repository
public class BbsCommentDaoImpl implements BbsCommentDao {
	@Autowired
	SqlSession session;
	
	String ns = "BbsComment.";
	
	@Override
	public int insertComment(BbsComment comm) {
		System.out.println("BbsCommentDaoImpl: insertComment() | " + new Date());
		return session.insert(ns + "insertComment", comm);
	}
	
	@Override
	public List<BbsComment> getAllBbsComment(int bbsSeq) {
		System.out.println("BbsCommentDaoImpl: getAllBbsComment() | " + new Date());
		return session.selectList(ns + "getAllBbsComment", bbsSeq);
	}
}
