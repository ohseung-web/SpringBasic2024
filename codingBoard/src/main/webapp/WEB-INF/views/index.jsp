<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		body { overflow-y: scroll; background: white; }
		* { margin: 0; padding: 0; }
		#section_div{height:100%; margin:60px auto; } 
	</style>
</head>
<body>
  <!-- <h2>Hello Spring Framework</h2> -->
  <!-- <a href="/codingboard/insert">글작성</a>
  <a href="/codingboard/paging">글목록</a> -->
  <!-- <a href="/codingboard/paging">페이징 목록</a> -->
  
  <%-- <h2>${section}</h2> --%>
  <c:if test="${empty section}"> <!-- section == null -->
 		<c:set var = "section" value="Section.jsp"/>
  </c:if>
  <jsp:include page="Header.jsp"></jsp:include>
  <div id="section_div"><jsp:include page="${section}"></jsp:include></div>
</body>
</html>