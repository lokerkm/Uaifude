<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Estabelecimento ${estabelecimento.nome}</li>
    </ol>
</nav>
${produtosEstabelecimento}
<c:forEach items="${produtosEstabelecimento}" var="produto">
    <form action="FrontController?action=AdicionaProduto" method="post">
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card mb-4 shadow-sm">
                            <img src="${produto.linkImagem}"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text" >Produto: ${produto.nome}</p>
                                <small class="text-muted">Preço: R$ ${produto.preco}</small>

                                <input type="hidden" name="produtoId" value="${produto.id}" >
                                <input type="hidden" name="estabelecimentoId" value="${estabelecimento.getEstabelecimentoId()}" >
                                <button type="submit"  class="btn btn-primary">Adicionar ao carrinho</button>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</c:forEach>
<jsp:include page="footer.jsp" />