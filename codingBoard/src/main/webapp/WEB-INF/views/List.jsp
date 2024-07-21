<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  table{
    border-collapse: collapse;
  }
  table tr td {text-align: center}
</style>

</head>
<body>
  <h2>BoardList Page</h2>
  <table border="1" width="600">
        <tr height="40">
            <th>no</th>
            <th>title</th>
            <th>writer</th>
            <th>date</th>
            <th>hits</th>
        </tr>
        <c:forEach items="${bdtoList}" var="board">
            <tr height="40">
                <td>${board.id}</td>
                <td>
                    <a href="/codingboard/boardonelist?id=${board.id}">${board.boardTitle}</a>
                </td>
                <td>${board.boardWriter}</td>
                <td>${board.boardCreatedTime}</td>
                <td>${board.boardHits}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>