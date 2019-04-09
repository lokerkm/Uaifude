<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item"><a href="promocoes.jsp">Promoções</a></li>
        <li class="breadcrumb-item active" aria-current="page">Produtos Promocao ${promocao.getNome()}</li>
    </ol>
</nav>

<c:if test="${!empty mensagemAddCarrinho}">
    <div class="alert alert-success" role="alert" >
        ${mensagemAddCarrinho}</div>
    <div class="alert alert-primary" role="alert">
        Valor total do carrinho R$${carrinho.total}
    </div></c:if>
    <div class="container">
        <div class="container">
            <div class="row">
            <c:forEach items="${produtos}" var="produto">


                <div class="col-md-4">
                    <form action="FrontController?action=AdicionaProduto" method="post">
                        <div class="card mb-4 shadow-sm">
                            <img src="${produto.linkImagem}"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text" >Produto: ${produto.nome}</p>
                                <small class="text-muted">Preço: R$ ${produto.getPrecoPosPromocao()}</small>

                                <input type="hidden" name="produtoId" value="${produto.id}" >
                                <input type="hidden" name="idEstabelecimeto" value="${produto.getIdEstabelecimento()}" >

                                <button type="submit"  class="btn btn-primary">Adicionar ao carrinho</button>

                            </div>
                        </div>
                    </form>
                </div>


            </c:forEach>

        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />