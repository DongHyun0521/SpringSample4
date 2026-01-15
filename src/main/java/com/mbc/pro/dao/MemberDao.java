// SpringSample4 - com.mbc.pro.dao - MemberDao.java
package com.mbc.pro.dao;

import com.mbc.pro.dto.MemberDto;

public interface MemberDao {
	int idCheck(String id);
	int addMember(MemberDto dto);
	MemberDto login(MemberDto dto);
}
