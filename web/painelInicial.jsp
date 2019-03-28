<jsp:include page="header.jsp" />
<div class="container">
<h1>${sessionScope.usuario}</h1>

<h1>${sessionScope.usuario.email}</h1>

<h1>${sessionScope.usuario.login}</h1>
<h1>${sessionScope.tipo}</h1>
</div>
<jsp:include page="footer.jsp" />