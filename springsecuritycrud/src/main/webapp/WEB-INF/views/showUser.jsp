<%@page import="com.te.springbootsecuritycrud.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	List<User> userList = (List<User>) request.getAttribute("users");
%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div class="container m-4">
	<table class="table table-striped table-hover  table-dark rounded-corner text-light">
		<tr class="p-2">
			<td class="p-2">Name</td>
			<td class="p-2">id</td>
			<td class="p-2">Address</td>

		</tr>




		<%
			if (userList != null) {
		%>

		<%
			for (User user : userList) {
		%>
		<tr class="p-2">
			<td class="p-2"><%=user.getUserName()%></td>
			<td class="p-2"><%=user.getUserId()%></td>
			<td class="p-2"><%=user.getUserAddress()%>
		</tr>

		<%
			}
		%>
		<%
			}
		%>
	</table>
	</div>
</body>
</html>