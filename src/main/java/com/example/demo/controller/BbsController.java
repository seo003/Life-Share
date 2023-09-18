package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BbsController {
	@GetMapping(value = "/myBbs")
    public String myBbs() {
        return "myBbs"; //뷰 반환(home)
    }
}
