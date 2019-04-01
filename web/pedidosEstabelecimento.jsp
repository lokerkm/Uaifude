<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Pedidos ${tipoPedido} </li>
    </ol>
</nav>
<c:forEach items="${pedidosFiltrados}" var="pedido">
    <form action="FrontController?action=EditarPedido" method="post">
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <img src="https://img7.androidappsapk.co/poster/7/b/f/com.compilart.pedidoMobile_1.png"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text" >Pedido número: ${pedido.id}</p>
                                <small class="text-muted">Valor: R$ ${pedido.total}</small>

                                <div class="justify-content-between align-items-center">
                                    <c:if test="${pedido.estado.estadoString() != 'Entregue'}">
                                        <div>

                                            <input type="hidden" name="pedidoId" value="${pedido.id}" >
                                            <input type="hidden" name="tipoPedido" value="${tipoPedido}" >
                                            <button type="submit"  class="btn btn-primary">Gerenciar pedido</button>

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