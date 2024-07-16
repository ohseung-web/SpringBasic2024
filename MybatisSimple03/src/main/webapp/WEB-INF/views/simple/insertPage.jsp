<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="wrap">
	
	<!-- action="simpleInsert" 는 @RequestMapping("simpleInsert") 를 의미한다. -->
	
	<form action="simpleInsert" method="post">
		작성자 <input type="text" name="bWriter" /><br/>
		제목 <input type="text" name="bTitle" /><br/>
		내용 <input type="text" name="bContent" /><br/>
		<input type="submit" value="작성하기" />
	</form>
	
</div>

</body>
</html>
