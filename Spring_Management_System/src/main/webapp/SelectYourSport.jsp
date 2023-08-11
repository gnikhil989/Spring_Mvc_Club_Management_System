<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Your Sports</title>
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

    td input[type="radio"] {
        margin: 0;
        padding: 0;
    }
.center-align {
        display: flex;
        justify-content: center;
    }
    input[type="submit"] {
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #ffcc00; /* Yellow */
        color: #333; /* Darker yellow */
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s, color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #e6b800; /* Darker yellow on hover */
        color: #fff; /* White on hover */
    }
</style>
</head>
<body>
    <h1>Select Your Sports</h1>
    <form action="Selected_Sport_And_Time" method="post">
        <table border="1" style="border-collapse: collapse;">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Morning</th>
                <th>Afternoon</th>
                <th>Evening</th>
                <th>24*7</th>
            </tr>
            <c:forEach var="eventName" items="${eventNames11}">
                <c:if test="${eventName.branch ne null}">
                    <tr>
                        <td>${eventName.getId()}</td>
                        <td>${eventName.getSport_name()}</td>
                        
                        <td>
                            <input type="radio" name="selectedTimeslot_${eventName.getId()}" value="Morning" data-charge="${eventName.charges}" />
                            ${eventName.timeslot1} / ${10}
                            <br>
                            Charge: ${eventName.charges} Rs
                        </td>
                        <td>
                            <input type="radio" name="selectedTimeslot_${eventName.getId()}" value="Afternoon" data-charge="${eventName.charges}" />
                            ${eventName.timeslot2} / ${10}
                            <br>
                            Charge: ${eventName.charges} Rs
                        </td>
                        <td>
                            <input type="radio" name="selectedTimeslot_${eventName.getId()}" value="Evening" data-charge="${eventName.charges}" />
                            ${eventName.timeslot3} / ${10}
                            <br>
                            Charge: ${eventName.charges} Rs
                        </td>
                        <td>
                            <input type="radio" name="selectedTimeslot_${eventName.getId()}" value="24*7" data-charge="${eventName.charges*4}" />
                            ${eventName.timeslot4} / ${10}
                            <br>
                            Charge: ${(eventName.charges* 4)} Rs
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
        <br>
         <div class="center-align">
            <input type="submit" name="submitButton" value="Go to Payment Options">
        </div>
    </form>
</body>
</html>
