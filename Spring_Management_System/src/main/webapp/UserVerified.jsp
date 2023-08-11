<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
        margin: 10px;
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
    <button class="btn" onclick="location.href='UserUpdate'">Update your Profile</button>
    <button class="btn" onclick="location.href='UserViewById'">View Your Details</button>
    <button class="btn" onclick="location.href='SelectYourlocation'">Select Your branch</button>
</body>
</html>
