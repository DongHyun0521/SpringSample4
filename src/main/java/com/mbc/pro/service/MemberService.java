// SpringSample4 - com.mbc.pro.service - MemberService.java
package com.mbc.pro.service;

import com.mbc.pro.dto.MemberDto;

public interface MemberService {
	boolean idCheck(String id);	
	boolean addMember(MemberDto dto);
	MemberDto login(MemberDto dto);
}
