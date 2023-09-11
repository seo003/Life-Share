package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	//생성자 주입 UserService 인스턴스 주입
	private final UserService userService;
	
	@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	//로그인
	@GetMapping("/login")
	public String login(HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		if (loginId == null) {//로그인 X
			return "login";	
		}
		else { //로그인 O
			return "home";  
		}
	}
	
	@PostMapping("/login")
	public String login(String userId,
						String userPw,
						HttpSession session,
						Model model) {
		String dbPw = userService.login(userId);
		
		if (dbPw.equals(userPw)) {
			//로그인 성공
			session.setAttribute("loginId", userId);
			model.addAttribute("msg", "로그인이 성공하였습니다.");
			model.addAttribute("url", "/");
			return "alert";
		} else {
			//로그인 실패
			model.addAttribute("msg", "아이디나 비밀번호가 올바르지 않습니다.");
			model.addAttribute("url", "login");
			return "alert";
		}
	}
}
