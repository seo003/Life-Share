package com.example.demo.service;

import com.example.demo.dto.BbsDTO;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.FollowMapper;

@Service
public class FollowService {
	private FollowMapper followMapper;
	public FollowService(FollowMapper followMapper) {
		this.followMapper = followMapper;
	}
	
	
	public int follow(String fromUserID, String toUserId) {
		System.out.println("followService");
		return followMapper.follow(fromUserID, toUserId);
	}
	public BbsDTO followCount(BbsDTO bbsDTO) {
		String userId = bbsDTO.getUserId();
		int follower = followMapper.getFollowerCount(userId);
		int following = followMapper.getFollowingCount(userId);
		bbsDTO.setFollower(follower);
		bbsDTO.setFollowing(following);
		return bbsDTO;
	}

}
