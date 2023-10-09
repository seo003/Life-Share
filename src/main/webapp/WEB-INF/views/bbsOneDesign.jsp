<%@page import="com.example.demo.dto.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/boardWriteStyles.css" rel="stylesheet" />
</head>
<div id="layoutSidenav">
	<div id="layoutSidenav_content">
		<main>
			<%
			BbsDTO bbsDTO = (BbsDTO) session.getAttribute("bbsOne");
			%>
			<div class="content-layout">
				<div class="favorites-boards-list">
				
					<div class="favorites-board-item">
					
						<div class="title">
						
							<input type="submit" value="삭제" class="button">
							<input type="submit" value="수정" class="button">
							
							<table class="showtable">
								<tbody class="showTable">
									<tr>
										<td>
											<div class="favorites-board-thumbnails">
												<img class="favorites-board-image" src="#">
												<div class="favorites-board-new create-new create-text"></div>
											</div>
										</td>
									</tr>
									<tr>
										<td class="td">
											<div class="content">
												<div class="favorites-board-Date date">날짜</div>
												<div class="favorites-board-heart heart">♥ 5</div>
												<div class="contentOne">내애애애애애애애애애애용</div>
											</div>
										</td>
									</tr>
									<tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<%--댓글
				<div class="coment">
				<%@include file="comment.jsp"%>
				</div>--%>
			</div>
		</main>
		<%@include file="footer.jsp"%>
</html>