
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Categorias</a></li>
        <li class="breadcrumb-item active" aria-current="page">Estabelecimentos ${categoria.nome}</li>
    </ol>
</nav><div class="container">
    <div class="container">
        <div class="row">
            <c:forEach items="${estabelecimentos}" var="estabelecimento">


                <div class="col-md-4">
                    <form action="FrontController?action=LerEstabelecimento" method="post" style="padding-top: 40px;">
                        <div class="card mb-4 shadow-sm">
                            <img src="${estabelecimento.linkImagem}"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="card-text" >${estabelecimento.nome}</p>
                                <p class="text-muted">Categoria</p>
                                <div class="justify-content-between align-items-center">
                                    <div>

                                        <input type="hidden" name="estabelecimentoId" value="${estabelecimento.getEstabelecimentoId()}" >
                                        <button type="submit"  class="btn btn-primary">Visitar</button>

                                    </div>

                                </div>
                            </div>
                        </div>
                    </form>
                </div>

            </c:forEach>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />
