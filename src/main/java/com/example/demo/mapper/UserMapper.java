package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;


//xml파일에 있는 sql문을 호출하기 위한 인터페이스
@Mapper
public interface UserMapper {
	public String login(String userId);
}
