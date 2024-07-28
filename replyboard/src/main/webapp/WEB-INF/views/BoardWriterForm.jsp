<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
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
    table tr td input{
       width:400px;
       height: 25px;
       margin-left: 20px;
    }
    table tr td input[type=button],
    table tr td input[type=reset]{
       width: 80px;
       cursor: pointer;
       margin-left:0;
    }
    textarea{
       margin-left: 20px;
    }
</style>
</head>
<body>
   <div class="container">
    <h2> 게시글 쓰기 </h2>
    <form action="/replyboard/register" method="post" name="formname">
       <table width="600" border="1">
          <tr height="40">
             <td align="center" width="150">작성자</td>
             <td width="450"><input type="text" name="writer"></td>
          </tr>
          <tr height="40">
             <td align="center" width="150">제목</td>
             <td width="450"><input type="text" name="subject" class="b_subject"></td>
          </tr>
          <tr height="40">
             <td align="center" width="150">이메일</td>
             <td width="450"><input type="email" name="email"></td>
          </tr>
          <tr height="40">
             <td align="center" width="150">비밀번호</td>
             <td width="450"><input type="password" name="password"></td>
          </tr>
          <tr height="40">
             <td align="center" width="150">글내용</td>
             <td width="450"><textarea rows="10" cols="55" name="content" class="b_contents"></textarea>
          </tr>
          <tr height="40">
             <td align="center" colspan="2">
                <input type="button" onclick="BoardWriteException();" value="글쓰기" >&nbsp;&nbsp;
                <input type="reset"  value="다시작성">&nbsp;&nbsp;
                <input type="button" onclick="location.href='/replyboard/'" value="목록보기">
              </td>   
         </tr>
    </table>
 </form>
  </div>
  
  <script>
		function BoardWriteException(){
			let formname = document.formname
			let sub = document.getElementsByClassName("b_subject")[0];
			let cont = document.getElementsByClassName("b_contents")[0];
			if(sub.value==""){ // sub.value == null은 null도 값으로 인식하여 공백이 입력되기때문에 !sub.value으로 또는 sub.value=""으로 값이 아니면으로 조건을 지정한다.
				alert("제목을 입력하세요");
				sub.focus();
				return;
			}
			if(!cont.value){
				alert("내용을입력하세요");
				cont.focus();
				return;
			}
			formname.submit();
		}
	</script>
</body>
</html>