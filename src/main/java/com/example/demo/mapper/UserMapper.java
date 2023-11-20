package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.dto.UserDTO;

//xml파일에 있는 sql문을 호출하기 위한 인터페이스
@Mapper
public interface UserMapper {
	public String login(String userId);

	public UserDTO userInfo(String userId);
	
	public Integer profileUpdate(UserDTO userDTO);
	
	public int userDelete(String userId);
	// 삭제 성공한 행 개수 반환
	public String getUserFileName(String userId);

	public Integer profileUpdateNoFile(UserDTO userDTO);
}
