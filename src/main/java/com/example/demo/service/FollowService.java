package com.example.demo.service;

import com.example.demo.dto.BbsDTO;
import com.example.demo.mapper.BbsMapper;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.FollowMapper;

import java.util.ArrayList;

@Service
public class FollowService {
    private FollowMapper followMapper;
    private BbsMapper bbsMapper;

    public FollowService(FollowMapper followMapper, BbsMapper bbsMapper) {
        this.followMapper = followMapper;
        this.bbsMapper = bbsMapper;
    }


    public int follow(String fromUserID, String toUserId) {
        int result = 0;
        if (fromUserID == null) {
            result = 0; //로그인 필요
        }
        if (fromUserID.equals(toUserId)) {
            result = 2;
        }
        System.out.println("fromUserId: " + fromUserID);
        System.out.println("toUserId: " + toUserId);
        int followResult = followMapper.follow(fromUserID, toUserId);

        if (followResult == 1) {
            ArrayList<BbsDTO> bbsList = bbsMapper.getBbsFromUserId(fromUserID);
            for (BbsDTO bbsDTO : bbsList) {
                bbsDTO = followCount(bbsDTO);
            }
            result = 1;
        } else {
            result = -1;
        }
        return result;
    }

    public BbsDTO followCount(BbsDTO bbsDTO) {
        String userId = bbsDTO.getUserId();
        int follower = followMapper.getFollowerCount(userId);
        int following = followMapper.getFollowingCount(userId);
        bbsDTO.setFollower(follower);
        bbsDTO.setFollowing(following);
        return bbsDTO;
    }

    public int getFollowerCount(String loginId) {
        return followMapper.getFollowerCount(loginId);
    }

    public int getFollowingCount(String loginId) {
        return followMapper.getFollowingCount(loginId);
    }
}
