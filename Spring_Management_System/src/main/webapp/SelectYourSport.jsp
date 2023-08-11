<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Select Your Sports</title>
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
                            Charge: ${(eventName.charges* 4)} Rs <!-- Display charge as multiple of 4 -->
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table> <br>
        <input type="submit" name="submitButton" value="Go to Payment Options" />
    </form>
</body>
</html>
