<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<!--
   setTimeout(function(){},delay);
   delay부분에 1000 => 1초, 10000 => 10초
   delay부분에 정의된 초만큼 지연된 뒤 코드를 실행한다.
  -->
<!-- <script type="text/javascript">
  onload = function(){
	   setTimeout(function(){
		   location.href='index';//index.jsp가아니라 @RequestMapping읠 의미
	   },1000)
   }
</script> -->
<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
