package com.example.demo.dto;

import java.sql.Timestamp;
import java.util.ArrayList;

public class BbsDTO {
	private int bbsId;
	private String userId;
	private String bbsContent;
	private Timestamp bbsDate;
	private int bbsAvailable;
	private int follower;
	private int following;

	private String profileImage;
	private ArrayList<String> bbsFiles;

	public int getBbsId() {
		return bbsId;
	}

	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBbsContent() {
		return bbsContent;
	}

	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}

	public Timestamp getBbsDate() {
		return bbsDate;
	}

	public void setBbsDate(Timestamp bbsDate) {
		this.bbsDate = bbsDate;
	}

	public int getBbsAvailable() {
		return bbsAvailable;
	}

	public void setBbsAvailable(int bbsAvailable) {
		this.bbsAvailable = bbsAvailable;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public ArrayList<String> getBbsFiles() {
		return bbsFiles;
	}

	public void setBbsFiles(ArrayList<String> bbsFiles) {
		this.bbsFiles = bbsFiles;
	}

	public int getFollower() {
		return follower;
	}

	public void setFollower(int follower) {
		this.follower = follower;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}


}
