<%-- 
    Document   : requestAccess
    Created on : Jun 19, 2022, 6:50:44 PM
    Author     : letso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="./RequestAccessServlet" method="POST">
            Username:<input type="text" name="username"/><br/>
            Password:<input type="password" name="password" /><br />
            <input type="submit" value="Submit" />
            <br/>            
        </form>
    </body>
</html>
