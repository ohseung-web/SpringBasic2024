<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2> 회원가입 성공</h2>
    <table border="1">
		<tr>
			<td>email</td>
            <td>password</td>
            <td>name</td>
            <td>age</td>
            <td>mobile</td>
		</tr>
		<tr>
			<td>${m.memberEmail}</td>
			<td>${m.memberPassword}</td>
			<td>${m.memberName}</td>
			<td>${m.memberAge}</td>
			<td>${m.memberMobile}</td>
		</tr>
		<tr>
			<td colspan="6" aligin="center">
				<input type="button" value="Home" onclick="location.href='index'">
			</td>
		</tr>
	</table>
</body>
</html>