<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View All Cities</title>
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

        th, td {
            border: 1px solid #fff;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #ffcc00; /* Yellow */
        }

        a {
            text-decoration: none;
            color: #ffcc00; /* Yellow */
            transition: color 0.3s;
        }

        a:hover {
            color: #e6b800; /* Darker yellow on hover */
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Branch_ID</th>
            <th>Location_Name</th>
            <th>Choose your Location</th>
        </tr>
        <c:forEach var="branch" items="${branch}">
            <tr>
                <td>${branch.getId()}</td>
                <td>${branch.getLocation()}</td>
                <td><a href="location?id=${branch.getId()}">Select</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
