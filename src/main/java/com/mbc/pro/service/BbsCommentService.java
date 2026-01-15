// SpringSample4 - com.mbc.pro.service - BbsCommentService.java
package com.mbc.pro.service;

import java.util.List;

import com.mbc.pro.dto.BbsComment;

public interface BbsCommentService {
	boolean insertComment(BbsComment comm);
	List<BbsComment> getAllBbsComment(int bbsSeq);
}
