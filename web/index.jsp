<%-- 
    Document   : index
    Created on : 27/03/2019, 10:04:31
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
        <div>Tela login</div>

        <form action="FrontController?action=LogarUsuario" method="post">
            <table>

                <tr><td>Entre com seu Login</td>
                    <td><input type="text" name="txtLogin"/></td></tr>
                <tr><td>Entre com sua Senha</td>
                    <td><input type="password" name="txtSenha"/></td></tr>
                <tr>
                    <td><select  name="txtTipo">
                            <option value="Administrador">Administrador</option>
                            <option value="Cliente">Cliente</option>
                            <option value="Estabelecimento">Estabelecimento</option>
                        </select></td></tr>
                <tr><td> <input type="submit" value="Logar"/></td></tr>

            </table>
        </form>
    </body>
</html>
