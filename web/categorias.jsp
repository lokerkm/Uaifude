<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Categorias</li>
    </ol>
</nav>
<div class="container">
    <div class="container">
        <div class="row">
            <c:forEach items="${sessionScope.categorias}" var="categoria">


                <div class="col-md-4">
                    <form action="FrontController?action=LerCategoria" method="post" style="padding-top: 40px;">
                        <div class="card mb-4 shadow-sm">
                            <img src="https://i.imgur.com/X0muEhN.png"  class="img-thumbnail">
                            <div class="card-body">
                                <p class="text-muted">Categoria</p>
                                <p class="card-text" >${categoria.nome}</p>
                                <p class="card-text" >${categoria.categoriaDescricao()}</p>

                                <div class="justify-content-between align-items-center">
                                    <div>

                                        <input type="hidden" name="categoriaId" value="${categoria.id}" >
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