package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.dto.UserDTO;

//xml파일에 있는 sql문을 호출하기 위한 인터페이스
@Mapper
public interface UserMapper {
	public String login(String userId);

	public UserDTO userInfo(String userId);

	public Integer profileUpdate(UserDTO userDTO);
	// 수정에 성공한 행의 개수를 반환(실패시 0 반환) -> int
}
