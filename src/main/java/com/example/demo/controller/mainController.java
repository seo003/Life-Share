package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	//애플리케이션의 기본 URL (예: http://localhost:8080/)에 접근할 때 이 메소드가 실행
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
		          
        return "home"; //뷰 반환(home)
    }
}
