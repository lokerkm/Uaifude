<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<c:if test="${sessionScope.tipo == 'Cliente'}">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
            <li class="breadcrumb-item"><a href="perfilCliente.jsp">Minha conta</a></li>
            <li class="breadcrumb-item active" aria-current="page">Editar endereo de ${sessionScope.usuario.nome}</li>
        </ol>
    </nav>
</c:if>

<div class="row">
    <div class="col-md-4 order-md-2 mb-4">


    </div>
    <div class="col-md-8 order-md-1">
        <h4 class="mb-3">Dados do endereco</h4>
        <form  <c:if test="${sessionScope.tipo == 'Cliente'}">action="FrontController?action=EditarEndereco"</c:if> method="post"  class="needs-validation" novalidate>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="logradouro">Logradouro</label>
                        <input type="text" class="form-control" id="logradouro" name="logradouro" placeholder="" value="${endereco.logradouro}" required>
                    <div class="invalid-feedback">
                        Insira um logradouro válido.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="numero">Numero</label>
                    <input type="text" class="form-control" id="numero" name="numero" placeholder="" value="${endereco.numero}" required>
                    <div class="invalid-feedback">
                        Insira um numero válido.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="complemento">Complemento</label>
                    <input type="text" class="form-control" id="complemento" name="complemento" placeholder="" value="${endereco.complemento}" required>
                    <div class="invalid-feedback">
                        Insira um complemento válido.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="cep">CEP</label>
                    <input type="text" class="form-control" id="cep" name="cep" placeholder="" value="${endereco.cep}" required>
                    <div class="invalid-feedback">
                        Insira um cep válido.
                    </div>
                </div>
            </div><div class="row">
                <div class="col-md-6 mb-3">
                    <label for="bairro">Bairro</label>
                    <input type="text" class="form-control" id="bairro" name="bairro" placeholder="" value="${endereco.bairro}" required>
                    <div class="invalid-feedback">
                        Insira um Bairro válido.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="cidade">Cidade</label>
                    <input type="text" class="form-control" id="cidade" name="cidade" placeholder="" value="${endereco.cidade}" required>
                    <div class="invalid-feedback">
                        Insira um Cidade válido.
                    </div>
                </div>
            </div><div class="row">
                <div class="col-md-6 mb-3">
                    <label for="estado">Estado</label>
                    <input type="text" class="form-control" id="estado" name="estado" placeholder="" value="${endereco.estado}" required>
                    <div class="invalid-feedback">
                        Insira um estado válido.
                    </div>
                </div>
                <input type="hidden" id="id" name="id" placeholder="" value="${endereco.id}" required>

            </div>
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Alterar</button>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />
