<jsp:include page="header.jsp" />

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Minha conta</li>
    </ol>
</nav>
<form action="FrontController?action=LerCliente" method="post">
    <div class="container">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="https://image.flaticon.com/icons/png/512/64/64096.png"  class="img-thumbnail">
                        <div class="card-body">
                            <p class="card-text">Dados pessoais de ${sessionScope.usuario.nome}</p>

                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">

                                    <input type="hidden" name="clienteId" value="${sessionScope.usuario.getClienteId()}" >
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

<form action="FrontController?action=LerEnderecoCliente" method="post">
    <div class="container">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="https://petbamboo.com.br/wp-content/uploads/2018/07/icone-endere%C3%A7o-300x300-1.png"  class="img-thumbnail">
                        <div class="card-body">
                            <p class="card-text">Endereço de entrega de ${sessionScope.usuario.nome}</p>

                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">

                                    <input type="hidden" name="clienteId" value="${sessionScope.usuario.getClienteId()}" >
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

<jsp:include page="footer.jsp" />