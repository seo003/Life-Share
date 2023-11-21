package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.BbsDTO;
import com.example.demo.service.BbsService;
import com.example.demo.service.FileService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BbsController {
	// 생성자 주입
	private final BbsService bbsService;
	private final UserService userService;
	private final FileService fileService;

	@Autowired
	public BbsController(BbsService bbsService, UserService userService, FileService fileService) {
		this.bbsService = bbsService;
		this.userService = userService;
		this.fileService = fileService;
	}

	@GetMapping("/")
	public String home(Model model) {
		ArrayList<BbsDTO> bbsDTOList = new ArrayList<>();
		
		bbsDTOList = bbsService.getBbsAll();
		bbsDTOList = userService.getAllUserProfileImage(bbsDTOList);
		
		bbsDTOList = fileService.getAllBbsFile(bbsDTOList);
		
		model.addAttribute("bbsDTOList", bbsDTOList);

		return "home";
	}

	@GetMapping("/myBbs")
	public String myBbs(HttpSession session, Model model) {
		String loginId = (String) session.getAttribute("loginId");

		if (loginId == null) {
			model.addAttribute("msg", "needLogin");
			return "alert";
		}

		ArrayList<BbsDTO> bbsDTOList = bbsService.getMyBbsAll(loginId);
		bbsDTOList = fileService.getAllBbsFile(bbsDTOList);
		model.addAttribute("bbsDTOList", bbsDTOList);

		return "myBbs";
	}

	@GetMapping("/bbsWrite")
	public String bbyWrite(HttpSession session, Model model) {
		String loginId = (String) session.getAttribute("loginId");

		if (loginId == null) {
			model.addAttribute("msg", "needLogin");
			return "alert";
		}
		return "bbsWrite";
	}

	@PostMapping("/bbsWrite")
	public String bbsWrite(BbsDTO bbsDTO, HttpSession session, Model model, @RequestParam("file") List<MultipartFile> files) {
		String userId = (String) session.getAttribute("loginId");
		bbsDTO.setUserId(userId);
		if (bbsDTO.getBbsContent() == "") {
			model.addAttribute("msg", "bbsWriteEmpty");
			return "alert";
		}
		int result = bbsService.bbsWrite(bbsDTO, files);
		if (result == 1) {
			
			model.addAttribute("msg", "bbsWriteY");
		} else {
			model.addAttribute("msg", "bbsWriteN");
		}
		return "alert";
		
	}

	@GetMapping("/bbsOne")
	public String bbsOne(int bbsId, Model model) {
		BbsDTO bbsDTO = bbsService.getBbsOne(bbsId);
		String userProfile = userService.getUserFileName(bbsDTO.getUserId());
		bbsDTO.setProfileImage(userProfile);
		
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames = fileService.getFiles(bbsDTO.getBbsId());
		bbsDTO.setBbsFiles(fileNames);

		model.addAttribute("bbsOne", bbsDTO);
		model.addAttribute("deleted", 0);
		
		return "bbsOne";
	}

	@GetMapping("/bbsOneUpdate")
	public String bbsOneUpdate(int bbsId, Model model) {
		BbsDTO bbsDTO = bbsService.getBbsOne(bbsId);
		
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames = fileService.getFiles(bbsDTO.getBbsId());
		bbsDTO.setBbsFiles(fileNames);
		
		model.addAttribute("bbsOne", bbsDTO);
		return "bbsOneUpdate";
	}

	@PostMapping("/bbsOneUpdate")
	public String bbsOneUpdate(int bbsId, String bbsContent, Model model) {
		int result = bbsService.bbsOneUpdate(bbsContent, bbsId);
		if (result > 0) {
			model.addAttribute("msg", "bbsUpdateY");
			model.addAttribute("bbsId", bbsId);
		} else {
			model.addAttribute("msg", "bbsUpdateN");
		}

		return "alert";
	}

	@GetMapping("/bbsDelete")
	public String bbsDelete(int bbsId, Model model) {
		int result = bbsService.bbsDelete(bbsId);
		if (result > 0) {
			model.addAttribute("msg", "bbsDeleteY");
		} else {
			model.addAttribute("msg", "bbsDeleteN");
			model.addAttribute("bbsId", bbsId);
		}
		return "alert";
	}

	@GetMapping("/bbsDeleted")
	public String bbsDeleted(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("loginId");
		ArrayList<BbsDTO> bbsDeletedList = new ArrayList<>();

		bbsDeletedList = bbsService.getBbsDeleted(userId);
		if (bbsDeletedList.size() == 0) {
			model.addAttribute("msg", "deletedNothing");
			return "alert";
		} else {
			bbsDeletedList = fileService.getAllBbsFile(bbsDeletedList);
			model.addAttribute("bbsDeletedList", bbsDeletedList);
			return "bbsDeleted";
		}
	}

	@GetMapping("/bbsDeletedOne")
	public String bbsDeletedOne(int bbsId, Model model) {
		BbsDTO bbsDTO = bbsService.getBbsOne(bbsId);
		String userProfile = userService.getUserFileName(bbsDTO.getUserId());
		bbsDTO.setProfileImage(userProfile);
		
		ArrayList<String> fileNames = new ArrayList<>();
		fileNames = fileService.getFiles(bbsDTO.getBbsId());
		bbsDTO.setBbsFiles(fileNames);
		
		model.addAttribute("bbsOne", bbsDTO);
		model.addAttribute("deleted", 1);

		return "bbsOne";
	}

	@GetMapping("/bbsRestore")
	public String bbsRestore(int bbsId, Model model) {
		int result = bbsService.getBbsRestore(bbsId);
		if (result > 0) {
			model.addAttribute("msg", "bbsRestoreY");
		} else {
			model.addAttribute("msg", "bbsRestoreN");
		}
		return "alert";
	}
	
	@GetMapping("/bbsCompletedDelete")
	public String bbsCompletedDelete(int bbsId, Model model) {
		int result = bbsService.bbsCompletedDelete(bbsId);
		if (result == 1) {
			model.addAttribute("msg", "bbsCompletedDeleteY");
		} else {
			model.addAttribute("msg", "bbsCompletedDeleteN");
			model.addAttribute("bbsId", bbsId);
		}
		
		return "alert";
	}
}
