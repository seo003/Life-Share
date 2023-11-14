package com.example.demo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.BbsDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService {
	private final UserMapper userMapper;

	@Autowired // 생성자 주입
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public String login(String userId) {
		return userMapper.login(userId);
	}

	public UserDTO userInfo(String userId) {
		return userMapper.userInfo(userId);
	}

	public Integer profileUpdate(MultipartFile uploadFile, UserDTO userDTO, String pwcheck) {
		String userPw = userDTO.getUserPw();

		if (userPw.equals(pwcheck)) {
			try {
				String fileName = null;
				//파일 저장 경로
				String defaultFilePath = "C:\\SWproject\\SWproject\\src\\main\\resources\\static\\image\\profileImage\\"; 
				String filePath = null;
				if (!uploadFile.isEmpty()) {
					String originFileName = uploadFile.getOriginalFilename(); // 원본 파일 이름 가져오기
					String ext = FilenameUtils.getExtension(originFileName); // 파일 확장자
					UUID uuid = UUID.randomUUID(); // 파일 이름 중복되지않게 하기 위한 uuid
					fileName = uuid + "." + ext;
					filePath = defaultFilePath + fileName;
//					System.out.println(filePath);
					uploadFile.transferTo(new File(filePath));
				}

				Integer result;
//				System.out.println(fileName);
				if (fileName != null) { // 이미지 업로드했으면
					userDTO.setUserFileName(fileName);
				}
				result = userMapper.profileUpdate(userDTO);

				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		} else { // 비밀번호 다름
			return -1;
		}
	}

	public int userDelete(String userId) {
		return userMapper.userDelete(userId);
	}

	public ArrayList<BbsDTO> getAllUserProfileImage(ArrayList<BbsDTO> bbsDTOList) {
		// 각 BbsDTO에 userFileName 추가
		for (BbsDTO bbsDTO : bbsDTOList) {
			String userId = bbsDTO.getUserId();
			String userFileName = userMapper.getUserFileName(userId);
			if (userFileName == null) {
				userFileName = "defaultProfile.png";
			}
			bbsDTO.setProfileImage(userFileName);
		}
		return bbsDTOList;
	}

	public String getUserFileName(String userId) {
		String userFileName = userMapper.getUserFileName(userId);
		if (userFileName == null) {
			userFileName = "defaultProfile.png";
		}
		return userFileName;
	}
}
