package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute; -> RequestParam의 묶음형태..클래스로 한번에 매핑
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;



@Controller
public class UserController {
	//생성자 주입
	private UserService userService;
	//로그인
	@GetMapping("/login")
	public String login() {
		 
		return "login";	
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute UserDTO userDTO,
						HttpSession session) {
		UserDTO loginResult = userService.login(userDTO);
		
		if (loginResult != null) {
			//로그인 성공
			//session.setAttribute("loginId", userDTO.getUserId());
			return "home";
		} else {
			//로그인 실패
			return "login";
		}
	}
}
