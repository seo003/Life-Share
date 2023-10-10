package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String home(Model model) {
		ArrayList<BbsDTO> bbsDTOList = new ArrayList<>();
		bbsDTOList = bbsService.getBbsAll();
		model.addAttribute("bbsDTOList", bbsDTOList);

		return "home";
	}

	@GetMapping("/myBbs")
	public String myBbs(HttpSession session, Model model) {
		String loginId = (String) session.getAttribute("loginId");

		if (loginId == null) {
			model.addAttribute("msg", "needLogin");
			return "alert";
		}

		ArrayList<BbsDTO> bbsDTOList = new ArrayList<>();
		bbsDTOList = bbsService.getMyBbsAll(loginId);
		model.addAttribute("bbsDTOList", bbsDTOList);

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

	@GetMapping("/bbsOne")
	public String bbsOne(int bbsId, Model model ) {
		BbsDTO bbsDTO = bbsService.getBbsOne(bbsId);
		
		model.addAttribute("bbsOne", bbsDTO);
		
		return "bbsOne";
	}

	@GetMapping("/bbsOneUpdate")
	public String bbsOneUpdate(int bbsId, Model model ) {
		BbsDTO bbsDTO = bbsService.getBbsOne(bbsId);
		model.addAttribute("bbsOne", bbsDTO);
		return "bbsOneUpdate";
	}

	@PostMapping("/bbsOneUpdate")
	public String bbsOneUpdate(int bbsId, String bbsContent, Model model) {
		int result = bbsService.bbsOneUpdate(bbsContent, bbsId);
		if (result > 0) {
			model.addAttribute("msg", "bbsUpdateY");
			model.addAttribute("bbsId", bbsId);
		} else {
			model.addAttribute("msg", "bbsUpdateN");
		}

		return "alert";
	}
	
	@GetMapping("/bbsDelete")
	public String bbsDelete(int bbsId, Model model) {
		int result = bbsService.bbsDelete(bbsId);
		if (result>0) {
			model.addAttribute("msg", "bbsDeleteY");
		} else {
			model.addAttribute("msg", "bbsDeleteN");
			model.addAttribute("bbsId", bbsId);
		}
		return "alert";
	}
}
