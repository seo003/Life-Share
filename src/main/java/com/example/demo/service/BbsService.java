package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BbsDTO;
import com.example.demo.mapper.BbsMapper;

@Service
public class BbsService {
	//생성자 주입
	private final BbsMapper bbsMapper;

	@Autowired
	public BbsService(BbsMapper bbsMapper) {
		this.bbsMapper = bbsMapper;
	}

	public int bbsWrite(BbsDTO bbsDTO) {
		return bbsMapper.bbsWrite(bbsDTO);
	}

}
