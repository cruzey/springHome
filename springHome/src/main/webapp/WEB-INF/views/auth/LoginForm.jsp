<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>

<body>

	<h1>사용자 로그인</h1>
	<form action="loginCtr.do" method="post">
		이메일:	<input type="text" name="email"><br/>
		암호:		<input type="password" name="password"><br/>
				<input type="submit" value="로그인">
	
	</form>

</body>
</html>