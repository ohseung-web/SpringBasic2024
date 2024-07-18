<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  table{
    border-collapse: collapse;
  }
</style>
</head>
<body>
   
    <table width="700" border="1">
        <tr height="40">
            <th>id</th>
            <th>email</th>
            <th>password</th>
            <th>name</th>
            <th>age</th>
            <th>mobile</th>
            <th>조회</th>
            <th>삭제</th>
        </tr>
        <c:forEach items="${memberList}" var="member">
            <tr height="40">
                <td align="center">${member.id}</td>
                <td align="center">

                    <a href="/member03/detail?id=${member.id}">${member.memberEmail}</a>
                </td>
                <td align="center">${member.memberPassword}</td>
                <td align="center">${member.memberName}</td>
                <td align="center">${member.memberAge}</td>
                <td align="center">${member.memberMobile}</td>
                <td align="center">
                    <a href="/member03/detail?id=${member.id}">조회</a>
                </td>
                <td align="center">
                    <button onclick="deleteMember('${member.id}')">삭제</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
  <script>
    const deleteMember = (id) => {
        console.log(id);
        location.href = "/member03/delete?id="+id;
    }
</script>
</html>