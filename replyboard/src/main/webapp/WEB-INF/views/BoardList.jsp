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
    a{
      text-decoration: none
    }
    p{
       text-align: center;
    }
    .pageing{
       width : 200px;
       text-align: center;
       margin : 10px auto;
    }
    #subject{
       padding-left: 10px;
    }
    .paging{
      width : 200px;
       text-align: center;
       margin : 10px auto;
    }
</style>
</head>
<body>
    
<c:if test="${msg != null && msg eq '0'}">
  <script type="text/javascript">
     alert("비밀번호를 확인하세요");
  </script>  
</c:if>

<div class="container">
	<h2>게시글 보기</h2>
	<table width="700" border="1">
		<tr height="40">
			<td colspan="5" align="right">
				<button type="button" onclick="location.href='/replyboard/register'">글쓰기</button>
			</td>
		</tr>
		<tr height="40">
			<td width="50" align="center">번호</td>
			<td width="320" align="center">제목</td>
			<td width="100" align="center">작성자</td>
			<td width="150" align="center">작성일자</td>
			<td width="80" align="center">조회수</td>
		</tr>
		
		<c:set var="number" value="${paging.number}" />
		<c:forEach var="rdto" items="${boardList}">
		       <!--  number는 최신글 순서로 화면에 출력하는 변수이다. 고로 number는 1씩 감소하여야 하기 때문에 number 변수를 작성한다.  -->
			  <tr height="40">
				<td width="50" align="center">${number}</td>
				<!-- 제목은 Re_step에 따라서 앞 부분에 들여쓰기를 하여야 한다.  -->
				<!-- re_step이 1이면 들여쓰기를 할 필요가 없기때문에 re_step >1 클때 들여쓰기 하라고 조건을 지정한다.  -->
				<td width="320" align="left" id="subject">
				   <c:if  test="${rdto.re_step > 1 }">
						<c:forEach var="j" begin="1" end="${(rdto.re_step-1)*3}">
                          &nbsp;
                        </c:forEach>
				   </c:if>
				   
				   <!--답글 boardAvailable == 0이면 삭제된 게시물입니다 출력 코드  -->
				   <c:if test="${rdto.re_level>1}">
	                  <c:if test="${rdto.boardAvailable==1}">
	                    <a href="/replyboard/detail?num=${rdto.num}&page=${paging.page}"><c:out value='${rdto.subject}'/></a>
	                  </c:if>
		              <c:if test="${rdto.boardAvailable==0}">
		               <a href="javascript:goMsg()">[RE]삭제된 게시물입니다.</a>
		              </c:if>
	               </c:if>
	               
	               <!--원글 boardAvailable == 0이면 삭제된 게시물입니다 출력 코드  -->
		            <c:if test="${rdto.re_level==1}">
		              <c:if test="${rdto.boardAvailable==1}">
		                <a href="/replyboard/detail?num=${rdto.num}&page=${paging.page}"><c:out value='${rdto.subject}'/></a>
		              </c:if>
		              <c:if test="${rdto.boardAvailable==0}">
		                <a href="javascript:goMsg()">삭제된 게시물입니다.</a>
		              </c:if>
		            </c:if>
	             
				  <%--  <a href="/replyboard/detail?num=${rdto.num}"> ${rdto.subject}</a> --%>
				</td>
				 
				<td width="100" align="center">${rdto.writer}</td>
				<td width="150" align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${rdto.reg_date}"/></td>
				<td width="80" align="center">${rdto.readcount}</td>
			 </tr>
			<!-- number-1을 이용하여 1씩 감소한다.  number=10이면 다음 number=9가된다 -->
			<c:set var="number" value="${number - 1 }" />
		</c:forEach>
    </table>
	  <div class="paging">
	    <!-- 게시판의 글이 존재하지 않으면 페이징처리를 하지 않는다. -->
		<c:if test="${paging.number ne 0}"> 
	    <c:choose>
	        <%-- 현재 페이지가 1페이지면 이전 글자만 보여줌 --%>
	        <c:when test="${paging.page<=1}">
	            <span>[이전]</span>
	        </c:when>
	        <%-- 1페이지가 아닌 경우에는 [이전]을 클릭하면 현재 페이지보다 1 작은 페이지 요청 --%>
	        <c:otherwise>
	            <a href="/replyboard?page=${paging.page-1}">[이전]</a>
	        </c:otherwise>
	    </c:choose>
	
	    <%--  for(int i=startPage; i<=endPage; i++)      --%>
	    <c:forEach begin="${paging.startpage}" end="${paging.endPage}" var="i" step="1">
	        <c:choose>
	            <%-- 요청한 페이지에 있는 경우 현재 페이지 번호는 텍스트만 보이게 --%>
	            <c:when test="${i eq paging.page}">
	                <span>${i}</span>
	            </c:when>
	
	            <c:otherwise>
	                <a href="/replyboard?page=${i}">${i}</a>
	            </c:otherwise>
	        </c:choose>
	    </c:forEach>
	
	    <c:choose>
	        <c:when test="${paging.page>=paging.maxPage}">
	            <span>[다음]</span>
	        </c:when>
	        <c:otherwise>
	                <a href="/replyboard?page=${paging.page+1}">[다음]</a>
	        </c:otherwise>
	    </c:choose>
	  </c:if>    
	</div>
	<%-- <div class="pageing">
		<!-- 페이지 카운터링 소스 작성 [1] [2] [3] [다음] ....... -->

		<!-- [이전]이라는 링크를 만들건지 파악-->
		<c:if test="${startPage > pageBlock }">
			<a href="BoardListCon.do?pageNum=${startPage - pageBlock}"> [이전]
			</a>
		</c:if>

		<!-- 페이징 처리 -->
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="BoardListCon.do?pageNum=${i}"> [${i}] </a>
		</c:forEach>

		<!-- [다음]이라는 페이지를 만들건지 파악 -->
		<c:if test="${endPage < pageCount }">
			<a href="BoardListCon.do?pageNum=${startPage + pageBlock}"> [다음]
			</a>
		</c:if>
	</div> --%>
	
</div>
    
</body>
<script type="text/javascript">
	function goMsg(){
		 alert("삭제된 게시물입니다."); 
	}
</script>
</html>