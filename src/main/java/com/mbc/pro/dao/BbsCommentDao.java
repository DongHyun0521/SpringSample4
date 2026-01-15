// SpringSample4 - com.mbc.pro.dao - BbsCommentDao.java
package com.mbc.pro.dao;

import java.util.List;

import com.mbc.pro.dto.BbsComment;

public interface BbsCommentDao {
	int insertComment(BbsComment comm);
	List<BbsComment> getAllBbsComment(int bbsSeq);
}
