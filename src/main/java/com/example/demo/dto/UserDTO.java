package com.example.demo.dto;

public class UserDTO {
	private String userName;
	private String userId;
	private String userPw;
	private String userPhone;
	private String userEmail;
	private String userGender;
	private String userBirth;
	private String userFileName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserFileName() {
		return userFileName;
	}

	public void setUserFileName(String userFileName) {
		this.userFileName = userFileName;
	}

	public UserDTO(String userName, String userId, String userPw, String userPhone, 
			String userEmail, String userGender,String userBirth) {
		this.userName = userName;
		this.userId = userId;
		this.userPw = userPw;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.userBirth = userBirth;
	}
	
	@Override
	public String toString() {
		return "VALUE : " + userName + ", " + userId + ", "+ userPw + ", "+ userPhone + ", "+ userEmail + ", "
				+ userGender + ", "+ userBirth + ", "+ userFileName + "  = END =  ";
	}
	
}
