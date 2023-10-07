<%@page import="com.example.demo.dto.BbsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/boardStyles.css" rel="stylesheet" />
</head>
<div id="layoutSidenav">
	<div id="layoutSidenav_content">
		<main>
			<%
			ArrayList<BbsDTO> bbsList = (ArrayList) session.getAttribute("bbsList");
			%>
			<div class="content-layout">
				<div class="favorites-boards-list">

					<div class="favorites-board-item">
						<div class="favorites-board-thumbnails">
							<img class="imgRound" src="qk.jpg">quokka 
							<a class="one" href="/bbsOne"><img class="favorites-board-image" src="qk.jpg"></a>
						</div>
						<a class="one" href="/bbsOne">
						<div class="title">
							<div class="favorites-board-Date">2003-02-12 10시 23분</div>
							<div class="favorites-board-heart">♥ 5</div>
							<div class="favorites-board-title">쿼카귀여워</div>
						</div>
						</a>
					</div>

					<%
					BbsDTO bbsInfo = new BbsDTO();
					for (int i = bbsList.size()-1; i >= 0; i--) {
						bbsInfo = bbsList.get(i);
					%>
					<div class="favorites-board-item">
						<div class="favorites-board-thumbnails">
							<img class="imgRound" src="#"> <%= bbsInfo.getUserId() %>
							<a class="one" href="/bbsOne/<%=bbsInfo.getBbsId() %>"><img class="favorites-board-image" src="#"></a>
						</div>
						<a class="one" href="/bbsOne/<%=bbsInfo.getBbsId()%>">
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
					
					<a href="/bbsWrite" class="float"> <i class="fa-solid fa-pen"></i>
					</a>
				</div>
		</main>
		<%@include file="footer.jsp"%>
</html>