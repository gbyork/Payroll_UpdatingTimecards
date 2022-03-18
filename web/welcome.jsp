<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Company name</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>    
    </head>
    <body>
        <h1>Hello ${username}</h1>
        <p>Hope you are having a great day!</p>




        <label>Would you like to...</label>
        <span> </span><br>


        <form action="timecard" method="post">
            <input type="hidden" name="option" value="list">
            <input type="submit" value="Select">
            <label> Process Timecards </label>
            <span> </span><br>
        </form>


        <form action="timecard" method="post">
            <input type="hidden" name="option" value="nope">
            <input type="submit" value="Select">
            ${NotReady}
            <label> Calculate Payroll </label>
            

            <span> </span><br>
        </form>


    </form>
    <form action="login.jsp" method="post">
        <input type="submit" value="Select">
        <label> Exit </label>
        <span> </span><br>
    </form>


</body>
</html>
