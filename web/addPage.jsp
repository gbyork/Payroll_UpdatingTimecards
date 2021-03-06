<%-- 
    Document   : addPage
    Created on : Mar 25, 2022, 11:30:38 AM
    Author     : rando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                            <input type="hidden" name="timecardID" value="<c:out value='${card.Date}'/>">
                            <input type="submit" value="Edit">
                        </form>
                    </td>
                </tr>
            </c:forEach>  
        </table>
         <form action="timecard" method="post">
            <input type="hidden" name="option" value="add">
            <input type="submit" value="Add">
            
           
        </form>
    </body>
</html>
