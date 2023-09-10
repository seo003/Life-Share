package com.example.demo.dto;

import lombok.Data;

//@Data는 @Getter, @Setter, @ToString 등 여러 어노테이션을 함쳐놓은느낌쓰
@Data
public class UserDTO {
	private String userName;
	private String userId;
	private String userPw;
	private String userPhone;
	private String userEmail;
	private String userGender;
	private String userBirth;
}
