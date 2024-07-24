<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>detail.jsp</title>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<style type="text/css">
   table{
      border-collapse: collapse;
   }
   table tr td {
      height: 30px;
      text-align: center;
   }
</style> 
</head>
<body>
    <table border="1" width="300">
        <tr>
            <th>no</th>
            <td>${bdto.id}</td>
        </tr>
        <tr>
            <th>writer</th>
            <td>${bdto.boardWriter}</td>
        </tr>
        <tr>
            <th>date</th>
            <td>${bdto.boardCreatedTime}</td>
        </tr>
        <tr>
            <th>hits</th>
            <td>${bdto.boardHits}</td>
        </tr>
        <tr>
            <th>title</th>
            <td>${bdto.boardTitle}</td>
        </tr>
        <tr>
            <th>contents</th>
            <td>${bdto.boardContents}</td>
        </tr>
    </table>
    <br>
    <button type="button" onclick="listFn()">목록</button>
    <button type="button" onclick="updateFn()">수정</button>
    <button type="button" onclick="deleteFn()">삭제</button>
    
    <div class="comment">
       <input type="text" id="commentWriter" placeholder="작성자"><br>
       <input type="text" id="commentContents" placeholder="내용"><br>
       <button id="comment-write-btn" onclick="commentWrite()">댓글작성</button>
    </div>

<div id="comment-list">
    <table>
        <tr>
            <th>댓글번호</th>
            <th>작성자</th>
            <th>내용</th>
            <th>작성시간</th>
        </tr>
        <c:forEach items="${commentList}" var="comment">
            <tr>
                <td>${comment.id}</td>
                <td>${comment.commentWriter}</td>
                <td>${comment.commentContents}</td>
                <td>${comment.commentCreatedTime}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script>
    const page = '${page}';
    const listFn = () => {
       // const page = '${page}';
        location.href = "/codingboard/paging?page=" + page;
    }
    const updateFn = () => {
        const id = '${bdto.id}';
        location.href = "/codingboard/update?id=" + id + "&page="+ page;
    }
    const deleteFn = () => {
        const id = '${bdto.id}';
        location.href = "/codingboard/delete?id=" + id+ "&page="+ page;;
    }

    /* 댓글작성 */
    const commentWrite = () => {
        const writer = document.getElementById("commentWriter").value;
        const contents = document.getElementById("commentContents").value;
        const board = '${board.id}';
        $.ajax({
            type: "post",
            url: "/comment/save",
            data: {
                commentWriter: writer,
                commentContents: contents,
                boardId: board
            },
            dataType: "json",
            success: function(commentList) {
                console.log("작성성공");
                console.log(commentList);
                let output = "<table>";
                output += "<tr><th>댓글번호</th>";
                output += "<th>작성자</th>";
                output += "<th>내용</th>";
                output += "<th>작성시간</th></tr>";
                for(let i in commentList){
                    output += "<tr>";
                    output += "<td>"+commentList[i].id+"</td>";
                    output += "<td>"+commentList[i].commentWriter+"</td>";
                    output += "<td>"+commentList[i].commentContents+"</td>";
                    output += "<td>"+commentList[i].commentCreatedTime+"</td>";
                    output += "</tr>";
                }
                output += "</table>";
                document.getElementById('comment-list').innerHTML = output;
                document.getElementById('commentWriter').value='';
                document.getElementById('commentContents').value='';
            },
            error: function() {
                console.log("실패");
            }
        });
    }    
</script>
</html>