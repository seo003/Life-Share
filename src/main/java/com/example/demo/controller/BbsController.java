package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class BbsController {
	@GetMapping("/myBbs")
	public String myBbs(HttpSession session, Model model) {
		String loginId = (String) session.getAttribute("loginId");

		if (loginId == null) {
			model.addAttribute("msg", "needLogin");
			return "alert";
		}
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
}
