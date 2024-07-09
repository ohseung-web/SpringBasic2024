<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid #cccccc;
}
	
table td {
	padding: 3px;
	border: 1px solid #cccccc;
}

</style>

</head>
<body>
    <h1>MEMBER REMOVE</h1>
	
	<form:form action="${cp}/member/remove" method="post" commandName="member">
		<input type="hidden" name="memId" value="${member.memId}">
		<table>
			<tr>
				<td>ID</td>
				<td>${member.memId}</td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:password path="memPw" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Remove" ></td>
			</tr>
		</table>
	</form:form>
	
	<a href="${cp}/">MAIN</a>
</body>
</html>