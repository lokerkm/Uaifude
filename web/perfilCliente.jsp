<jsp:include page="header.jsp" />

<h1>Bem vindo, ${sessionScope.usuario.nome}!</h1>

<h2>Dados da conta</h2>
<h3>login</h3>
${sessionScope.usuario.login}
<h3>email</h3>
${sessionScope.usuario.email}
<h3>telefone</h3>
${sessionScope.usuario.telefone}
<h3>celular</h3>
${sessionScope.usuario.celular}

<h2>Dados pessoais</h2>
<h3>nome</h3>
${sessionScope.usuario.nome}
<h3>cpf</h3>
${sessionScope.usuario.cpf}
<h3>Data de nascimento</h3>
${sessionScope.usuario.nascimento}

<h2>Endereco</h2>
<h3>Estado</h3>
${sessionScope.usuario.endereco.estado}
<h3>Cidade</h3>
${sessionScope.usuario.endereco.cidade}
<h3>Bairro</h3>
${sessionScope.usuario.endereco.bairro}
<h3>Logradouro</h3>
${sessionScope.usuario.endereco.logradouro}
<h3>Numero</h3>
${sessionScope.usuario.endereco.numero}
<h3>Complemento</h3>
${sessionScope.usuario.endereco.complemento}


<jsp:include page="footer.jsp" />