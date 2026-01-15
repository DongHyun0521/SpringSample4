// SpringSample4 - com.mbc.pro.dao - MemberDaoImpl.java
package com.mbc.pro.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mbc.pro.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SqlSession session;
	
	String ns = "Member.";

	@Override
	public int idCheck(String id) {
		System.out.println("MemberDaoImpl: idCheck() | " + new Date());		
		return session.selectOne(ns + "idCheck", id);
	}
	@Override
	public int addMember(MemberDto dto) {
		System.out.println("MemberDaoImpl: addMember() | " + new Date());	
		return session.insert(ns + "addMember", dto);
	}
	@Override
	public MemberDto login(MemberDto dto) {
		System.out.println("MemberDaoImpl: login() | " + new Date());	
		return session.selectOne(ns + "login", dto);
	}
}
