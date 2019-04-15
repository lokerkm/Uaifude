<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />

<div class="container">
    <c:if test="${!empty mensagem}">
        <div class="alert alert-success" role="alert" >

            ${mensagem}</div>
        </c:if>
    <div class="container">
        <div class="row">
            <c:if test="${sessionScope.tipo == 'Cliente'}">
                <c:forEach items="${sessionScope.estabelecimentos}" var="estabelecimento">


                    <div class="col-md-4">
                        <form action="FrontController?action=LerEstabelecimento" method="post" style="padding-top: 40px;">
                            <div class="card mb-4 shadow-sm">
                                <img src="${estabelecimento.linkImagem}"  class="img-thumbnail">
                                <div class="card-body">
                                    <p class="card-text" >${estabelecimento.nome}</p>
                                    <p class="text-muted">Categoria</p>
                                    <p class="card-text" >${estabelecimento.categoria.getNome()}</p>
                                    <div class="justify-content-between align-items-center">
                                        <div>

                                            <input type="hidden" name="estabelecimentoId" value="${estabelecimento.getEstabelecimentoId()}" >
                                            <button type="submit"  class="btn btn-primary">Visitar</button>

                                        </div>

                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>

                </c:forEach>
            </c:if>

            <c:if test="${sessionScope.tipo == 'Estabelecimento'}">


                <div class="col-md-4">
                    <form action="FrontController?action=LerPedidoEstabelecimento" method="post">
                        <div class="card mb-4 shadow-sm">
                            <img src="https://i.imgur.com/Bal96x3.png"  class="img-thumbnail">
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
                    </form>
                </div>


                <div class="col-md-4">
                    <form action="FrontController?action=LerPedidoEstabelecimento" method="post">
                        <div class="card mb-4 shadow-sm">
                            <img src="https://i.imgur.com/U1JgY8D.png"  class="img-thumbnail">
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
                    </form>
                </div>


                <div class="col-md-4">
                    <form action="FrontController?action=LerPedidoEstabelecimento" method="post">
                        <div class="card mb-4 shadow-sm">
                            <img src="https://i.imgur.com/wZc9gnT.png"  class="img-thumbnail">
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
                    </form>
                </div>





                <div class="col-md-4">
                    <form action="FrontController?action=LerPedidoEstabelecimento" method="post">
                        <div class="card mb-4 shadow-sm">
                            <img src="https://i.imgur.com/dSn8vbA.jpg"  class="img-thumbnail">
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
                    </form>
                </div>





            </div>
        </div>
    </div>




</c:if>


<c:if test="${sessionScope.tipo == 'Administrador'}">


    <div class="col-md-4">
        <form action="FrontController?action=PrepararProdutosAdm" method="post">
            <div class="card mb-4 shadow-sm">
                <img src="https://i.imgur.com/lKJutHx.jpg"  class="img-thumbnail">
                <div class="card-body">
                    <p class="card-text" >CRUD Produtos</p>

                    <div class="justify-content-between align-items-center">
                        <div class="btn-group">


                            <button type="submit"  class="btn btn-primary">Gerenciar</button>

                        </div>

                    </div>
                </div>
            </div>
        </form>
    </div>

    <div class="col-md-4">
        <form action="FrontController?action=PrepararPedidosAdm" method="post">
            <div class="card mb-4 shadow-sm">
                <img src="https://i.imgur.com/lz4Xdhw.jpg"  class="img-thumbnail">
                <div class="card-body">
                    <p class="card-text" >CRUD Pedidos</p>

                    <div class="justify-content-between align-items-center">
                        <div class="btn-group">


                            <button type="submit"  class="btn btn-primary">Gerenciar</button>

                        </div>

                    </div>
                </div>
            </div>
        </form>
    </div>


    <div class="col-md-4">
        <form action="FrontController?action=PrepararEstabelecimentosAdm" method="post">
            <div class="card mb-4 shadow-sm">
                <img src="https://i.imgur.com/20OyrwJ.jpg"  class="img-thumbnail">
                <div class="card-body">
                    <p class="card-text" >CRUD Estabelecimentos</p>

                    <div class="justify-content-between align-items-center">
                        <div class="btn-group">


                            <button type="submit"  class="btn btn-primary">Gerenciar</button>

                        </div>

                    </div>
                </div>
            </div>
        </form>
    </div>
    
    <div class="col-md-4">
        <form action="FrontController?action=PrepararEnderecosAdm" method="post">
            <div class="card mb-4 shadow-sm">
                <img src="https://i.imgur.com/lKJutHx.jpg"  class="img-thumbnail">
                <div class="card-body">
                    <p class="card-text" >CRUD Endereços</p>

                    <div class="justify-content-between align-items-center">
                        <div class="btn-group">


                            <button type="submit"  class="btn btn-primary">Gerenciar</button>

                        </div>

                    </div>
                </div>
            </div>
        </form>
    </div>
    
    <div class="col-md-4">
        <form action="FrontController?action=PrepararClientesAdm" method="post">
            <div class="card mb-4 shadow-sm">
                <img src="https://i.imgur.com/lKJutHx.jpg"  class="img-thumbnail">
                <div class="card-body">
                    <p class="card-text" >CRUD Clientes</p>

                    <div class="justify-content-between align-items-center">
                        <div class="btn-group">


                            <button type="submit"  class="btn btn-primary">Gerenciar</button>

                        </div>

                    </div>
                </div>
            </div>
        </form>
    </div>


</c:if>

<jsp:include page="footer.jsp" />