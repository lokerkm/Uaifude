<%-- 
    Document   : painelInicial
    Created on : 27/03/2019, 09:46:10
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${sessionScope.usuario}</h1>
     
        <h1>${sessionScope.usuario.email}</h1>
       
        <h1>${sessionScope.usuario.login}</h1>
        <h1>${sessionScope.tipo}</h1>
       
    </body>
</html>
