<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />


<c:if test="${sessionScope.tipo == 'Cliente'}">
    <c:forEach items="${sessionScope.estabelecimentos}" var="estabelecimento">
        <form action="FrontController?action=LerEstabelecimento" method="post" style="padding-top: 40px;">
            <div class="container">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="card mb-4 shadow-sm">
                                <img src="${estabelecimento.linkImagem}"  class="img-thumbnail">
                                <div class="card-body">
                                    <p class="card-text" >${estabelecimento.nome}</p>
                                    <p class="text-muted">Categoria</p>
                                    <div class="justify-content-between align-items-center">
                                        <div>

                                            <input type="hidden" name="estabelecimentoId" value="${estabelecimento.getEstabelecimentoId()}" >
                                            <button type="submit"  class="btn btn-primary">Visitar</button>

                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </c:forEach>
</c:if>

<c:if test="${sessionScope.tipo == 'Estabelecimento'}">
    <div class="alert alert-success" role="alert" >
        ${mensagem}</div>
    <form action="FrontController?action=LerPedidoEstabelecimento" method="post">
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <img src="http://2.bp.blogspot.com/-01-TGLQ52Jw/VeUAfiPpndI/AAAAAAAABrU/Q2Mk4waW8NU/s1600/pedidos.png"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text" >Pedidos confirmados</p>

                                <div class="justify-content-between align-items-center">
                                    <div class="btn-group">

                                        <input type="hidden" name="tipoPedido" value="Confirmado" >
                                        <button type="submit"  class="btn btn-primary">Gerenciar</button>

                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <form action="FrontController?action=LerPedidoEstabelecimento" method="post">
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <img src="https://cdn.icon-icons.com/icons2/37/PNG/512/kitchen_3484.png"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text" >Pedidos Em Produção</p>

                                <div class="justify-content-between align-items-center">
                                    <div class="btn-group">

                                        <input type="hidden" name="tipoPedido" value="Producao" >
                                        <button type="submit"  class="btn btn-primary">Gerenciar</button>

                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <form action="FrontController?action=LerPedidoEstabelecimento" method="post">
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <img src="https://cdn.pixabay.com/photo/2017/10/16/03/08/shipping-2856031_960_720.png"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text" >Pedidos Transporte</p>

                                <div class="justify-content-between align-items-center">
                                    <div class="btn-group">

                                        <input type="hidden" name="tipoPedido" value="Transporte" >
                                        <button type="submit"  class="btn btn-primary">Gerenciar</button>

                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>



    <form action="FrontController?action=LerPedidoEstabelecimento" method="post">
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <img src="https://st2.depositphotos.com/6628792/9627/v/950/depositphotos_96274948-stock-illustration-hand-shake-icon.jpg"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text" >Pedidos Entregue</p>

                                <div class="justify-content-between align-items-center">
                                    <div class="btn-group">

                                        <input type="hidden" name="tipoPedido" value="Entregue" >
                                        <button type="submit"  class="btn btn-primary">Gerenciar</button>

                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>



</c:if>


<jsp:include page="footer.jsp" />