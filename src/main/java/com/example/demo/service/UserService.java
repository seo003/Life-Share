package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
