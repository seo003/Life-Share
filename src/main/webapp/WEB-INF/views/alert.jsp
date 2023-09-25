<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		var msg = "${msg}";
		var alertMsg = "";
		var url = "";

		switch (msg) {
		case "loginY":
			alertMsg = "로그인이 성공하였습니다.";
			url = "/";
			break;
		case "loginDbN":
			alertMsg = "존재하지 않는 사용자입니다.";
			url = "login";
			break;
		case "loginN":
			alertMsg = "아이디나 비밀번호가 올바르지 않습니다.";
			url = "/login"
			break;
		case "logout":
			alertMsg = "로그아웃 되었습니다.";
			url = "/";
			break;
		case "needLogin":
			alertMsg = "로그인이 필요합니다.";
			url = "/login";
			break;
		case "pUpdateY":
			alertMsg = "프로필 수정이 완료되었습니다.";
			url = "/profile";
			break;
		case "pUpdateN":
			alertMsg = "프로필 수정이 실패하였습니다.";
			url = "/profileUpdate";
			break;
		case "pwMatchFail":
			alertMsg = "비밀번호가 일치하지 않습니다.";
			url = "/profileUpdate";
			break;
		case "deleteY":
			alertMsg = "회원 탈퇴가 완료되었습니다.";
			url = "/";
			break;
		case "deleteN":
			alertMsg = "회원 탈퇴가 실패하였습니다.";
			url = "/profile";
			break;
		case "bbsWriteY":
			alertMsg = "게시물 작성이 완료되었습니다.";
			url = "myBbs";
			break;
		case "bbsWriteN":
			alertMsg = "게시물 작성이 실패하였습니다.";
			url = "bbsWrite";
			break;
		case "bbsWriteEmpty":
			alertMsg = "빈 칸이 있습니다.";
			url = "bbsWrite";
			break;
		}

		alert(alertMsg);
		location.href = url;
	</script>
</body>
</html>