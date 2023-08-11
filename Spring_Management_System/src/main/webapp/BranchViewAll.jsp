<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
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
        border: 1px solid #fff;
        margin-top: 20px;
        color: #fff;
    }

    th, td {
        padding: 10px;
        border: 1px solid #fff;
    }

    th {
        background-color: #ffcc00; /* Yellow */
        color: #333; /* Darker yellow */
    }

    tr:nth-child(even) {
        background-color: #1c2a4e; /* Darker blue for even rows */
    }

    tr:nth-child(odd) {
        background-color: #041c3f; /* Dark blue for odd rows */
    }
</style>
</head>
<body>
    <table>
        <tr>
            <th>Branch_ID</th>
            <th>Location_Name</th>
        </tr>
        <c:forEach var="branch" items="${branch}">
            <tr>
                <td>${branch.getId()}</td>
                <td>${branch.getLocation()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
