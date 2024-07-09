<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
<link rel="stylesheet" href="/example/resources/css/menu.css">

<!-- Place your kit's code here fontawesome-->
<script src="https://kit.fontawesome.com/2cd23a15d7.js" crossorigin="anonymous"></script>
</head>
<body>
	<c:set var="loginOut" value="${mdto.id == null ? 'Login':'LogOut' }"/>
  <c:set var="loginOutLink" value="${mdto.id == null ? '/example/member/loginForm':'/example/member/logout' }" />
  
  <div id="menu">
	<ul>
	    <li id="logo">example</li>
	    <li><a href="/example/">Home</a></li>
	    <li><a href="/example/member/boardList">Board</a></li>
	    <li><a href="${loginOutLink}">${loginOut}</a></li>    
	    <li><a href="/example/member/joinForm">Sign in</a></li>
	    <li><a href=""><i class="fas fa-search small"></i></a></li>
	</ul> 
	</div>
	<div style="text-align:center">
		<h1>This is BOARD</h1>
		<h1>This is BOARD</h1>
		<h1>This is BOARD</h1>
		<h1>This is BOARD</h1>
		<h1>This is BOARD</h1>
	</div>
</body>
</html>