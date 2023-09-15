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
    
    switch(msg) {
    case "loginY":
    	alertMsg = "로그인이 성공하였습니다.";
	    url = "/";
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
    }
    
    alert(alertMsg);
    location.href = url;
</script>
</body>
</html>