<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Lista de Produtos</li>
    </ol>
</nav>

<c:forEach items="${produtos}" var="produto">

    <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
            <img src="${produto.linkImagem}"  class="img-thumbnail">
            <div class="card-body">
                <p class="card-text" >Produto: ${produto.nome}</p>
                <c:if test="${produto.promocao.getNome() == 'SemPromocao'}">
                    <small class="text-muted">Preço: R$ ${produto.preco}</small></c:if>
                <c:if test="${produto.promocao.getNome() != 'SemPromocao'}">
                    <small class="text-muted">Preço: De:${produto.preco}
                        Por:${produto.getPrecoPosPromocao()}</small></c:if>
                <small class="text-muted">Estabelecimento: ${produto.getEstabelecimento().nome}</small>
                <form action="FrontController?action=PrepararProduto" method="post">
                    <input type="hidden" name="produtoId" value="${produto.id}" >
                    <input type="hidden" name="acaoProduto" value="Ler" >
                    <button type="submit"  class="btn btn-primary">LER</button>
                </form>

                <form action="FrontController?action=PrepararProduto" method="post">
                    <input type="hidden" name="produtoId" value="${produto.id}" >
                    <input type="hidden" name="acaoProduto" value="Editar" >
                    <button type="submit"  class="btn btn-primary">EDITAR</button>
                </form>

                <form action="FrontController?action=PrepararProduto" method="post">
                    <input type="hidden" name="produtoId" value="${produto.id}" >
                    <input type="hidden" name="acaoProduto" value="Excluir" >
                    <button type="submit"  class="btn btn-primary">APAGAR</button>
                </form>
            </div>
        </div>

    </div>


</c:forEach>


<jsp:include page="footer.jsp" />
