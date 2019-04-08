<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Lista de Pedidos</li>
    </ol>
</nav>

<c:forEach items="${pedidos}" var="pedido">

    <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
            <img src="https://i.imgur.com/E6aOelI.png"  class="img-thumbnail">
            <div class="card-body">
                <p class="card-text" >Pedido número: ${pedido.id}</p>
                <small class="text-muted">Valor: R$ ${pedido.total}</small>
                <small class="text-muted">Cliente: R$ ${pedido.cliente.nome}</small>
                <small class="text-muted">${pedido.estado.estadoString()}</small>
                <form action="FrontController?action=PrepararPedido" method="post">
                    <input type="hidden" name="pedidoId" value="${pedido.id}" >
                    <input type="hidden" name="acaoPedido" value="Ler" >
                    <button type="submit"  class="btn btn-primary">LER</button>
                </form>

                <form action="FrontController?action=PrepararPedido" method="post">
                    <input type="hidden" name="pedidoId" value="${pedido.id}" >
                    <input type="hidden" name="acaoPedido" value="Editar" >
                    <button type="submit"  class="btn btn-primary">EDITAR</button>
                </form>

                <form action="FrontController?action=PrepararPedido" method="post">
                    <input type="hidden" name="pedidoId" value="${pedido.id}" >
                    <input type="hidden" name="acaoPedido" value="Excluir" >
                    <button type="submit"  class="btn btn-primary">APAGAR</button>
                </form>
            </div>
        </div>

    </div>


</c:forEach>

<jsp:include page="footer.jsp" />
