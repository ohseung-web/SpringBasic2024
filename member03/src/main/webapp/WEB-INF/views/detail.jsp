<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  table{
    border-collapse: collapse;
  }
  table tr td{
    padding: 5px;
  }
</style>
</head>
<body>
     <table width="300" border="1">
        <tr height="40">
            <th>id</th>
            <td>${member.id}</td>
        </tr>
        <tr height="40">
            <th>email</th>
            <td>${member.memberEmail}</td>
        </tr>
        <tr height="40">
            <th>password</th>
            <td>${member.memberPassword}</td>
        </tr>
        <tr height="40">
            <th>name</th>
            <td>${member.memberName}</td>
        </tr>
        <tr height="40">
            <th>age</th>
            <td>${member.memberAge}</td>
        </tr>
        <tr height="40">
            <th>mobile</th>
            <td>${member.memberMobile}</td>
        </tr>
    </table>
</body>
</html>