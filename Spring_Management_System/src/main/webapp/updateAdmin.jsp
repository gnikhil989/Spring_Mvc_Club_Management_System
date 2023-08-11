<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Admin</title>
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

    h1 {
        font-size: 36px;
        color: #ff3333; /* Red */
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        margin-bottom: 20px;
    }

    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    form input {
        margin: 5px 0;
        padding: 5px;
        border: none;
        border-radius: 3px;
    }

    form button {
        margin-top: 10px;
        padding: 10px 20px;
        background-color: #ffcc00; /* Yellow */
        color: #333; /* Darker yellow */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, color 0.3s;
    }

    form button:hover {
        background-color: #e6b800; /* Darker yellow on hover */
        color: #fff; /* White on hover */
    }
</style>
</head>
<body>
    <h1>Update Admin!</h1>
    <form action="updateAdminform" method="post">
        ID: <input type="text" name="id" readonly><br>
        Name: <input type="text" name="name"><br>
        Email: <input type="text" name="email"><br>
        <button type="submit">Save</button>
    </form>
</body>
</html>
