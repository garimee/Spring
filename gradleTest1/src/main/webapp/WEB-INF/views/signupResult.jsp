<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>  signupResult.jsp </title>
</head>
<body>
	<p>이메일 : ${memberDto.email } </p>
	<p> 이름 : ${memberDto.name }</p>
	<p> 비밀번호 : ${memberDto.password }</p>
	<p> 도시 : ${memberDto.city }</p>
	<p> 주소 : ${memberDto.state }</p>
	<p> 우편번호 : ${memberDto.zipCode }</p>

</body>
</html>