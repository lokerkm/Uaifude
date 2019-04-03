
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="header.jsp" />
<div class="row">
    <div class="col-md-4 order-md-2 mb-4">


    </div>
    <div class="col-md-8 order-md-1">
        <h4 class="mb-3">Dados do cliente</h4>
        <form  action="FrontController?action=CadastrarCliente" method="post"  class="needs-validation" novalidate>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" id="nome" name="nome" placeholder="" value="${cliente.nome}" required>
                    <div class="invalid-feedback">
                        Insira um nome válido.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="cpf">CPF</label>
                    <input type="text" class="form-control" id="cpf" name="cpf" placeholder="" value="${cliente.cpf}" required>
                    <div class="invalid-feedback">
                        Insira um cpf válido.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="lastName">Data de nascimento</label>
                    <input type="text" class="form-control" id="lastName" name="dataNasciemnto" placeholder="" value="${cliente.nascimento}" required>
                    <div class="invalid-feedback">
                        Insira uma data válida.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="login">Login</label>
                    <input type="text" class="form-control" id="login" name="login" placeholder=""  required>
                    <div class="invalid-feedback">
                        Insira um login válido.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" id="senha" name="senha" placeholder=""  required>
                    <div class="invalid-feedback">
                        Insira um senha válido.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email" placeholder=""  required>
                    <div class="invalid-feedback">
                        Insira um email válido.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="telefone">Telefone</label>
                    <input type="text" class="form-control" id="telefone" name="telefone" placeholder=""  required>
                    <div class="invalid-feedback">
                        Insira um telefone válido.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="celular">Celular</label>
                    <input type="text" class="form-control" id="celular" name="celular" placeholder=""  required>
                    <div class="invalid-feedback">
                        Insira um celular válido.
                    </div>
                </div>

            </div>

            <h4 class="mb-3">Dados do endereco</h4>

            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="logradouro">Logradouro</label>
                    <input type="text" class="form-control" id="logradouro" name="logradouro" placeholder="" value="${endereco.logradouro}" required>
                    <div class="invalid-feedback">
                        Insira um logradouro válido.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="numero">Numero</label>
                    <input type="text" class="form-control" id="numero" name="numero" placeholder="" value="${endereco.numero}" required>
                    <div class="invalid-feedback">
                        Insira um numero válido.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="complemento">Complemento</label>
                    <input type="text" class="form-control" id="complemento" name="complemento" placeholder="" value="${endereco.complemento}" required>
                    <div class="invalid-feedback">
                        Insira um complemento válido.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="cep">CEP</label>
                    <input type="text" class="form-control" id="cep" name="cep" placeholder="" value="${endereco.cep}" required>
                    <div class="invalid-feedback">
                        Insira um cep válido.
                    </div>
                </div>
            </div><div class="row">
                <div class="col-md-6 mb-3">
                    <label for="bairro">Bairro</label>
                    <input type="text" class="form-control" id="bairro" name="bairro" placeholder="" value="${endereco.bairro}" required>
                    <div class="invalid-feedback">
                        Insira um Bairro válido.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="cidade">Cidade</label>
                    <input type="text" class="form-control" id="cidade" name="cidade" placeholder="" value="${endereco.cidade}" required>
                    <div class="invalid-feedback">
                        Insira um Cidade válido.
                    </div>
                </div>
            </div><div class="row">
                <div class="col-md-6 mb-3">
                    <label for="estado">Estado</label>
                    <input type="text" class="form-control" id="estado" name="estado" placeholder="" value="${endereco.estado}" required>
                    <div class="invalid-feedback">
                        Insira um estado válido.
                    </div>
                </div>
                <input type="hidden" id="id" name="id" placeholder="" value="${endereco.id}" required>

            </div>






            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Cadastrar</button>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />
