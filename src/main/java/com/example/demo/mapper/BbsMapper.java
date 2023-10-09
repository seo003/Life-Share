package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BbsDTO;

@Mapper
public interface BbsMapper {

	public int bbsWrite(BbsDTO bbsDTO);

	public ArrayList<BbsDTO> getMyBbsAll(String loginId);

	public ArrayList<BbsDTO> getBbsAll();
	
	public BbsDTO getBbsOne(int bbsId);

	public int bbsOneUpdate(int bbsId, String bbsContent);	

}
