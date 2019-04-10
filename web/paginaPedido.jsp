<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item"><a href="pedidosCliente.jsp">Meus pedidos</a></li>
        <li class="breadcrumb-item active" aria-current="page"><c:if test="${pedido.estado.estadoString()=='Carrinho'}">Carrinho</c:if><c:if test="${pedido.estado.estadoString()!='Carrinho'}">Pedido ${pedido.id}</c:if></li>
        </ol>
    </nav>
    <div class="container">
        <div class="container">
            <div class="row">
            <c:forEach items="${produtosPedido}" var="produto">


                <div class="col-md-4">
                    <form action="FrontController?action=ExcluirProdutoPedido" method="post">
                        <div class="card mb-4 shadow-sm">
                            <img src="${produto.linkImagem}"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text" >Produto: ${produto.nome}</p>
                                <small class="text-muted">Preço: R$ ${produto.preco}</small>
                                <c:if test="${pedido.estado.estadoString()=='Carrinho'}">
                                    <input type="hidden" name="produtoId" value="${produto.id}">
                                    <button type="submit" class="btn btn-outline-danger">Remover do Carrinho</button>
                                </c:if>
                            </div>
                        </div>
                    </form>
                </div>


            </c:forEach>
        </div>
    </div>
</div>
<c:if test="${pedido.estado.estadoString()=='Carrinho'}">
    <form action="FrontController?action=ConfirmarCarrinho" method="post">
        Escolha o tipo de pagamento:
        <div class="input-group">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <input type="radio" name="tipoPagamento" id="Cartao" value="Cartao"> <label for="Cartao">Cartao</label>
                </div>
                <div class="input-group-text">
                    <input type="radio" name="tipoPagamento" id="Dinheiro" value="Dinheiro"><label for="Dinheiro">Dinheiro</label>
                </div>
            </div>

        </div>
        Endereço de entrega, Deseja usar seu endereço padrão?
        <div class="input-group">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <input type="radio" name="enderecoEntrega" id="padrao" value="padrao"> <label for="padrao">Sim</label>
                </div>
                <div class="input-group-text">
                    <input type="radio" name="enderecoEntrega" id="outro" value="outro"><label for="outro">Não</label>
                </div>
            </div>

        </div>
        <button type="submit"  class="btn btn-primary">Confirmar pedido</button>
    </form>
</c:if>
<jsp:include page="footer.jsp" />