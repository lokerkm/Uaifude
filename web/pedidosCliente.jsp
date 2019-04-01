<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Meus pedidos</li>
    </ol>
</nav>
<c:if test="${sessionScope.carrinho.produtos.size() >0}">
    <form action="FrontController?action=LerCarrinho" method="post">
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <img src="https://i.imgur.com/fyR1cVj.png"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text" >CARRINHO</p>
                                <small class="text-muted">Valor: R$ ${carrinho.total}</small>
                                <small class="text-muted">${pedido.estado.estadoString()}</small>
                                <div class="justify-content-between align-items-center">
                                    <c:if test="${pedido.estado.estadoString() != 'Entregue'}">
                                        <div >


                                            <button type="submit"  class="btn btn-primary">Acompanhar pedido</button>

                                        </div></c:if>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
</c:if>
<c:forEach items="${sessionScope.pedidos}" var="pedido">
    <form action="FrontController?action=LerPedido" method="post">
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <img src="https://i.imgur.com/E6aOelI.png"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text" >Pedido número: ${pedido.id}</p>
                                <small class="text-muted">Valor: R$ ${pedido.total}</small>
                                <small class="text-muted">${pedido.estado.estadoString()}</small>
                                <div class="justify-content-between align-items-center">
                                    <c:if test="${pedido.estado.estadoString() != 'Entregue'}">
                                        <div>

                                            <input type="hidden" name="pedidoId" value="${pedido.id}" >
                                            <button type="submit"  class="btn btn-primary">Ver pedido</button>

                                        </div></c:if>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
</c:forEach>

<jsp:include page="footer.jsp" />