package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.FollowService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FollowController {
	
	private final FollowService followService;
	
	public FollowController(FollowService followService) {
		this.followService = followService;
	}
	
	@PostMapping("/follow")
	public ResponseEntity<String> follow(HttpSession session, String toUserId) {
		String fromUserId = (String) session.getAttribute("loginId");
   		int result = followService.follow(fromUserId, toUserId);
   		System.out.println("fromUserId: "+fromUserId);
   		System.out.println("toUserId: "+ toUserId);
   		if (result==1) {
   			//성공
   			return new ResponseEntity<>("success", HttpStatus.OK);
   		}else {
   				//실패
   			return new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
   		}
	}
	
}
