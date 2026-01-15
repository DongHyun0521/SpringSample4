// SpringSample4 - com.mbc.pro.service - MemberServiceImpl.java
package com.mbc.pro.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbc.pro.dao.MemberDao;
import com.mbc.pro.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao dao;

	@Override
	public boolean idCheck(String id) {
		System.out.println("MemberServiceImpl: idCheck() | " + new Date());	
		return (dao.idCheck(id) > 0) ? false : true;
	}
	
	@Override
	public boolean addMember(MemberDto dto) {
		System.out.println("MemberServiceImpl: addMember() | " + new Date());	
		return (dao.addMember(dto) > 0) ? true : false;
	}

	@Override
	public MemberDto login(MemberDto dto) {
		System.out.println("MemberServiceImpl: login() | " + new Date());
		return dao.login(dto);
	}
}
