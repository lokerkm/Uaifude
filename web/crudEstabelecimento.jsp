
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<c:if test="${sessionScope.tipo == 'Estabelecimento'}">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
            <li class="breadcrumb-item"><a href="perfilEstabelecimento.jsp">Minha conta</a></li>
            <li class="breadcrumb-item active" aria-current="page">Editar Dados Estabelecimento</li>
        </ol>
    </nav>
</c:if>

<div class="row">
    <div class="col-md-4 order-md-2 mb-4">


    </div>
    <div class="col-md-8 order-md-1">
        <h4 class="mb-3">Dados do estabelecimento</h4>
        <form  <c:if test="${sessionScope.tipo == 'Estabelecimento'}">action="FrontController?action=EditarEstabelecimento"</c:if> method="post"  class="needs-validation" novalidate>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstName">Nome</label>
                        <input type="text" class="form-control" id="firstName" name="nome" placeholder="" value="${estabelecimento.nome}" required>
                    <div class="invalid-feedback">
                        Insira um nome válido.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="cnpj">CNPJ</label>
                    <input type="text" class="form-control" id="cnpj" name="cnpj" placeholder="" value="${estabelecimento.cnpj}" required>
                    <div class="invalid-feedback">
                        Insira um CPNJ válido.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="descricao">Descricao</label>
                    <input type="text" class="form-control" id="descricao" name="descricao" placeholder="" value="${estabelecimento.descricao}" required>
                    <div class="invalid-feedback">
                        Insira uma descricao válida.
                    </div>
                </div>

                <div class="col-md-6 mb-3">
                    <label for="linkImagem">Link Logo</label>
                    <input type="text" class="form-control" id="linkImagem" name="linkImagem" placeholder="" value="${estabelecimento.linkImagem}" required>
                    <div class="invalid-feedback">
                        Insira uma link Imagem válida.
                    </div>
                </div>
            </div>


            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Alterar</button>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />
