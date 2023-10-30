<%@page import="com.example.demo.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/profileStyles.css" rel="stylesheet" />
</head>
<div id="layoutSidenav">
	<div id="layoutSidenav_content">
		<main>
			<%
			UserDTO info = (UserDTO) session.getAttribute("loginUserInfo");
			%>
			<!-- Main -->
			<div class="main">
				<h2>PROFILE</h2>
				<form action="/profileUpdate" method="post" name="profileUpdate" enctype="multipart/form-data">
					<div class="card">
						<div class="card-image">
							프로필 이미지를 선택해주세요.<input type="file" name="file" class="profileFile">
						</div>
						<div class="card-body">
							<table>
								<tbody>
									<tr>
										<td>ID</td>
										<td>:</td>
										<td><input type="text" class="update" name="userId"
											value="<%=info.getUserId()%>" readonly></td>
									</tr>
									<tr>
										<td>Name</td>
										<td>:</td>
										<td><input type="text" class="update" name="userName"
											value="<%=info.getUserName()%>"></td>
									</tr>

									<tr>
										<td>Password</td>
										<td>:</td>
										<td><input type="password" class="update" name="userPw"
											value="<%=info.getUserPw()%>"></td>

									</tr>
									<tr>
										<td>Password Check</td>
										<td>:</td>
										<td><input type="password" class="update" name="pwcheck"
											value="<%=info.getUserPw()%>"></td>

									</tr>
									<tr>
										<td>Phone Number</td>
										<td>:</td>
										<td><input type="text" class="update" name="userPhone"
											value="<%=info.getUserPhone()%>"></td>
									</tr>
									<tr>
										<td>Email</td>
										<td>:</td>
										<td><input type="email" class="update" name="userEmail"
											value="<%=info.getUserEmail()%>"></td>
									</tr>
									<tr>
										<td>Gender</td>
										<td>:</td>
										<td><input type="text" class="update" name="userGender"
											value="<%=info.getUserGender()%>"></td>
									</tr>
									<tr>
										<td>Birth</td>
										<td>:</td>
										<td><input type="text" class="update" name="userBirth"
											value="<%=info.getUserBirth()%>"></td>
									</tr>
								</tbody>
							</table>
							<input type="submit" value="수정" class="button">
						</div>
					</div>
				</form>
			</div>
			<!-- End -->
		</main>
		<%@include file="footer.jsp"%>
</html>