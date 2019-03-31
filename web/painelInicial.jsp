<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />


<c:if test="${sessionScope.tipo == 'Cliente'}">
    <c:forEach items="${sessionScope.estabelecimentos}" var="estabelecimento">
        <form action="FrontController?action=LerEstabelecimento" method="post" style="padding-top: 40px;">
            <div class="container">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
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
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </c:forEach>
</c:if>

<c:if test="${sessionScope.tipo == 'Estabelecimento'}">
    <c:forEach items="${sessionScope.produtos}" var="produto">
        <form action="FrontController?action=LerProduto" method="post">
            <div class="container">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <div class="card mb-4 shadow-sm">
                                <img src="${produto.linkImagem}"  class="img-thumbnail">
                                <div class="card-body">
                                    <p class="card-text" >${produto.nome}</p>

                                    <div class="justify-content-between align-items-center">
                                        <div class="btn-group">

                                            <input type="hidden" name="produtoId" value="${produto.id}" >
                                            <button type="submit"  class="btn btn-primary">Gerenciar</button>

                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </c:forEach>
</c:if>
 
  
<jsp:include page="footer.jsp" />