<%-- 
    Document   : timecard
    Created on : Mar 21, 2022, 9:31:25 AM
    Author     : rando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="styles/main.css" type="text/css"/> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  </title>
    </head>
    <body>
        <h1>Editing Timecard</h1>
        <table>
            <tr>
                <th>Employee</th>
                <th class="right">Employee</th>
                <th class="right">Hours</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach var="card" items="${timecards}">
                <tr>
                    <td>${card.employeeID}</td>
                    <td>
                    <form action="" method="post">
                    
                    <input type="hidden" name="option" value="update">
                    <input type=text name="hoursWorked" value="<c:out value='${card.hoursWorked}'/>" id="hoursWorked">
                    <input type=text name="overtimeHours" value="<c:out value='${card.overtimeHours}'/>" id="overtimeHours">
                    <input type="submit" value="Update">
                    </form>
                    </td>
                    <td>
                        <form action="timecard" method="post">
                            <input type="hidden" name="option" value="edit">
                            
                            <input type="hidden" name="timecardID" value="<c:out value='${card.ID}'/>">
                            <input type="submit" value="Edit">
                        </form>
                    </td>
                </tr>
            </c:forEach>  
        </table>
        <h1>    </h1>
        <form action="timecard" method="post">
            <input type="hidden" name="option" value="cancel">
            <input type="submit" value="Cancel">
        </form>
    </body>
</html>

