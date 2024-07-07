<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<input type="button" value="view04" onclick="location.href='v04'" />
<!-- @RequestMappin("v04")로 이동하는 방법 -->

<input type="button" value="view05" onclick="location.href='v05'" />
</body>
</html>
