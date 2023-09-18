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
				<div class="card">
					<div class="card-body">
						<a href="/profileUpdate"><i class="fa fa-pen fa-xs edit"></i></a>
						<table>
							<tbody>
								<tr>
									<td>ID</td>
									<td>:</td>
									<td><%=info.getUserId()%></td>
								</tr>
								<tr>
									<td>Name</td>
									<td>:</td>
									<td><%=info.getUserName()%></td>
								</tr>
								<tr>
									<td>Password</td>
									<td>:</td>
									<td><%=info.getUserPw()%></td>
								</tr>
								<tr>
									<td>Phone Number</td>
									<td>:</td>
									<td><%=info.getUserPhone()%></td>
								</tr>
								<tr>
									<td>Email</td>
									<td>:</td>
									<td><%=info.getUserEmail()%></td>
								</tr>
								<tr>
									<td>Gender</td>
									<td>:</td>
									<td><%=info.getUserGender()%></td>
								</tr>
								<tr>
									<td>Birth</td>
									<td>:</td>
									<td><%=info.getUserBirth()%></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- End -->
		</main>
		<%@include file="footer.jsp"%>
</html>