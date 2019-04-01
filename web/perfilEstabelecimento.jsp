<jsp:include page="header.jsp" />
<div class="container">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">Minha conta</li>
        </ol>
    </nav>
    <form action="FrontController?action=LerDadosEstabelecimento" method="post">
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <img src="${sessionScope.usuario.linkImagem}"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text">Dados de ${sessionScope.usuario.nome}</p>

                                <div class="justify-content-between align-items-center">
                                    <div>

                                        <input type="hidden" name="estabelecimentoId" value="${sessionScope.usuario.getEstabelecimentoId()}" >
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

    <form action="FrontController?action=LerEnderecoEstabelecimento" method="post">
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <img src="https://i.imgur.com/B4D3TUY.png"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text">Endereço de ${sessionScope.usuario.nome}</p>

                                <div class="justify-content-between align-items-center">
                                    <div >

                                        <input type="hidden" name="estabelecimentoId" value="${sessionScope.usuario.getEstabelecimentoId()}" >
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
</div>

<jsp:include page="footer.jsp" />