<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<table border="1" style="border-collapse: collapse;">
<% %>
		<tr>
			<th> User_Id</th>
			<th>User_Name</th>
			<th>User_Email</th>
			<th>User_Password</th>
			<th>User_Branch</th>
			<th>User_Payment</th>
			<th>User_EventNames</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="user" items="${user}">
			<tr>
				<td>${user.getId()}</td>
				<td>${user.getName()}</td>
				<td>${user.getEmail()}</td>
				<td>$user.getUser_password()}</td>
				<td>${user.getBranch()}</td>
			
				<td>${user.getPayment()}</td>
				<td>${user.getEventNames()}</td>
					<td><a href="deleteUser?id=${user.getId()}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</body>
</html>