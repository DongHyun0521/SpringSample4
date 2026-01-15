// SpringSample4 - com.mbc.pro.controller - BbsControllerImpl.java
package com.mbc.pro.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mbc.pro.dto.BbsComment;
import com.mbc.pro.dto.BbsDto;
import com.mbc.pro.dto.BbsParam;
import com.mbc.pro.service.BbsCommentService;
import com.mbc.pro.service.BbsService;

@Controller
public class BbsController {
	@Autowired
	BbsService service;
	
	@Autowired
	BbsCommentService commentService;
	
	@GetMapping("bbsList.do")
	public String bbsList(Model model, BbsParam param) {
		System.out.println("BbsController: bbsList() | " + new Date());
		
		// 글 목록
		List<BbsDto> list = service.bbsList(param);
		
		// 전체 글의 수
		int count = service.getAllBbs(param);
		
		// 페이지 수
		int pageBbs = count / 10;
		if ((count % 10) > 0) {
			pageBbs = pageBbs + 1;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("pageBbs", pageBbs);
		model.addAttribute("param", param);
		
		return "bbs/bbsList";
	}	
	
	// ==========================================================================================
	
	@GetMapping("bbsWrite.do")
	public String bbsWrite() {
		System.out.println("BbsController: bbsWrite() | " + new Date());
		return "bbs/bbsWrite";
	}
	
	@PostMapping("bbsWriteAf.do")
	public String bbsWriteAf(BbsDto dto, Model model) {
		System.out.println("BbsController: bbsWriteAf() | " + new Date());
		
		boolean isS = service.bbsWrite(dto);
		String bbsWriteMsg = "BBSWRITE_YES";
		if (isS == false) {
			bbsWriteMsg = "BBSWRITE_NO";
		}
		model.addAttribute("bbsWriteMsg", bbsWriteMsg);
		
		return "message";
	}
	
	// ==========================================================================================
	
	@GetMapping("bbsDetail.do")
	public String bbsDetail(int seq, Model model) {
		System.out.println("BbsController: bbsDetail() | " + new Date());
		
		BbsDto dto = service.bbsDetail(seq);
		model.addAttribute("dto", dto);
		
		List<BbsComment> commentList = commentService.getAllBbsComment(seq);
		model.addAttribute("commentList", commentList);
		
		return "bbs/bbsDetail";
	}
	
	// ==========================================================================================
	
	@GetMapping("bbsUpdate.do")
	public String bbsUpdate(int seq, Model model) {
		System.out.println("BbsController: bbsUpdate() | " + new Date());
		
		BbsDto dto = service.bbsDetail(seq);
		model.addAttribute("dto", dto);
		return "bbs/bbsUpdate";
	}
	
	@PostMapping("bbsUpdateAf.do")
	public String bbsUpdateAf(BbsDto dto, Model model) {
		System.out.println("BbsController: bbsUpdateAf() | " + new Date());
	    
	    boolean isS = service.bbsUpdate(dto);
	    String bbsUpdateMsg = "UPDATE_YES";
	    
	    if(isS == false) {
	        bbsUpdateMsg = "UPDATE_NO";
	    }
	    
	    model.addAttribute("bbsUpdateMsg", bbsUpdateMsg);
	    model.addAttribute("seq", dto.getSeq());
	    return "message";
	}
	
	// ==========================================================================================
	
	@GetMapping("bbsDelete.do")
	public String bbsDelete(int seq, Model model) {
		System.out.println("BbsController: bbsDelete() | " + new Date());
		
		service.bbsDelete(seq); 
		model.addAttribute("bbsDeleteMsg", "DELETE_YES");
		return "message";
	}
	
	/*@PostMapping("bbsDeleteAf.do")
	public String bbsDeleteAf(int seq, BbsDto dto, Model model) {
		System.out.println("BbsController: bbsDeleteAf() | " + new Date());
		
		boolean isS = service.bbsDelete(seq);
		String message = "DELETE_YES";
		
		if(isS == false) {
			message = "DELETE_NO";
		}
		model.addAttribute("deleteMsg", message);
		model.addAttribute("seq", seq);
		
		return "message";
	}*/
	
	// ==========================================================================================
	
	@GetMapping("answer.do")
	public String answer(int seq, Model model) {
		System.out.println("BbsController: answer() | " + new Date());
		
		BbsDto dto = service.bbsDetail(seq);
		model.addAttribute("dto", dto);
		
		return "bbs/answer";
	}
	
	@PostMapping("answerAf.do")
	public String answerAf(int seq, BbsDto dto, Model model) {
		System.out.println("BbsController: answerAf() | " + new Date());
		
		boolean isS = service.answer(seq, dto);
		String message = "ANSWER_YES";
		
		if(isS == false) {
			message = "ANSWER_NO";
		}
		model.addAttribute("answerMsg", message);
		model.addAttribute("seq", seq);
		
		return "message";
	}
	
	// ==========================================================================================
	
	@PostMapping("commentWriteAf.do")
    public String commentWriteAf(BbsComment comm) {
        System.out.println("BbsController: commentWriteAf() | " + new Date());
        
        boolean isS = commentService.insertComment(comm);
        
        return "redirect:/bbsDetail.do?seq=" + comm.getBbsSeq();
    }
}
