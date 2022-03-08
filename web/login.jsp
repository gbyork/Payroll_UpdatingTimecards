
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Payroll System</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
     
<body>
    <h2 type="alert" value="${msg}"> </h2><br>
    <h1> Login Screen</h1>
    
    <form action="login" method="post">
        
       
     <input type="hidden" name="option" value="Add">        
        <label class="pad_top">UserID:</label>
        <input type="text" name="UserID" value="${UserID}"><br>
        <label class="pad_top">Password:</label>
        <input type="Password" name="Password" value="${Password}"><br>
        
        <input type="submit" value="login" class="margin_left">    
        <h2 type="error" value="${msg}"> </h2><br>
    </form>
        
   
</body>
</html>
