<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation Page</title>
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

    p {
        font-size: 18px;
        margin: 10px 0;
    }

    form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    form input[type="submit"] {
        margin-top: 10px;
        padding: 10px 20px;
        background-color: #ffcc00; /* Yellow */
        color: #333; /* Darker yellow */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, color 0.3s;
    }

    form input[type="submit"]:hover {
        background-color: #e6b800; /* Darker yellow on hover */
        color: #fff; /* White on hover */
    }
</style>
</head>
<body>
    <h1>Confirmation Page</h1>
    
    <!-- Display the user's name -->
    <p>Hello <c:out value="${user.name}" />,</p>
    
    <!-- Display the total payment amount -->
    <p>Total Payment Amount: $<c:out value="${charges}" /></p>
    
    <!-- Payment form -->
    <form action="makePayment" method="post">
        <input type="hidden" name="amount" value="${charges}" />
        <input type="submit" value="Pay Now">
    </form>
    
    <!-- You can add more content or formatting here as needed -->
</body>
</html>
