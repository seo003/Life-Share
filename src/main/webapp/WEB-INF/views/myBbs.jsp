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
			<%
			ArrayList<BbsDTO> bbsList = (ArrayList) session.getAttribute("bbsList");
			%>
			<div class="content-layout">
				<div class="favorites-boards-list">
					<div class="favorites-board-new">
						<a href="/bbsWrite">
							<div class="create-new">
								<div class="icon-plus">+</div>
								<div class="create-text">새 게시물 작성</div>
							</div>
						</a>
						<div class="title">
							<div class="favorites-board-title">New Design Board</div>
							<div class="favorites-board-heart">♥ 0</div>
						</div>
						<%-- 댓글
						<%@include file="comment.jsp"%> --%>

						<div></div>
					</div>


					<div class="favorites-board-item">
						<div class="favorites-board-thumbnails">

							<img class="favorites-board-image" src="qk.jpg">
						</div>
						<div class="title">
							<div class="favorites-board-Date">2003-02-12 10시 23분</div>
							<div class="favorites-board-heart">♥ 5</div>
							<div class="favorites-board-title">쿼카귀여워</div>
						</div>
					</div>

					<%
					BbsDTO bbsInfo = new BbsDTO();
					for (int i = 0; i < bbsList.size(); i++) {
						bbsInfo = bbsList.get(i);
					%>
					<div class="favorites-board-item">
						<div class="favorites-board-thumbnails">
							<img class="favorites-board-image" src="#">
						</div>
						<div class="title">
							<div class="favorites-board-Date"><%=bbsInfo.getBbsDate()%></div>
							<div class="favorites-board-heart">♥ 15</div>
							<div class="favorites-board-title"><%=bbsInfo.getBbsContent()%>
							</div>
						</div>
					</div>
					<%
					}
					%>

				</div>
			</div>
		</main>
		<%@include file="footer.jsp"%>
</html>