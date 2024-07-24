<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/codingboard/resources/css/menu.css">
<script src="https://kit.fontawesome.com/2cd23a15d7.js" crossorigin="anonymous"></script>
</head>
<body>

 <%--  <c:set var="loginOut" value="${mdto.id == null ? 'Login':'LogOut' }"/>
  <c:set var="loginOutLink" value="${mdto.id == null ? '/example/member/loginForm':'/example/member/logout' }" />
   --%>
  <div id="menu">
	<ul>
	    <li id="logo">example</li>
	    <li><a href="/codingboard/">Home</a></li>
	    <li><a href="/codingboard/boardListpaging">Board</a></li>
	    <li><a href="/codingboard/">Login</a></li>    
	    <li><a href="/codingboard/joinForm">Sign in</a></li>
	    <li><a href=""><i class="fas fa-search small"></i></a></li>
	</ul> 
	</div>

</body>
</html>