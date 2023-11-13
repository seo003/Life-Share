package com.example.demo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.BbsDTO;
import com.example.demo.dto.FileDTO;
import com.example.demo.mapper.BbsMapper;

@Service
public class BbsService {
	// 생성자 주입
	private final BbsMapper bbsMapper;

	@Autowired
	public BbsService(BbsMapper bbsMapper) {
		this.bbsMapper = bbsMapper;
	}

	public int bbsWrite(BbsDTO bbsDTO, List<MultipartFile> uploadFiles) {
		try {
			List<FileDTO> fileDTOList = new ArrayList<>();
			
			String defaultFilePath = "C:\\SWproject\\SWproject\\src\\main\\resources\\static\\bbsFiles\\";
			String originFileName = null;
			String fileName = null;
			String filePath = null;
			String ext;
			UUID uuid;

			bbsMapper.bbsWrite(bbsDTO);
			int bbsId = bbsDTO.getBbsId();
//			System.out.println(bbsId);

			
			for (MultipartFile file : uploadFiles) {
				originFileName = file.getOriginalFilename();
				ext = FilenameUtils.getExtension(originFileName);
				uuid = UUID.randomUUID();
				fileName = bbsId + "_" + uuid + "." + ext;
				filePath = defaultFilePath + fileName;
//				System.out.println(filePath);
				
				FileDTO saveFile = new FileDTO();
				saveFile.setBbsId(bbsId);
				saveFile.setOriginalFileName(originFileName);
				saveFile.setFileName(fileName);
				fileDTOList.add(saveFile);
//				System.out.println(saveFile.toString());
				
				file.transferTo(new File(filePath));
			}
			
			if (!fileDTOList.isEmpty()) {
	            bbsMapper.fileUpload(fileDTOList);
	            
	        }
			return 1; // 업로드 성공
		} catch (Exception e) {
			e.printStackTrace();
			return 0; // 오류
		}
	}

	public ArrayList<BbsDTO> getMyBbsAll(String loginId) {
		return bbsMapper.getMyBbsAll(loginId);
	}

	public ArrayList<BbsDTO> getBbsAll() {
		return bbsMapper.getBbsAll();
	}

	public BbsDTO getBbsOne(int bbsId) {
		return bbsMapper.getBbsOne(bbsId);
	}

	public int bbsOneUpdate(String bbsContent, int bbsId) {
		return bbsMapper.bbsOneUpdate(bbsContent, bbsId);
	}

	public int bbsDelete(int bbsId) {
		return bbsMapper.bbsDelete(bbsId);
	}

	public int getBbsRestore(int bbsId) {
		return bbsMapper.bbsRestore(bbsId);
	}

	public ArrayList<BbsDTO> getBbsDeleted(String userId) {
		return bbsMapper.bbsDeleted(userId);
	}

	public int bbsCompletedDelete(int bbsId) {
		return bbsMapper.bbsCompletedDelete(bbsId);

	}

}
