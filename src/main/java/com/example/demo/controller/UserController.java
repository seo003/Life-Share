package com.example.demo.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute; //-> RequestParam의 묶음형태..클래스로 한번에 매핑
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	// 생성자 주입 UserService 인스턴스 주입
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// 로그인
	@GetMapping("/login")
	public String login(HttpSession session) {
		String loginId = (String) session.getAttribute("loginId");
		if (loginId == null) {// 로그인 X
			return "login";
		} else { // 로그인 O
			return "home";
		}
	}

	@PostMapping("/login")
	public String login(String userId,
			// @RequestParam("userId") String userId,
			String userPw, HttpSession session, Model model) { // jsp로 객체 보내는거 model
		String dbPw = userService.login(userId);
		String login = "loginY";
		if (dbPw == null) {
			login = "loginDbN";
			return "alert";
		}

		if (dbPw.equals(userPw)) {
			// 로그인 성공
			session.setAttribute("loginId", userId);
		} else {
			// 로그인 실패
			login = "loginN";
		}
		model.addAttribute("msg", login);
		return "alert";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.setAttribute("loginId", null);
		model.addAttribute("msg", "logout");
		return "alert";
	}

	@GetMapping("/profile")
	public String profile(HttpSession session, Model model) {
		String loginId = (String) session.getAttribute("loginId");

		if (loginId == null) { // 로그인 X
			model.addAttribute("msg", "needLogin");
			return "alert";
		} else { // 로그인 O
			UserDTO userInfo = userService.userInfo(loginId);
			session.setAttribute("loginUserInfo", userInfo);
			return "/profile";
		}
	}

	@GetMapping("/profileUpdate")
	public String profileUpdate() {
		return "/profileUpdate";
	}

	@PostMapping("/profileUpdate")
	public String profileUpdate(@RequestParam("file") MultipartFile uploadFile, UserDTO userDTO, Model model,
			String pwcheck) {
		String userPw = userDTO.getUserPw();

		if (userPw.equals(pwcheck)) {
			try {
				String fileName = null;
				String defaultFilePath = "C:\\SWproject\\SWproject\\src\\main\\resources\\static\\profileImage\\"; // 파일 저장 경로
				String filePath = null;
				if (!uploadFile.isEmpty()) {
					String originFileName = uploadFile.getOriginalFilename(); // 원본 파일 이름 가져오기
					String ext = FilenameUtils.getExtension(originFileName); // 파일 이름 중복되지않게 이름 변경
					UUID uuid = UUID.randomUUID();
					fileName = uuid + "." + ext;
					filePath = defaultFilePath + fileName;
					System.out.println(filePath);
					uploadFile.transferTo(new File(filePath));
				}
				Integer result;
				System.out.println("fileName " + fileName);
				if (fileName != null) { // 이미지 업로드했으면
					userDTO.setUserFileName(fileName);
					System.out.println(fileName);
					result = userService.profileUpdateFile(userDTO);
				} else {
					// System.out.println(userDTO.toString());
					result = userService.profileUpdate(userDTO);
				}
				if (result > 0) {
					model.addAttribute("msg", "pUpdateY");
					return "alert";
				} else {
					model.addAttribute("msg", "pUpdateN");
					return "alert";
				}
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("msg", "fileUploadF");
				return "alert";
			}
		} else { // 비밀번호 다름
			model.addAttribute("msg", "pwMatchFail");
			return "alert";
		}
	}

	@GetMapping("/userDelete/{userId}")
	public String userDelete(@PathVariable String userId, Model model, HttpSession session) {
		// @PathVariable("userId") String userId
		int result = userService.userDelete(userId);

		if (result > 0) {
			model.addAttribute("msg", "deleteY");
			session.setAttribute("loginId", null);
			return "alert";
		} else {
			model.addAttribute("msg", "deleteN");
			return "alert";
		}
	}
}
