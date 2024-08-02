<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
   body{
       display:flex;
       justify-content: center;
    }
    table{
      border-collapse: collapse;
    }
    h2{
      text-align: center;
    }
    input[type=button]{
      cursor: pointer;
      width : 100px;
      height: 25px;
      margin-right: 10px;
    }
</style>
</head>
<body>
    <div class="container">
     <h2>게시글 보기</h2>
     <table width="600" border="1">
        <tr height="40">
           <td align="center" width="120">글번호</td>
           <td align="center" width="180">${rdto.num }</td>
           <td align="center" width="120">조회수</td>
           <td align="center" width="180">${rdto.readcount }</td>
        </tr>
        <tr height="40">
           <td align="center" width="120">작성자</td>
           <td align="center" width="180">${rdto.writer }</td>
           <td align="center" width="120">작성일</td>
           <td align="center" width="180">
             <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${rdto.reg_date}"/>
           </td>
        </tr>
        <tr height="40">
           <td align="center" width="120">이메일</td>
           <td align="center" colspan="3">${rdto.email }</td>
        </tr>
        <tr height="40">
           <td align="center" width="120">제목</td>
           <td align="center" colspan="3">${rdto.subject }</td>
        </tr>
        <tr height="80">
           <td align="center" width="120">글내용</td>
           <td align="center" colspan="3">${rdto.content }</td>
        </tr>
        <tr height="40">
           <td align="center" colspan="4">
              <input type="button" value="답글쓰기" onclick="location.href='/replyboard/reply?num=${rdto.num }&page=${paging.page}&ref=${rdto.ref }&re_step=${rdto.re_step}&re_level=${rdto.re_level}'">
              <input type="button" value="수정하기" onclick="location.href='/replyboard/modify?num=${rdto.num }&page=${paging.page}'">
              <input type="button" value="삭제하기" onclick="location.href='/replyboard/remove?num=${rdto.num }&ref=${rdto.ref }&page=${paging.page}'">
              <input type="button" value="목록보기" onclick="location.href='/replyboard?&page=${paging.page}'">
           </td>
        </tr>   
     </table>
 </div>
</body>
</html>