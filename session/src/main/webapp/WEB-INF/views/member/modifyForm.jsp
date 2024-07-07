<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
</head>
<body>

	<h1>MEMBER MODIFY</h1>
	
	<form action="${cp}/member/modify" method="post" >
	    <input type="hidden" name="memId" value="${member.memId}" />
		<table>
			<tr>
				<td>ID</td>
				<td>${member.memId}</td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="memPw" /></td>
			</tr>
			<tr>
				<td>MAIL</td>
				<td><input type="text" name="memMail" value="${member.memMail}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Modify" ></td>
			</tr>
		</table>
	</form>
	
	<a href="${cp}/">MAIN</a>
</body>
</html>