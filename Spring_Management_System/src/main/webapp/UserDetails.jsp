<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Details</title>
    <style>
        body {
            background-color: #041c3f;
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
            border: 1px solid #fff;
        }

        th, td {
            border: 1px solid #fff;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #ffcc00;
            color: #333;
        }

        c\\:forEach { /* Escape colon in selector */
            display: block;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Property</th>
            <th>Value</th>
        </tr>
        <tr>
            <td>ID:</td>
            <td>${user.getId()}</td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>${user.getName()}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${user.getEmail()}</td>
        </tr>
        <tr>
            <td>Payment Status:</td>
            <td>${user.getPayment()}</td>
        </tr>
        <tr>
            <td>Branch :</td>
            <td>${user.getBranch()}</td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>${user.getUser_password()}</td>
        </tr>
        <tr>
            <td>Amount Paid:</td>
            <td>${user.getCharges()}</td>
        </tr>
        <!-- Add more rows for other user properties as needed -->
    </table>
</body>
</html>
