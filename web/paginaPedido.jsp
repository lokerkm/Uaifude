<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item"><a href="pedidosCliente.jsp">Meus pedidos</a></li>
        <li class="breadcrumb-item active" aria-current="page">Pedido ${pedido.id}</li>
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
                            <small class="text-muted">Pedido numero: ${pedido.id}</small>
                            <small class="text-muted">${pedido.estado.estadoString()}</small>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</c:forEach>

<jsp:include page="footer.jsp" />