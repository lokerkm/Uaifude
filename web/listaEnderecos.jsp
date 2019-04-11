<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Lista de Enderecos</li>
    </ol>
</nav>
<div class="row">
<c:forEach items="${enderecos}" var="endereco">

    <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
            <img src="https://i.imgur.com/zPcHRDK.png"  class="img-thumbnail">
            <div class="card-body">
                 <p class="card-text" >${endereco.logradouro} N°  ${endereco.numero} </p>        
                <form action="FrontController?action=PrepararEndereco" method="post">
                    <input type="hidden" name="enderecoId" value="${endereco.getId()}" >
                    <input type="hidden" name="acaoEndereco" value="Ler" >
                    <button type="submit"  class="btn btn-primary">LER</button>
                </form>

                <form action="FrontController?action=PrepararEndereco" method="post">
                    <input type="hidden" name="enderecoId" value="${endereco.getId()}" >
                    <input type="hidden" name="acaoEndereco" value="Editar" >
                    <button type="submit"  class="btn btn-primary">EDITAR</button>
                </form>

                <form action="FrontController?action=PrepararEndereco" method="post">
                    <input type="hidden" name="enderecoId" value="${endereco.getId()}" >
                    <input type="hidden" name="acaoEndereco" value="Excluir" >
                    <button type="submit"  class="btn btn-primary">APAGAR</button>
                </form>
            </div>
        </div>

    </div>


</c:forEach>
</div>

<jsp:include page="footer.jsp" />
