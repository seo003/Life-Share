package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.BbsDTO;
import com.example.demo.service.BbsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BbsController {
	// 생성자 주입
	private final BbsService bbsService;

	@Autowired
	public BbsController(BbsService bbsService) {
		this.bbsService = bbsService;
	}
	

	@GetMapping("/")
    public String home(HttpSession session, Model model) {
		ArrayList<BbsDTO> bbsDTO = new ArrayList<>();
		bbsDTO = bbsService.getBbsAll();
		session.setAttribute("bbsList", bbsDTO);
		
        return "home"; //뷰 반환(home)
    }
	
	
	@GetMapping("/myBbs")
	public String myBbs(HttpSession session, Model model) {
		String loginId = (String) session.getAttribute("loginId");

		if (loginId == null) {
			model.addAttribute("msg", "needLogin");
			return "alert";
		}
		
		ArrayList<BbsDTO> bbsDTO = new ArrayList<>();
		bbsDTO = bbsService.getMyBbsAll(loginId);
		session.setAttribute("bbsList", bbsDTO);
		
		return "myBbs";
	}

	@GetMapping("/bbsWrite")
	public String bbyWrite(HttpSession session, Model model) {
		String loginId = (String) session.getAttribute("loginId");

		if (loginId == null) {
			model.addAttribute("msg", "needLogin");
			return "alert";
		}
		return "bbsWrite";
	}

	@PostMapping("/bbsWrite")
	public String bbsWrite(BbsDTO bbsDTO, HttpSession session, Model model) {
		String userId = (String) session.getAttribute("loginId");
		bbsDTO.setUserId(userId);
		if (bbsDTO.getBbsContent() == "") {
			model.addAttribute("msg", "bbsWriteEmpty");
			return "alert";
		}
		int result = bbsService.bbsWrite(bbsDTO);
		if (result == 1) {
			model.addAttribute("msg", "bbsWriteY");
		} else {
			model.addAttribute("msg", "bbsWriteN");
		}
			return "alert";
	}
	
	@GetMapping("/bbsOne/{bbsId}") 
	public String bbsOne(@PathVariable int bbsId, HttpSession session) {
	    BbsDTO bbsDTO = bbsService.getBbsOne(bbsId);
	    
	    session.setAttribute("bbsOne", bbsDTO);
	    
	    return "bbsOne";
	}
	
	@GetMapping("bbsOneDesign")
	public String design() {
		return "bbsOneDesign";
	}
	//@GetMapping("bbsOneUpdate/{bbsId}") 하면 오류남
	@GetMapping("bbsOneUpdate")
	public String bbsOneUpdate() {
		return "bbsOneUpdate";
	}
	
	@PostMapping("bbsOneUpdate")
	public String bbsOneUpdate(BbsDTO bbsDTO, String bbsContent, Model model) {
		int result = bbsService.bbsOneUpdate(bbsDTO.getBbsId(), bbsContent);
		if (result > 0) {
			model.addAttribute("msg", "bbsUpdateY");
		}else {
			model.addAttribute("msg", "bbsUpdateN");
		}
		
		return "alert";
	}
	
}
