<%-- 
    Document   : login
    Created on : Jun 17, 2022, 7:05:31 PM
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
        <form action="j_security_check" method="POST">
            Username:<input type="text" name="j_username"/><br/>
            Password:<input type="password" name="j_password" /><br />
            <input type="submit" value="Login" />
            <br/>            
        </form>
        <a href="requestAccess.jsp">Request Access</a>
    </body>
</html>
