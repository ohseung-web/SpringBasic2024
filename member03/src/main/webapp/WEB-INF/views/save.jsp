<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="/member03/save" method="post">
        <input type="text" name="memberEmail" placeholder="이메일" id="memberEmail" onblur="emailCheck()">
        <p id="check-result"></p>
        <input type="text" name="memberPassword" placeholder="비밀번호"><br/><br/>
        <input type="text" name="memberName" placeholder="이름"><br/><br/>
        <input type="text" name="memberAge" placeholder="나이"><br/><br/>
        <input type="text" name="memberMobile" placeholder="전화번호"><br/><br/>
        <input type="submit" value="회원가입">
    </form>
</body>
</html>

