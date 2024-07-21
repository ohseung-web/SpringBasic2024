<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/board/resources/css/menu.css">
<script src="https://kit.fontawesome.com/2cd23a15d7.js" crossorigin="anonymous"></script>
</head>
<body>
  <c:set var="loginOut" value="${mdto.id == null ? 'Login':'LogOut' }"/>
  <c:set var="loginOutLink" value="${mdto.id == null ? '/board/member/loginForm':'/board/member/logout' }" />
  
  <div id="menu">
	<ul>
	    <li id="logo">example</li>
	    <li><a href="/board/">Home</a></li>
	    <li><a href="/board/boardList">Board</a></li>
	   <%--  <li><a href="${loginOutLink}">${loginOut}</a></li>  --%>
	    <li><a href="/board/login">Login</a></li>    
	    <li><a href="/board/joinForm">Sign in</a></li>
	    <li><a href=""><i class="fas fa-search small"></i></a></li>
	</ul> 
	</div>
	<div style="text-align:center">
		<h1>This is HOME</h1>
		<h1>This is HOME</h1>
		<h1>This is HOME</h1>
	</div>
</body>
</html>