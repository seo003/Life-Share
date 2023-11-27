package com.example.demo.mapper;

import com.example.demo.dto.BbsDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FollowMapper {

	int follow(String fromUserId, String toUserId);

	int getFollowerCount(String userId);

	int getFollowingCount(String userId);
}
