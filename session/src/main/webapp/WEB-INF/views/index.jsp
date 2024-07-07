<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>MAIN</h1>
	
	<!-- 회원가입을 하지 않았거나, 로그인을 하지 않은 상태 -->
	<c:if test="${empty member}">
		<a href="${cp}/member/joinForm">JOIN</a> &nbsp;&nbsp; 
		<a href="${cp}/member/loginForm">LOGIN</a> &nbsp;&nbsp; 
		<a href="${cp}/member/mypageForm">MyPage</a> &nbsp;&nbsp; 
		<a href="${cp}/member/bordForm">Board</a> &nbsp;&nbsp; 
	</c:if>
	
	<!-- 로그인을 하고 session의 값을 저장한 상태 -->
	<c:if test="${!empty member}">
		<a href="${cp}/member/logout">LOGOUT</a> &nbsp;&nbsp;
		<a href="${cp}/member/modifyForm">MODIFY</a> &nbsp;&nbsp;
		<a href="${cp}/member/removeForm">REMOVE</a> &nbsp;&nbsp;  
		<a href="${cp}/member/mypageForm">MyPage</a> &nbsp;&nbsp; 
		<a href="${cp}/member/bordForm">Board</a> &nbsp;&nbsp; 
	</c:if>
	
</body>
</html>