<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item"><a href="pedidosCliente.jsp">Meus pedidos</a></li>
        <li class="breadcrumb-item"><a href="pedidosCliente.jsp">Carrinho</a></li>
        <li class="breadcrumb-item active" aria-current="page">Pagamento</li>
    </ol>
    <div class="row">
        <div class="col-md-4 order-md-2 mb-4">


        </div>
        <div class="col-md-8 order-md-1">
            <h4 class="mb-3">Dados do pedido</h4>
            <form  <c:if test="${sessionScope.tipo == 'Cliente'}">action="FrontController?action=FinalizarPedido"</c:if> method="post"  class="needs-validation" novalidate>
                <input type="hidden" name="enderecoEntrega" id="enderecoEntrega" value="${enderecoEntrega}" >
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstName">Nome do Cliente</label>
                        <input type="text" disabled="true" class="form-control" name="nome"  value="${sessionScope.usuario.nome}" >

                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="firstName">Total do pedido</label>
                        <input type="text" disabled="true" class="form-control" name="nome"  value="${pedido.total}" >

                    </div>
                </div>
                <h4 class="mb-3">Produtos</h4>
                <div class="row">
                    <c:forEach items="${produtosPedido}" var="produto">

                        <div class="col-md-6 mb-3">
                            Nome: ${produto.nome}
                            <input type="text" disabled="true" class="form-control" id="lastName"  value="${produto.nome}" required>
                            Preço: 
                            <input type="text" disabled="true" class="form-control" id="lastName"  value="${produto.preco}" required>

                        </div>

                    </c:forEach>
                </div>
                <h4 class="mb-3">Pagamento </h4>
                <c:if test="${tipoPagamento == 'Cartao'}">Coisas de carta de credito</c:if>
                <c:if test="${enderecoEntrega == 'padrao'}">Você optou por pagamento em dinheiro</c:if>

                    <h4 class="mb-3">Endereço de entrega ${enderecoEntrega}</h4>
                <c:if test="${enderecoEntrega == 'outro'}">Endereço da entrega</c:if>
                <c:if test="${enderecoEntrega == 'padrao'}">Utilizando endereço padrão</c:if>

                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Confirmar</button>
            </form>
        </div>
    </div>
</nav>
