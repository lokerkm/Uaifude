<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<c:if test="${sessionScope.tipo == 'Estabelecimento'}">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
            <li class="breadcrumb-item"><a href="perfilEstabelecimento.jsp">Minha conta</a></li>
            <li class="breadcrumb-item"><a href="gerenciarCombos.jsp">Gerenciar Combos</a></li>
            <li class="breadcrumb-item active" aria-current="page">${acaoCombo} : ${combo.nome} </li>
        </ol>
    </nav>
</c:if>
<c:if test="${sessionScope.tipo == 'Administrador'}">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">${acaoCombo} : ${combo.nome} </li>
        </ol>
    </nav>
</c:if>
<div class="container">
    <div class="container">
        <div class="row">
            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Dados do Combo</h4>
                <form  action="FrontController?action=${acaoCombo}" method="post"  class="needs-validation" novalidate>
                    <input type="hidden"  id="id" name="id" value="${combo.id}" >   
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="nome">Nome</label>
                            <input type="text"  <c:if test="${acaoCombo != 'EditarCombo' && acaoCombo != 'CadastrarCombo'}"> disabled="true" </c:if> class="form-control" id="nome" name="nome" placeholder="" value="${combo.nome}" required>
                                <div class="invalid-feedback">
                                    Insira um nome válido.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="row">

                                <div class="col-md-12">

                                    <select class="mdb-select colorful-select dropdown-primary md-form" multiple searchable="Search here.." name="produtosId">
                                    <c:forEach items="${sessionScope.produtos}" var="produto">
                                        <option value="${produto.id}" 

                                                <c:forEach items="${combo.getProdutos()}" var="produtoCombo">
                                                    <c:if test="${produtoCombo.id==produto.id}"> selected </c:if>
                                                </c:forEach>
                                                > ${produto.nome} </option>
                                    </c:forEach>    
                                </select>

                            </div>
                        </div>

                    </div>



                    <hr class="mb-4">
                    <c:if test="${acaoCombo != 'LerCombo'}">  <button class="btn btn-primary btn-lg btn-block" type="submit">Alterar</button></c:if>
                    </form>
                </div>
            </div>

        </div>
    </div>


<jsp:include page="footer.jsp" />