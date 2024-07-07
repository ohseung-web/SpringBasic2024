<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form action="member/login" method="get">
    <label>아이디</label>
    <input type="text" name="id" autofocus><br>
    <label>비밀번호</label>
    <input type="password" name="pw"><br>
    <input type="submit" value="로그인">
</form>
<br>
<form action="member/login2" method="post">
    <label>아이디</label>
    <input type="text" name="id" autofocus><br>
    <label>비밀번호</label>
    <input type="password" name="pw"><br>
    <input type="submit" value="로그인">
</form>

</body>
</html>