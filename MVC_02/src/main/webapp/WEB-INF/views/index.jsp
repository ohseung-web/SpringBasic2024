<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Main Screen</h2>
<form action="board/view03" method="get">
   <label>제목</label>
   <input type="text" name="title"><br>
   <label>내용</label>
   <input type="text" name="content"><br>
   <label>조회수</label>
   <input type="text" name="hit"><br>
   <input type="submit" value="입력">
</form> 
</body>
</html>