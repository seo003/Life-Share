//package com.example.demo.controller;
//
//import java.util.ArrayList;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.example.demo.dto.BbsDTO;
//import com.example.demo.service.BbsService;
//
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//public class MainController {
//	
//	//http://localhost:8080/에 접근할 때 이 메소드가 실행
//	
//	@GetMapping("/")
//    public String home(HttpSession session, Model model) {
//		ArrayList<BbsDTO> bbsDTO = new ArrayList<>();
//		bbsDTO = BbsService.getBbsAll();
//		session.setAttribute("bbsList", bbsDTO);
//		
//        return "home"; //뷰 반환(home)
//    }
//}
