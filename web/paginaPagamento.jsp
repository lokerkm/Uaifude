<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="painelInicial.jsp">Home</a></li>
        <li class="breadcrumb-item"><a href="pedidosCliente.jsp">Meus pedidos</a></li>
        <li class="breadcrumb-item"><a href="pedidosCliente.jsp">Carrinho</a></li>
        <li class="breadcrumb-item active" aria-current="page">Pagamento</li>
    </ol>
    <div class="row">
        <div class="col-md-4 order-md-2 mb-4">

        </div>
        <div class="col-md-8 order-md-1">
            <h4 class="mb-3">Dados do pedido</h4>
            <form  <c:if test="${sessionScope.tipo == 'Cliente'}">action="FrontController?action=FinalizarPedido"</c:if> method="post"  class="needs-validation" novalidate>
                <input type="hidden" name="enderecoEntrega" id="enderecoEntrega" value="${enderecoEntrega}" >
                <input type="hidden" name="tipoPagamento" id="tipoPagamento" value="${tipoPagamento}" >
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="firstName">Nome do Cliente</label>
                        <input type="text" disabled="true" class="form-control" name="nome"  value="${sessionScope.usuario.nome}" >

                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="firstName">Total do pedido</label>
                        <input type="text" disabled="true" class="form-control" name="nome"  value="${pedido.total}" >

                    </div>
                </div>
                <h4 class="mb-3">Produtos</h4>
                <div class="row">
                    <c:forEach items="${produtosPedido}" var="produto">

                        <div class="col-md-6 mb-3">
                            Nome: ${produto.nome}
                            <input type="text" disabled="true" class="form-control" id="lastName"  value="${produto.nome}" required>
                            Preço: 
                            <input type="text" disabled="true" class="form-control" id="lastName"  value="${produto.getPrecoPosPromocao()}" required>

                        </div>

                    </c:forEach>
                </div>
                <h4 class="mb-3">Pagamento </h4>
                <c:if test="${tipoPagamento == 'Cartao'}">
                    <h5 class="mb-3">Dados do Cartão</h5>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="numeroCartao">Número Cartão</label>
                            <input type="text" class="form-control" id="numeroCartao" name="numeroCartao" placeholder=""  value="" required>

                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="nomeTitular">Nome do titular</label>
                            <input type="text" class="form-control" id="nomeTitular" name="nomeTitular" value="" required>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="validadeCartao">Validade do cartão</label>
                            <input type="text" class="form-control" id="validadeCartao" name="validadeCartao" value="" required>

                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="codigoSeguranca">Codigo de segurança</label>
                            <input type="text" class="form-control" id="codigoSeguranca" name="codigoSeguranca"  value="" required>

                        </div>
                    </div>


                </c:if>
                <c:if test="${tipoPagamento == 'Dinheiro'}">Você optou por pagamento em dinheiro, pague diretamente com o entregador!</c:if>

                    <h4 class="mb-3">
                    <c:if test="${enderecoEntrega == 'outro'}">Endereço da entrega</c:if>
                    <c:if test="${enderecoEntrega == 'padrao'}">Utilizando endereço padrão</c:if></h4>

                    <h5 class="mb-3">Dados do endereco</h5>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="logradouro">Logradouro</label>
                            <input type="text" class="form-control" id="logradouro" name="logradouro" placeholder="" <c:if test="${enderecoEntrega == 'padrao'}"> disabled="true" </c:if> value="${sessionScope.usuario.endereco.logradouro}" required>

                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="numero">Numero</label>
                            <input type="text" class="form-control" id="numero" name="numero" placeholder="" <c:if test="${enderecoEntrega == 'padrao'}"> disabled="true" </c:if> value="${sessionScope.usuario.endereco.numero}" required>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="complemento">Complemento</label>
                            <input type="text" class="form-control" id="complemento" name="complemento" placeholder="" <c:if test="${enderecoEntrega == 'padrao'}"> disabled="true" </c:if> value="${sessionScope.usuario.endereco.complemento}" required>

                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="cep">CEP</label>
                            <input type="text" class="form-control" id="cep" name="cep" placeholder="" <c:if test="${enderecoEntrega == 'padrao'}"> disabled="true" </c:if> value="${sessionScope.usuario.endereco.cep}" required>

                        </div>
                    </div><div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="bairro">Bairro</label>
                            <input type="text" class="form-control" id="bairro" name="bairro" placeholder="" <c:if test="${enderecoEntrega == 'padrao'}"> disabled="true" </c:if> value="${sessionScope.usuario.endereco.bairro}" required>

                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="cidade">Cidade</label>
                            <input type="text" class="form-control" id="cidade" name="cidade" placeholder="" <c:if test="${enderecoEntrega == 'padrao'}"> disabled="true" </c:if> value="${sessionScope.usuario.endereco.cidade}" required>

                        </div>
                    </div><div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="estado">Estado</label>
                            <input type="text" class="form-control" id="estado" name="estado" placeholder="" <c:if test="${enderecoEntrega == 'padrao'}"> disabled="true" </c:if> value="${sessionScope.usuario.endereco.estado}" required>

                        </div>
                        <input type="hidden" id="id" name="id" placeholder="" value="${sessionScope.usuario.endereco.id}" required>

                </div>

                <hr class="mb-4">
                <button class="btn btn-primary btn-lg btn-block" type="submit">Confirmar</button>
            </form>
        </div>
    </div>
</nav>
