<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER JOIN OK</title>
</head>
<body>
    <h1>MEMBER JOIN OK</h1>
     
     ID    : ${m.id}<br>
     PW    : ${m.pwd}<br>
     NAME  : ${m.name}<br>
     EMAIL : ${m.email}<br>
     BIRTH : ${m.birth}<br>
     SNS   : ${m.sns}<br><br>
     
     <a href="/example/">HOME</a> 
     
</body>
</html>