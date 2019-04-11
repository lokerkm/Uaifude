<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Lista de Clientes</li>
    </ol>
</nav>
<div class="row">
<c:forEach items="${clientes}" var="cliente">

    <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
            <img src="https://i.imgur.com/zPcHRDK.png"  class="img-thumbnail">
            <div class="card-body">
                <p class="card-text" >${cliente.nome}</p>               
                <form action="FrontController?action=PrepararCliente" method="post">
                    <input type="hidden" name="clienteId" value="${cliente.getClienteId()}" >
                    <input type="hidden" name="acaoCliente" value="Ler" >
                    <button type="submit"  class="btn btn-primary">LER</button>
                </form>

                <form action="FrontController?action=PrepararCliente" method="post">
                    <input type="hidden" name="clienteId" value="${cliente.getClienteId()}" >
                    <input type="hidden" name="acaoCliente" value="Editar" >
                    <button type="submit"  class="btn btn-primary">EDITAR</button>
                </form>

                <form action="FrontController?action=PrepararCliente" method="post">
                    <input type="hidden" name="clienteId" value="${cliente.getClienteId()}" >
                    <input type="hidden" name="acaoCliente" value="Excluir" >
                    <button type="submit"  class="btn btn-primary">APAGAR</button>
                </form>
            </div>
        </div>

    </div>


</c:forEach>
</div>

<jsp:include page="footer.jsp" />
