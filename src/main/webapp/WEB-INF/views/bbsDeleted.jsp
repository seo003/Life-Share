<%@page import="java.util.ArrayList"%>
<%@page import="com.example.demo.dto.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/myBoardStyles.css" rel="stylesheet" />
</head>
<div id="layoutSidenav">
	<div id="layoutSidenav_content">
		<main>
			<div class="content-layout">
				<div class="favorites-boards-list">
					
					<%
					ArrayList<BbsDTO> bbsList = (ArrayList) request.getAttribute("bbsDeletedList");
					BbsDTO bbsInfo = new BbsDTO();
					for (int i = bbsList.size()-1; i >= 0; i--) {
						bbsInfo = bbsList.get(i);
					%>
					<div class="favorites-board-item">
						<div class="favorites-board-thumbnails">
							<a class="one" href="/bbsDeletedOne?bbsId=<%=bbsInfo.getBbsId()%>"><img class="favorites-board-image" src="#"> </a>
						</div>
						<a class="one" href="/bbsDeletedOne?bbsId=<%=bbsInfo.getBbsId()%>">
						<div class="title">
							<div class="favorites-board-Date"><%=bbsInfo.getBbsDate()%></div>
							<div class="favorites-board-heart">♥ 15</div>
							<div class="favorites-board-title"><%=bbsInfo.getBbsContent()%>
							</div>
						</div>
						</a>
					</div>
					<%
					}
					%>
	
				</div>
			</div>
		</main>
		<%@include file="footer.jsp"%>
</html>