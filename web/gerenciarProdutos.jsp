
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item"><a href="perfilEstabelecimento.jsp">Minha conta</a></li>
        <li class="breadcrumb-item active" aria-current="page">Gerenciar Produtos</li>
    </ol>
</nav>

<div class="alert alert-success" role="alert" >
    ${mensagem}</div>
<form action="FrontController?action=PrepararProduto" method="post">
    <div class="container">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="https://i.imgur.com/c4rzzki.png"  class="img-thumbnail">
                        <div class="card-body">
                            <p class="card-text" >Cadastrar produto</p>

                            <div class="justify-content-between align-items-center">
                                <div class="btn-group">

                                    <input type="hidden" name="acaoProduto" value="Cadastrar" >
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
<c:forEach items="${sessionScope.produtos}" var="produto">

    <div class="container">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="card mb-4 shadow-sm">
                        <img src="${produto.linkImagem}"  class="img-thumbnail">
                        <div class="card-body">
                            <p class="card-text" >Produto: ${produto.nome}</p>
                            <small class="text-muted">Preço: R$ ${produto.preco}</small>

                            <form action="FrontController?action=PrepararProduto" method="post">
                                <input type="hidden" name="produtoId" value="${produto.id}" >
                                <input type="hidden" name="acaoProduto" value="Ler" >
                                <button type="submit"  class="btn btn-info">Consultar produto</button>
                            </form>
                            <form action="FrontController?action=PrepararProduto" method="post">
                                <input type="hidden" name="produtoId" value="${produto.id}" >
                                <input type="hidden" name="acaoProduto" value="Editar" >
                                <button type="submit"  class="btn btn-secondary">Editar produto</button>
                            </form> 
                            <form action="FrontController?action=PrepararProduto" method="post">
                                <input type="hidden" name="produtoId" value="${produto.id}" >
                                <input type="hidden" name="acaoProduto" value="Excluir" >
                                <button type="submit"  class="btn btn-danger">Excluir Produto</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</form>
</c:forEach>

<jsp:include page="footer.jsp" />