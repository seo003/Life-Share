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

@Controller
public class FollowController {

	private final FollowService followService;
	private final BbsService bbsService;


	public FollowController(FollowService followService, BbsService bbsService) {
		this.followService = followService;
		this.bbsService = bbsService;
	}

//	@PostMapping("/follow")
//	@ResponseBody
//	public ResponseEntity<?> follow(HttpSession session, String toUserId) {
//		String loginId = (String) session.getAttribute("loginId");
//		if (loginId == null) {
//			return new ResponseEntity<>("로그인이 필요합니다", HttpStatus.UNAUTHORIZED);
//		}
//		System.out.println("fromUserId: " + loginId);
//		System.out.println("toUserId: " + toUserId);
//
//		int result = followService.follow(loginId, toUserId); //성공 1, 실패 0
//
//		if(result == 1) {
//			ArrayList<BbsDTO> bbsList = new ArrayList<>();
//			bbsList = bbsService.getBbsFromUserId(loginId);
//			for (BbsDTO bbsDTO : bbsList) {
//				bbsDTO = followService.followCount(bbsDTO);
//			}
//			return new ResponseEntity<>(bbsList.get(0), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>("팔로우 처리에 실패하였습니다", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	@GetMapping("/follow")
	public String  follow(HttpSession session, Model model, String followId) {
		String loginId = (String) session.getAttribute("loginId");
		if (loginId == null) {
			model.addAttribute("msg", "needLogin");
			return "alert";
		}
		System.out.println("followId: " +followId);
		System.out.println("logniId: " + loginId);

		int result = followService.follow(loginId, followId); //성공 1, 실패 0
		if (result == 1) {
			model.addAttribute("msg", "followY");
		} else {
			model.addAttribute("msg", "followN");
		}
		return "alert";
	}
}
