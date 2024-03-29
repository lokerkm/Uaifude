/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Cliente;
import model.Endereco;
import model.Estabelecimento;
import persistence.CategoriaDAO;
import persistence.ClienteDAO;
import persistence.EnderecoDAO;
import persistence.EstabelecimentoDAO;

public class CadastrarEstabelecimentoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String descricao = request.getParameter("descricao");
        String linkImagem = request.getParameter("linkImagem");
        String login = request.getParameter("login");
        int categoriaId = Integer.parseInt(request.getParameter("categoria"));
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String logradouro = request.getParameter("logradouro");
        String cep = request.getParameter("cep");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");

        try {
            Categoria categoria = CategoriaDAO.getInstance().getCategoria(categoriaId);
//            Endereco endereco = new Endereco(cep, logradouro, numero, complemento, bairro, cidade, estado);
//            Estabelecimento estabelecimento = new Estabelecimento(nome, cnpj, descricao, linkImagem, categoria, login, email, senha, "Estabelecimento", telefone, celular, null);
            Endereco endereco = new Endereco().setCep(cep).setLogradouro(logradouro).setNumero(numero).setComplemento(complemento).setBairro(bairro).setCidade(cidade).setEstado(estado);
            Estabelecimento estabelecimento = (Estabelecimento) new Estabelecimento().setNome(nome).setCnpj(cnpj).setDescricao(descricao).setLinkImagem(linkImagem).setCategoria(categoria).setLogin(login).setSenha(senha).setEmail(email).setTipo("Estbelecimento").setTelefone(telefone).setCelular(celular);
            endereco.setId(EnderecoDAO.getInstance().save(endereco));
            estabelecimento.setEndereco(endereco);
            EstabelecimentoDAO.getInstance().save(estabelecimento);

            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(EditarClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
