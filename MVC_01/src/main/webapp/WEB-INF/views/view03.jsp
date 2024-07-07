
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.green.mvc01.dto.PersonDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>View03.jsp 입니다.</h2>
	<%
	  //root-context.xml에 저장된 Bean 처리방법
	  //root-context.xml에 저장된 Bean은 applicationScope를 가진다.
	  WebApplicationContext ctx = 
	         WebApplicationContextUtils.getWebApplicationContext(application);
	
		PersonDTO p1 = ctx.getBean("person1",PersonDTO.class);
		PersonDTO p2 = ctx.getBean("person2",PersonDTO.class);
		
		// EL사용을 위해서 4가지 영역 중 pageContext에 저장해 놓는다.
		pageContext.setAttribute("p1", p1);
		pageContext.setAttribute("p2", p2);
		
		%>
		
		<h1>사용자1</h1>
		<ul>
		   <li>이름 : ${p1.name}</li>
		   <li>나이 : ${p1.age}</li>
		   <li>전화 : ${p1.cdto.phone}</li>
		   <li>주소 : ${p1.cdto.add}</li>
		</ul>
		<h1>사용자2</h1>
		<ul>
		   <li>이름 : ${p2.name}</li>
		   <li>나이 : ${p2.age}</li>
		   <li>전화 : ${p2.cdto.phone}</li>
		   <li>주소 : ${p2.cdto.add}</li>
		</ul>
		
</body>
</html>