<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        background-color: #041c3f; /* Dark blue background color */
        font-family: 'Arial', sans-serif;
        color: #fff;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
    }

    table {
        border-collapse: collapse;
        border: 1px solid #fff;
        width: 100%;
        max-width: 800px;
        margin-top: 20px;
    }

    th, td {
        border: 1px solid #fff;
        padding: 8px;
        text-align: center;
    }

    th {
        background-color: #ffcc00; /* Yellow */
        color: #333; /* Darker yellow */
    }

    a.btn {
        display: inline-block;
        padding: 5px 10px;
        background-color: #ffcc00; /* Yellow */
        color: #333; /* Darker yellow */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, color 0.3s;
        text-decoration: none;
    }

    a.btn:hover {
        background-color: #e6b800; /* Darker yellow on hover */
        color: #fff; /* White on hover */
    }
</style>
</head>
<body>
    <table>
        <tr>
            <th> User_Id</th>
            <th>User_Name</th>
            <th>User_Email</th>
            <th>User_Password</th>
            <th>User_Branch</th>
            <th>User_Payment</th>
           
            <th>Delete</th>
        </tr>
        <c:forEach var="user" items="${user}">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getUser_password()}</td>
                <td>${user.getBranch()}</td>
                <td>${user.getPayment()}</td>
               
                <td><a class="btn" href="deleteUser?id=${user.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>