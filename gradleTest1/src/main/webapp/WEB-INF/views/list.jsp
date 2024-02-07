<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><a href="/writeForm">글 작성</a></p>
	
	<table>
		<tr>
			<th>번호</th>  <th>작성자</th>
			<th>제목</th>  <th>삭제</th>
		</tr>
		
		<c:choose>
			<c:when test="${list == null}">
				<tr><td colspan="4"><h3>등록된 글이 없습니다</h3></td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="row" items="${list}">
					<tr>
						<td>${row.id }</td>
						<td>${row.writer }</td>
						<td><a href="/view/${row.id}">${row.title }</a></td>
						<td><a href="/delete/${row.id }" >X</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>