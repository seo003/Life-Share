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
				
					<form method="post" action="/bbsWrite">
						<div class="favorites-board-item">
							<div class="favorites-board-thumbnails">
								<img class="favorites-board-image" src="#">
								<div class="favorites-board-new create-new create-text">이미지를 추가해주세요</div>
							</div>
							<div class="title">
								<table class="table">
									<tbody class="table">
										<tr>
											<td>내용 :</td>
											<td><textArea class="txtArea" name="bbsContent"
													id="bbsContent" rows="12" cols="50"></textArea></td>
										</tr>
										<tr>
											<td></td>
											<td><button type="submit"
													style="background-color: white; border-style: none">
													<a class="btn btn-primary">업로드</a>
												</button></td>
									</tbody>
								</table>
							</div>
						</div>
					</form>
					
				</div>
			</div>
		</main>
		<%@include file="footer.jsp"%>
</html>