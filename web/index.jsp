<%-- 
    Document   : index
    Created on : 27/03/2019, 10:04:31
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <title>UaiFude</title>
    </head>
    <body> 
        <%--<jsp:include page="header.jsp" />--%>
        <!--<main role="main">-->
         <c:if test="${!empty mensagem}">
        <div class="alert alert-success" role="alert" >

            ${mensagem}</div>
        </c:if>

        <form class="form-signin" action="FrontController?action=LogarCliente" method="post">

            <div class="text-center mb-4">
                <img class="mb-4" src="assets/img/uaifude.png" alt="" width="72" height="72">
                <!--                <h1 class="h3 mb-3 font-weight-normal">UaiFude</h1>
                                <p>slogan</p>-->
            </div>
            <div class="form-label-group">
                <input type="text" id="txtLogin" name="txtLogin" class="form-control" required autofocus>
                <label for="txtLogin">Login</label>
            </div>

            <div class="form-label-group">
                <input type="password" id="inputPassword" name="txtSenha"  class="form-control"  required>
                <label for="inputPassword">Senha</label>
            </div>







            <button class="btn btn-lg btn-primary btn-block"  type="submit">Sign in</button>


        </form>
        <div class="form-signin">
            <a href="cadastraCliente.jsp">Não tem conta? Cadastre-se</a></br>
            <form name="CadastrarEstabelecimento" action="FrontController?action=PreparaCadastrarEstabelecimento" method="post">
                <a href="javascript:document.CadastrarEstabelecimento.submit()">Quer fazer parte da nossa rede? Cadaste sua empresa</a>    
            </form>
        </div>


        <jsp:include page="footer.jsp" />

