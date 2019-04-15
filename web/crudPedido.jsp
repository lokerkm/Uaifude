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
<div class="container">
    <div class="container">
        <div class="row">
            <c:forEach items="${produtosPedido}" var="produto">


                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="${produto.linkImagem}"  class="img-thumbnail">
                        <div class="card-body">
                            <p class="card-text" >Produto: ${produto.nome}</p>
                            <c:if test="${produto.promocao.getNome() == 'SemPromocao'}">
                                    <small class="text-muted">Preço: R$ ${produto.preco}</small></c:if>

                                <c:if test="${produto.promocao.getNome() != 'SemPromocao'}">
                                    <small class="text-muted">Preço: De:${produto.preco}
                                        Por:${produto.getPrecoPosPromocao()}</small></c:if>

                        </div>
                    </div>
                </div>


            </c:forEach>
            <c:if test="${acaoPedido !='LerPedido'}">
                <div class="col-md-4 btnpedido">

                    <form action="FrontController?action=MudarEstadoPedido" method="post">
                        <input type="hidden" name="pedidoId" value="${pedido.id}" >
                        <input type="hidden" name="acao" value="Carrinho" >
                        <button type="submit"  class="btn btn-primary">Colocar no Carrinho o pedido</button>
                    </form>

                    <form action="FrontController?action=MudarEstadoPedido" method="post">
                        <input type="hidden" name="pedidoId" value="${pedido.id}" >
                        <input type="hidden" name="acao" value="Confirmado" >
                        <button type="submit"  class="btn btn-primary">Confirmar o pedido</button>
                    </form>

                    <form action="FrontController?action=MudarEstadoPedido" method="post">
                        <input type="hidden" name="pedidoId" value="${pedido.id}" >
                        <input type="hidden" name="acao" value="Producao" >
                        <button type="submit"  class="btn btn-primary">Colocar em produção o pedido</button>
                    </form>

                    <form action="FrontController?action=MudarEstadoPedido" method="post">
                        <input type="hidden" name="pedidoId" value="${pedido.id}" >
                        <input type="hidden" name="acao" value="Transporte" >
                        <button type="submit"  class="btn btn-primary">Colocar em transporte o pedido</button>
                    </form>

                    <form action="FrontController?action=MudarEstadoPedido" method="post">
                        <input type="hidden" name="pedidoId" value="${pedido.id}" >
                        <input type="hidden" name="acao" value="Entregue" >
                        <button type="submit"  class="btn btn-primary">Declarar como entregue o pedido</button>
                    </form>

                </div>
            </c:if>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />