<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>  signupResult.jsp </title>
</head>
<body>
	<c:forEach var="row" items=${list}>
		<p>이메일 : ${row.email } </p>
		<p> 이름 : ${row.name }</p>
		<p> 비밀번호 : ${row.password }</p>
		<p> 도시 : ${row.city }</p>
		<p> 주소 : ${row.state }</p>
		<p> 우편번호 : ${row.zipCode }</p>
	</c:forEach>
</body>
</html>