package com.example.demo.controller;

import com.example.demo.dto.BbsDTO;
import com.example.demo.service.BbsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.FollowService;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FollowController {

	private final FollowService followService;
	private final BbsService bbsService;


	public FollowController(FollowService followService, BbsService bbsService) {
		this.followService = followService;
		this.bbsService = bbsService;
	}

	@PostMapping("/follow")
	@ResponseBody
	public int follow(HttpSession session, String toUserId) {
//		System.out.println("toUserID; " + toUserId);
		String loginId = (String) session.getAttribute("loginId");
		int result = followService.follow(loginId, toUserId);
		return result;
	}

	@PostMapping("/followCount")
	@ResponseBody
	public Map<String, String> followCount(HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");

		int follower = followService.getFollowerCount(loginId);
		int following = followService.getFollowingCount(loginId);
//		System.out.println("followerC: " + follower);
//		System.out.println("followingC: " + following);

		Map<String, String> followCount = new HashMap<>();
		followCount.put("follower",  String.valueOf(follower));
		followCount.put("following", String.valueOf(following));
		followCount.put("toUserId", loginId);
//		System.out.println("followCount: " + followCount);

		return followCount;
	}
}
