<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.member_dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	member_dto dto=(member_dto)request.getAttribute("DTO");
	%>
	<form action="update" method="post">
		<p>ID : <input type="text" name="id" value="<%= dto.getId()%>" readonly>
		<p>PW : <input type="text" name="pw" value="<%= dto.getPw()%>">
		<p>Age : <input type="text" name="age" value="<%= dto.getAge()%>">
		<p><input type="submit" value="수정">
	</form>
</body>
</html>