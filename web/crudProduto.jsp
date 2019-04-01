<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item"><a href="perfilEstabelecimento.jsp">Minha conta</a></li>
        <li class="breadcrumb-item"><a href="gerenciarProdutos.jsp">Gerenciar Produtos</a></li>
        <li class="breadcrumb-item active" aria-current="page">${acaoProduto} : ${produto.nome} </li>
    </ol>
</nav>

<div class="row">
    <div class="col-md-4 order-md-2 mb-4">


    </div>
    <div class="col-md-8 order-md-1">
        <h4 class="mb-3">Dados do Produto</h4>
        <form  <c:if test="${sessionScope.tipo == 'Estabelecimento'}">action="FrontController?action=${acaoProduto}"</c:if> method="post"  class="needs-validation" novalidate>
            <input type="hidden"  id="id" name="id" value="${produto.id}" >   
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="nome">Nome</label>
                    <input type="text"  <c:if test="${acaoProduto != 'EditarProduto' && acaoProduto != 'CadastrarProduto'}"> disabled="true" </c:if> class="form-control" id="nome" name="nome" placeholder="" value="${produto.nome}" required>
                        <div class="invalid-feedback">
                            Insira um nome válido.
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="preco">Preço</label>
                        <input type="text" <c:if test="${acaoProduto != 'EditarProduto' && acaoProduto != 'CadastrarProduto'}"> disabled="true" </c:if> class="form-control" id="preco" name="preco" placeholder="" value="${produto.preco}" required>
                        <div class="invalid-feedback">
                            Insira um preco válido.
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="linkImagem">Link foto do produto</label>
                        <input type="text" <c:if test="${acaoProduto != 'EditarProduto' && acaoProduto != 'CadastrarProduto'}"> disabled="true" </c:if> class="form-control" id="linkImagem" name="linkImagem" placeholder="" value="${produto.linkImagem}" required>
                        <div class="invalid-feedback">
                            Insira uma data válida.
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="descricao">Descrição dp produto</label>
                        <input type="text" <c:if test="${acaoProduto != 'EditarProduto' && acaoProduto != 'CadastrarProduto'}"> disabled="true" </c:if> class="form-control" id="descricao" name="descricao" placeholder="" value="${produto.descricao}" required>
                        <div class="invalid-feedback">
                            Insira uma data válida.
                        </div>
                    </div>
                </div>


                <hr class="mb-4">
            <c:if test="${acaoProduto != 'LerProduto'}">  <button class="btn btn-primary btn-lg btn-block" type="submit">Alterar</button></c:if>
            </form>
        </div>
    </div>



<jsp:include page="footer.jsp" />