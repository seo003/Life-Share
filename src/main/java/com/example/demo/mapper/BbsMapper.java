package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.BbsDTO;
import com.example.demo.dto.FileDTO;

@Mapper
public interface BbsMapper {

	public void bbsWrite(BbsDTO bbsDTO);

	public void fileUpload(List<FileDTO> fileDTOList);

	public ArrayList<BbsDTO> getMyBbsAll(String loginId);

	public ArrayList<BbsDTO> getBbsAll();

	public BbsDTO getBbsOne(int bbsId);

	// public int bbsOneUpdate(String bbsContent, int bbsId);
	public int bbsOneUpdate(@Param("bbsContent") String bbsContent, @Param("bbsId") int bbsId);
	
	public int bbsDelete(int bbsId);

	public ArrayList<BbsDTO> bbsDeleted(String userId);

	public int bbsRestore(int bbsId);

	public int bbsCompletedDelete(int bbsId);

    ArrayList<BbsDTO> getBbsFromUserId(String loginId);
}
