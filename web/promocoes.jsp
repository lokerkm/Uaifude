<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Promoções</li>
    </ol>
</nav>


<c:forEach items="${sessionScope.promocoes}" var="promocao">


    <div class="col-md-4">
        <form action="FrontController?action=LerPromocoes" method="post" style="padding-top: 40px;">
            <div class="card mb-4 shadow-sm">
                <img src="https://i.imgur.com/ApCnBIo.png"  class="img-thumbnail">
                <div class="card-body">
                    <p class="text-muted">Promoção</p>
                    <p class="card-text" >${promocao.getNome()}</p>

                    <div class="justify-content-between align-items-center">
                        <div>

                            <input type="hidden" name="promocaoId" value="${promocao.getId()}" >
                            <button type="submit"  class="btn btn-primary">Visitar</button>

                        </div>

                    </div>
                </div>
            </div>
        </form>
    </div>

</c:forEach>
<jsp:include page="footer.jsp" />