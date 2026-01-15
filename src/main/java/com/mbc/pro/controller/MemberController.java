// SpringSample4 - com.mbc.pro.controller - MemberController.java
package com.mbc.pro.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mbc.pro.dto.MemberDto;
import com.mbc.pro.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	// 요즘 새로운 방법
	/*public MemberController(MemberService service) {
		this.service = service;
	}*/
	
	@GetMapping("login.do")
	public String login() {
		System.out.println("MemberController: login() " + new Date());
		
		return "login";
	}
	
	@GetMapping("regi.do")
	public String regi() {
		System.out.println("MemberController: regi() " + new Date());
		
		return "regi";
	}
	
	@ResponseBody
	@PostMapping("idCheck.do")
	public String idCheck(String id) {
		System.out.println("MemberController: idCheck() " + new Date());
		
		System.out.println("id:" + id);
		
		boolean isS = service.idCheck(id);
		String msg = "YES";
		if(!isS) {
			msg = "NO";
		}
		
		return msg;
	}
	
	@PostMapping("regiAf.do")
	public String regiAf(MemberDto dto, Model model) {
		System.out.println("MemberController: regiAf() " + new Date());
		
		boolean isS = service.addMember(dto);
		String message = "MEMBER_YES";
		if(!isS) {
			message = "MEMBER_NO";
		}
		
		model.addAttribute("message", message);
		return "message";
	}
	
	@PostMapping("loginAf.do")
	public String loginAf(MemberDto dto, Model model, HttpServletRequest request) {
		System.out.println("MemberController: loginAf() " + new Date());
		
		MemberDto mem = service.login(dto);
		String loginMsg = "LOGIN_NO";
		if(mem != null) {
			request.getSession().setAttribute("login", mem);
			loginMsg = "LOGIN_YES";
		}
		
		model.addAttribute("loginMsg", loginMsg);
		return "message";
	}
}
