<jsp:include page="header.jsp" />

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Minha conta</li>
    </ol>
</nav>

<div class="container">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <form action="FrontController?action=LerCliente" method="post">
                    <div class="card mb-4 shadow-sm">
                        <img src="https://i.imgur.com/zPcHRDK.png"  class="img-thumbnail">
                        <div class="card-body">
                            <p class="card-text">Dados pessoais de ${sessionScope.usuario.nome}</p>

                            <div class="justify-content-between align-items-center">
                                <div>

                                    <input type="hidden" name="clienteId" value="${sessionScope.usuario.getClienteId()}" >
                                    <button type="submit"  class="btn btn-primary">Visitar</button>

                                </div>

                            </div>
                        </div>
                    </div>
                </form>
            </div>





            <div class="col-md-4">
                <form action="FrontController?action=LerEnderecoCliente" method="post">
                    <div class="card mb-4 shadow-sm">
                        <img src="https://i.imgur.com/3O4ZKHp.png"  class="img-thumbnail">
                        <div class="card-body">
                            <p class="card-text">Endereço de entrega de ${sessionScope.usuario.nome}</p>

                            <div class="justify-content-between align-items-center">
                                <div >

                                    <input type="hidden" name="clienteId" value="${sessionScope.usuario.getClienteId()}" >
                                    <button type="submit"  class="btn btn-primary">Visitar</button>

                                </div>

                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>



<jsp:include page="footer.jsp" />