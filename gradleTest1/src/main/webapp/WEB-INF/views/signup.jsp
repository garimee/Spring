<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.error{
	color:red;
}
</style>


</head>
<body>
		<form:form modelAttribute="memberDto" method="get" action="/submit">
			<p>
				이메일 : <form:input path="email" />
					<form:errors path="email" cssClass="error" />
			</p>
			<p>
				이름 : <form:input path="name"/>
				<form:errors path="name" cssClass="error"/>
			</p>
			<p>
				비밀번호 : <form:input type="password" path="password"/>
				<form:errors path="password" cssClass="error"/>
			</p>
			<p>
				도시 : <form:input path="city"/>
				<form:errors path="city" cssClass="error"/>
			</p>
			<p>
				주소 : <form:input path="state"/>
				<form:errors path="state" cssClass="error"/>
			</p>
			<p>
				우편번호 : <form:input path="zipCode"/>
				<form:errors path="zipCode" cssClass="error"/>
			</p>
			<button>가입</button>
		</form:form>
</body>
</html>




