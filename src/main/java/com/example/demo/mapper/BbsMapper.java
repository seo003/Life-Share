package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BbsDTO;

@Mapper
public interface BbsMapper {

	public int bbsWrite(BbsDTO bbsDTO);

}
