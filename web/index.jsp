<%-- 
    Document   : index
    Created on : 27/03/2019, 10:04:31
    Author     : Vitor
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body> 
        <%--<jsp:include page="header.jsp" />--%>
        <!--<main role="main">-->


        <form class="form-signin" action="FrontController?action=LogarUsuario" method="post">

            <div class="text-center mb-4">
                <!--<img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">-->
                <h1 class="h3 mb-3 font-weight-normal">UaiFude</h1>
                <p>slogan</p>
            </div>
            <div class="form-label-group">
                <input type="text" id="txtLogin" name="txtLogin" class="form-control" required autofocus>
                <label for="txtLogin">Login</label>
            </div>

            <div class="form-label-group">
                <input type="password" id="txtSenha" name="txtSenha"  class="form-control"  required>
                <label for="txtSenha">Senha</label>
            </div>
            
            <div class="form-label-group">
                <select class="custom-select" name="txtTipo">
                            <option value="Administrador">Administrador</option>
                            <option value="Cliente">Cliente</option>
                            <option value="Estabelecimento">Estabelecimento</option>
                        </select>
            </div>
            
            

            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

        </form>
        
        <jsp:include page="footer.jsp" />

