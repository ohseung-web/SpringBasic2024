<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/codingboard/update" method="post" name="updateForm">
        <input type="hidden" name="id" value="${bdto.id}" readonly><br>
        <input type="text" name="boardWriter" value="${bdto.boardWriter}" readonly><br>
        <input type="text" name="boardPass" id="boardPass" placeholder="비밀번호"><br>
        <input type="text" name="boardTitle" value="${bdto.boardTitle}"><br>
        <textarea name="boardContents" cols="30" rows="10">${bdto.boardContents}</textarea><br>
        <input type="button" value="수정" onclick="updateReqFn()">
    </form>
</body>
<script>
    const updateReqFn = () => {
        const passInput = document.getElementById("boardPass").value;
        const passDB = '${bdto.boardPass}';
        if (passInput == passDB) {
            document.updateForm.submit();
        } else {
            alert("비밀번호가 일치하지 않습니다!!");
        }
    }
</script>
</html>