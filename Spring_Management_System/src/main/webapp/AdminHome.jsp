<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Fit Application</title>
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

    .btn {
        display: inline-block;
        padding: 10px 20px;
        margin: 5px 0;
        background-color: #ffcc00; /* Yellow */
        color: #333; /* Darker yellow */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, color 0.3s;
        text-decoration: none;
        text-align: center;
    }

    .btn:hover {
        background-color: #e6b800; /* Darker yellow on hover */
        color: #fff; /* White on hover */
    }
</style>
</head>
<body>
    <h1>Welcome to Fit Application</h1>
    <a class="btn" href="adminload">Create Admin</a>
    <a class="btn" href="updateAdmin">Update Admin</a>
    <a class="btn" href="deleteAdmin">Delete Admin</a>
    <a class="btn" href="setBranch">Set Branch</a>
    <a class="btn" href="setSport">Set Sport</a>
    <a class="btn" href="ViewAllBranch">View All Branch</a>
    <a class="btn" href="ViewAllUser">View All Users</a>
</body>
</html>
