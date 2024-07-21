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

  <%-- <c:set var="loginOut" value="${mdto.id == null ? 'Login':'LogOut' }"/>
  <c:set var="loginOutLink" value="${mdto.id == null ? '/example/member/loginForm':'/example/member/logout' }" /> --%>
  
  <div id="menu">
	<ul>
	    <li id="logo">example</li>
	    <li><a href="board/">Home</a></li>
	    <li><a href="/board/boardList">Board</a></li>
	   <%--  <li><a href="${loginOutLink}">${loginOut}</a></li>    --%> 
	    <li><a href="/board/loginForm">Login</a></li>    
	    <li><a href="/board/joinForm">Sign in</a></li>
	    <li><a href=""><i class="fas fa-search small"></i></a></li>
	</ul> 
	</div>
	<div style="text-align:center">
		<table border ="1">
		   <tr>
		      <th>번호</th>
		      <th>이름</th>
		      <th>제목</th>
		      <th>등록일</th>
		      <th>조회수</th>   
		   </tr>
		   <c:forEach var="board" items="${List}">
		   <tr>
		      <td>${board.bno}</td>
		      <td>${board.title}</td>
		      <td>${board.writer}</td>
		      <td>${board.reg_date}</td>
		      <td>${board.view_cnt}</td>    
		   </tr>
		   </c:forEach>
		</table>
	</div>
</body>
</html>