<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Área Administrador</li>
    </ol>
</nav>

<h1>${sessionScope.usuario}</h1>
<h1>${sessionScope.usuario.login}</h1>
<h1>${sessionScope.tipo}</h1>
<jsp:include page="footer.jsp" />