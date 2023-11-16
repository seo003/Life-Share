package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BbsDTO;
import com.example.demo.mapper.FileMapper;

@Service
public class FileService {

	private final FileMapper fileMapper;

	@Autowired
	public FileService(FileMapper fileMapper) {
		this.fileMapper = fileMapper;
	}

	public ArrayList<String> getFiles(int bbsId) {
		return fileMapper.getFiles(bbsId);
	}
	
	public ArrayList<BbsDTO> getAllBbsFile(ArrayList<BbsDTO> bbsDTOList) {
		for (BbsDTO bbsDTO : bbsDTOList) {
			ArrayList<String> fileNames = new ArrayList<>();
			fileNames = fileMapper.getFiles(bbsDTO.getBbsId());
			bbsDTO.setBbsFiles(fileNames);
//			System.out.println(bbsDTO.getBbsFiles());
		}
		return bbsDTOList;
	}
}
