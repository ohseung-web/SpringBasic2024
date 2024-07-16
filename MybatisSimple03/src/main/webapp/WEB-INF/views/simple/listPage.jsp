<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var beInserted = '${beInserted}';
	if (beInserted == 'true') {  // 삽입 후에 페이지는 여는 것이다.
		var insertResult = '${insertResult}';
		if (insertResult == 1) {
			alert('삽입 성공');
		} else {
			alert('삽입 실패')
		}
	}
</script>
</head>
<body>

	<div class="wrap">
		<table border="1">
			<caption>전체 : ${totalCount}개 게시물</caption>
			<thead>
				<tr>
					<td>번호</td>
					<td>작성자</td>
					<td>제목</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list}">
					<tr>
						<td colspan="4">없음</td>
					</tr>
				</c:if>
				<c:if test="${not empty list}">
					<c:forEach var="sDTO" items="${list}">
						<tr>
							<td>${sDTO.bNo}</td>
							<td>${sDTO.bWriter}</td>
							<!-- href="simpleViewPage" 는 @RequestMapping("simpleViewPage") 을 의미한다. -->
							<!-- href="simpleViewPage?bNo=${sDTO.bNo}"   bNo 파라미터를 전달한다. -->
							<td><a href="simpleViewPage?bNo=${sDTO.bNo}">${sDTO.bTitle}</a></td>
							<td>${sDTO.bDate}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="4">
						<input type="button" value="새글 작성하기" onclick="location.href='simpleInsertPage'" />
						<!-- location.href='simpleInsertPage' 는 @RequestMapping("simpleInsertPage") 을 의미한다. -->
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>
