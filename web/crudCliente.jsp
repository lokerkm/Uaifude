
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<c:if test="${sessionScope.tipo == 'Cliente'}">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
            <li class="breadcrumb-item"><a href="perfilCliente.jsp">Minha conta</a></li>
            <li class="breadcrumb-item active" aria-current="page">Editar dados ${sessionScope.usuario.nome}</li>
        </ol>
    </nav>
</c:if>


<div class="row">
    <div class="col-md-4 order-md-2 mb-4">


    </div>
    <div class="col-md-8 order-md-1">
        <h4 class="mb-3">Dados do cliente</h4>
        <form  <c:if test="${sessionScope.tipo == 'Cliente'}">action="FrontController?action=EditarCliente"</c:if> method="post"  class="needs-validation" novalidate>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstName">Nome</label>
                        <input type="text" class="form-control" id="firstName" name="nome" placeholder="" value="${cliente.nome}" required>
                    <div class="invalid-feedback">
                        Insira um nome válido.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="lastName">CPF</label>
                    <input type="text" class="form-control" id="lastName" name="cpf" placeholder="" value="${cliente.cpf}" required>
                    <div class="invalid-feedback">
                        Insira um cpf válido.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="lastName">Data de nascimento</label>
                    <input type="text" class="form-control" id="lastName" name="dataNasciemnto" placeholder="" value="${cliente.nascimento}" required>
                    <div class="invalid-feedback">
                        Insira uma data válida.
                    </div>
                </div>
            </div>


            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Alterar</button>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />
