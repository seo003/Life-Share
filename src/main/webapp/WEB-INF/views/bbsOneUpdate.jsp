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
			<div class="content-layout">
				<div class="favorites-boards-list">

					<div class="favorites-board-item">
						<div class="title">
							<%-- <form action="/bbsOneUpdate" method="post" name="bbsOneUpdate" enctype="multipart/form-data">--%>
							<form action="/bbsOneUpdate" method="post" name="bbsOneUpdate">
								<input type="submit" value="변경" class="button">
								<input type="text" value="${bbsOne.bbsId}" name="bbsId" style="display:none;">
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
													<div class="contentOne">
														<textarea class="bbsContentUpdate" name="bbsContent"
															id="bbsContent" rows="3" cols="50">${bbsOne.bbsContent}</textarea>
													</div>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</form>

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