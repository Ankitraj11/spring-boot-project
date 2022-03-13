<%@page import="org.hibernate.Incubating"%>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
	String errorMsg = (String) request.getAttribute("error");
%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>

	<h1><%=msg%></h1>



	<%
		}
	%>
	<%
		if (errorMsg != null && !errorMsg.isEmpty()) {
	%>

	<h1><%=errorMsg%></h1>



	<%
		}
	%>


	<form action="./addUser" method="post">
		<div class="container text-align-center">
		<div class="form-group">
			<label for="userName">User Name:</label> <input type="text"
				class="form-control" placeholder="Enter User User Name"
				id="userName" name="userName">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" placeholder="Enter password" id="password"
				name="password">
		</div>
		<div class="form-group">
			<label for="address">Address:</label> <input type="text"
				class="form-control" placeholder="Enter User Address" id="address"
				name="userAddress"> <input type="hidden"
				name="userRole" value="ROLE_USER">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>




</body>
</html>