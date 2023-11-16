package com.example.demo.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
	public ArrayList<String> getFiles(int bbsId);
}
