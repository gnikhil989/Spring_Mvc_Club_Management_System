<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            margin-top: 20px;
        }

        td {
            border: 1px solid #fff;
            padding: 8px;
            text-align: center;
        }

        c\\:forEach { /* Escape colon in selector */
            display: block;
        }
    </style>
</head>
<body>
    <table>
        <c:forEach var="users" items="${user}">
            <tr>
                <td>${users.getId()}</td>
                <td>${users.getname()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
