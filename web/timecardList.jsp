<%-- 
    Document   : timecardList
    Created on : Mar 9, 2022, 9:42:14 AM
    Author     : rando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Timecard List Page</title>
    </head>
    <body>
        
        <h1>List Timecards</h1>
        <h2> ${SalaryMsg} </h2>
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
                    <td class = "right">${card.hoursWorked}</td>
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
        
        <h3> </h3>
        <form action="timecard" method="post">
            <input type="hidden" name="option" value="add">
            <input type="submit" value="Add">
            
           
        </form>
        <h4> Or... </h4>
        <form action="timecard" method="post">
            <input type="hidden" name="option" value="delete">
            <input type="submit" value="Delete">
            
           
        </form>
    </body>
</html>
