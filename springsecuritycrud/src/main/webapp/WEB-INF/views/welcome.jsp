<%@page import="com.te.springbootsecuritycrud.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	User user = (User) request.getAttribute("data");
%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>


	<div class="container mx-auto">
		<form class="form-inline" action="./seeUserById" method="post">
			<div class="form-group p-2">
				<label for="userId" class="p-2">Enter User Id</label> <input
					type="number" class="form-control" name="id" id="userId">
			</div>

			<button type="submit" class="btn btn-primary">Search User</button>
		</form>



	</div>

	<%
		if (user != null) {
	%>
	<div class="container">
	<table class="table border table-dark text-light">
		<tr>
			<td class="p-2">id</td>
			<td class="p-2">Name</td>
			<td class="p-2">Address</td>
		</tr>
		<tr>
			<td class="p-2"><%=user.getUserId()%></td>
			<td class="p-2"><%=user.getUserName()%></td>
			<td class="p-2"><%=user.getUserAddress()%></td>
		</tr>

	</table>
	</div>


	<%
		}
	%>

</body>
</html>