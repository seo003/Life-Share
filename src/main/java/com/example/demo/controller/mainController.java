package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	//http://localhost:8080/에 접근할 때 이 메소드가 실행
	@GetMapping(value = "/")
    public String home() {
        return "home"; //뷰 반환(home)
    }
}
