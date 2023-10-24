<%@page import="org.springframework.ui.Model"%>
<%@page import="com.example.demo.dto.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/boardWriteStyles.css" rel="stylesheet" />
</head>
<div id="layoutSidenav">
	<div id="layoutSidenav_content">
		<main>
			<div class="content-layout">
				<div class="favorites-boards-list">

					<div class="favorites-board-item">
						<div class="title">
							<%
							BbsDTO bbsOne = (BbsDTO) request.getAttribute("bbsOne");
							int deleted = (int) request.getAttribute("deleted");

							if (loginId != null && loginId.equals(bbsOne.getUserId()) && deleted == 0) {//유저=게시글 쓴사람
							%>
							<button type="button" class="button" onclick="bbsDelete('${bbsOne.bbsId}');">삭제</button>
							<a href="/bbsOneUpdate?bbsId=${bbsOne.bbsId}"> <input type="submit" value="수정" class="button"></a>
							<%
							}

							if (deleted == 1) {
							%>
							<button type="button" class="button" onclick="bbsCompletedDelete('${bbsOne.bbsId}');">영구삭제</button>
							<button type="button" class="button" onclick="bbsRestore('${bbsOne.bbsId}');">복원</button>
							
							<%
							}
							%>

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
												<div class="favorites-board-Date date">${bbsOne.bbsDate}</div>
												<div class="favorites-board-heart heart">♥ 5</div>
												<div class="contentOne">${bbsOne.bbsContent}</div>
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
		<script>
			function bbsDelete(bbsId) {
				if (window.confirm("정말로 삭제하시겠습니까?")) {
					location.href = "/bbsDelete?bbsId=${bbsOne.bbsId}";
				}
			}

			function bbsCompletedDelete(bbsId) {
				if (window.confirm("완전히 삭제하시겠습니까?")) {
					location.href = "/bbsCompletedDelete?bbsId=${bbsOne.bbsId}";
				}
			}
			
			function bbsRestore(bbsId) {
				if (window.confirm("정말로 복원하시겠습니까?")) {
					location.href = "/bbsRestore?bbsId=${bbsOne.bbsId}";
				}
			}
			
		</script>
		<%@include file="footer.jsp"%>
</html>