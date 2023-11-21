package com.example.demo.dto;

public class FollowDTO {
	private int followId;
	private String fromUserId;
	private String toUserId;
	
	public int getFollowId() {
		return followId;
	}
	public void setFollowId(int followId) {
		this.followId = followId;
	}
	public String getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	
	@Override
	public String toString() {
		return "followId: " + followId + " fromUserId: " + fromUserId + " toUserId: " + toUserId;
	}
}
