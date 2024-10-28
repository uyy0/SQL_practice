<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="dto.member_dto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<member_dto> arr =(ArrayList<member_dto>)request.getAttribute("list");
	%>
	
	<h1>User List</h1>
	<a href="/login_crud">Home</a>
	<table>
		<tr>
			<td>Id</td>
			<td>Password</td>
			<td>Age</td>
			<td>Update</td>
			<td>Delete</td>
		</tr>
		<%
			for(int i=0; i<arr.size(); i++){
				member_dto dto=arr.get(i);
				String id = dto.getId();
				String pw = dto.getPw();
				int age = dto.getAge();
			
		%>
		<tr>
			<td><%=id%></td>
			<td><%=pw%></td>
			<td><%=age%></td>
			<td><a href="update?id=<%=id%>">Update</a></td>
			<td><a href="delete?id=<%=id%>">Delete</a></td>
		</tr>
		<%} %>
		
	</table>
</body>
</html>