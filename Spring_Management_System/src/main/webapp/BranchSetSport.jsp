<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Set Sport!</h1>
	<form:form action="SetSportBranchform" modelAttribute="eventName">
   
    Sports name:<form:input path="sport_name"/> <br>
    Price :<form:input path="charges"/><br>
    <form:button>Save</form:button>
</form:form>

</body>
</html>