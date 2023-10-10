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

					</div>

					<%
					ArrayList<BbsDTO> bbsDTOList = (ArrayList) request.getAttribute("bbsDTOList");
					BbsDTO bbsInfo = new BbsDTO();
					for (int i = bbsDTOList.size()-1; i >= 0; i--) {
						bbsInfo = bbsDTOList.get(i);
					%>
					<div class="favorites-board-item">
						<div class="favorites-board-thumbnails">
							<a class="one" href="/bbsOne?bbsId=<%=bbsInfo.getBbsId()%>"><img class="favorites-board-image" src="#"> </a>
						</div>
						<a class="one" href="/bbsOne?bbsId=<%=bbsInfo.getBbsId()%>">
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