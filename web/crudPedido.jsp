<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Pedidos ${tipoPedido}</a></li>
        <li class="breadcrumb-item active" aria-current="page">Pedido ${tipoPedido}: ${pedido.id}</li>
    </ol>
</nav>
<c:forEach items="${produtosPedido}" var="produto">

    <div class="container">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="${produto.linkImagem}"  class="img-thumbnail">
                        <div class="card-body">
                            <p class="card-text" >Produto: ${produto.nome}</p>
                            <small class="text-muted">Preço: R$ ${produto.preco}</small>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</c:forEach>

<form action="FrontController?action=ColocarCarrinhoPedido" method="post">
    <input type="hidden" name="pedidoId" value="${pedido.id}" >
    <button type="submit"  class="btn btn-primary">Colocar no Carrinho o pedido</button>
</form>

<form action="FrontController?action=ConfirmarPedido" method="post">
    <input type="hidden" name="pedidoId" value="${pedido.id}" >
    <button type="submit"  class="btn btn-primary">Confirmar o pedido</button>
</form>

<form action="FrontController?action=ProduzirPedido" method="post">
    <input type="hidden" name="pedidoId" value="${pedido.id}" >
    <button type="submit"  class="btn btn-primary">Colocar em produção o pedido</button>
</form>

<form action="FrontController?action=TransportarPedido" method="post">
    <input type="hidden" name="pedidoId" value="${pedido.id}" >
    <button type="submit"  class="btn btn-primary">Colocar em transporte o pedido</button>
</form>

<form action="FrontController?action=EntregarPedido" method="post">
    <input type="hidden" name="pedidoId" value="${pedido.id}" >
    <button type="submit"  class="btn btn-primary">Declarar como entregue o pedido</button>
</form>

    <jsp:include page="footer.jsp" />