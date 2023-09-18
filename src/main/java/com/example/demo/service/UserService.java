package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService{
	private final UserMapper userMapper;
	
	@Autowired // 생성자 주입 
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
	
	public String login(String userId) {
		return userMapper.login(userId);
	}

	public UserDTO userInfo(String userId) {
		return userMapper.userInfo(userId);
	}
	
	public Integer profileUpdate(UserDTO userDTO) {
		Integer result = userMapper.profileUpdate(userDTO);
		//System.out.println(result); 
		if(result == null) {
			return 0;
		}else {
			return result;
		}
	}
}
