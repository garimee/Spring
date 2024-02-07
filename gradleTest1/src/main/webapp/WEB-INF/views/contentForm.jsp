<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<form:form modelAttribute="contentDto" method="get" action="/create">
			작성자 : <form:input path="writer"/> 
				<form:errors path="writer" style="color:red;"/>
			<br>
		
			내용 : <form:input path="content"/> 
				<form:errors path="content" style="color:red;"/>
			<br>
			<button> 작성 </button>
		</form:form>
		
</body>
</html>



