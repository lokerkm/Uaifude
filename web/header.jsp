<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
        <title>UAIFUDE</title>

    </head>
    <body> 

        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <img src="assets/img/uaifude.png" alt="" width="45" height="45" style="margin-right: 10px;">
            <a class="navbar-brand" href="painelInicial.jsp">UaiFude</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="painelInicial.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <c:if test = "${sessionScope.tipo == 'Cliente'}">
                            <a class="nav-link" href="perfilCliente.jsp">Minha Conta</a></c:if>
                        <c:if test = "${sessionScope.tipo == 'Estabelecimento'}">
                            <a class="nav-link" href="perfilEstabelecimento.jsp">Minha Conta</a></c:if>
                        <c:if test = "${sessionScope.tipo == 'Administrador'}">
                            <a class="nav-link" href="areaAdministrador.jsp">Area administrador</a></c:if>
                        </li>
                        <li class="nav-item">
                        <c:if test = "${sessionScope.tipo == 'Cliente'}">
                            <a class="nav-link" href="pedidosCliente.jsp">Meus Pedidos</a></c:if>
                        <c:if test = "${sessionScope.tipo == 'Estabelecimento'}">
                            <a class="nav-link" href="gerenciarProdutos.jsp">Gerenciar Produtos</a></c:if>
                        <c:if test = "${sessionScope.tipo == 'Administrador'}">
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test = "${sessionScope.tipo == 'Cliente'}">
                            <a class="nav-link" href="categorias.jsp">Categorias</a></c:if>
                        <c:if test = "${sessionScope.tipo == 'Estabelecimento'}">
                            <a class="nav-link" href="gerenciarPromocoes.jsp">Gerenciar Promoções</a></c:if>
                        <c:if test = "${sessionScope.tipo == 'Administrador'}">
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test = "${sessionScope.tipo == 'Cliente'}">
                            <a class="nav-link" href="promocoes.jsp">Promoções</a></c:if>
                        <c:if test = "${sessionScope.tipo == 'Estabelecimento'}">
                        </c:if>
                        <c:if test = "${sessionScope.tipo == 'Administrador'}">
                        </c:if>
                    </li>


                </ul>

            </div><span class="navbar-brand mb-0 h1">
                <c:if test = "${sessionScope.tipo == 'Cliente'}">
                    Bem vindo, ${sessionScope.usuario.nome}</c:if>
                <c:if test = "${sessionScope.tipo == 'Estabelecimento'}">
                    Conta estabelecimento, ${sessionScope.usuario.nome}</c:if>
                <c:if test = "${sessionScope.tipo == 'Administrador'}">
                    Adminstrador ${sessionScope.usuario.login}
                </c:if></span>
            <form action="FrontController?action=Deslogar" method="post">
                <button type="submit" class="btn btn-danger" >Logout</button></form>
        </nav>
        <main role="main">
            <div class="container">
