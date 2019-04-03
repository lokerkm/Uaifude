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
import model.Cliente;
import model.Endereco;
import model.Estabelecimento;
import persistence.ClienteDAO;
import persistence.EnderecoDAO;
import persistence.EstabelecimentoDAO;

/**
 *
 * @author kevin
 */
public class CadastrarEstabelecimentoAction  implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String descricao = request.getParameter("descricao");
        String linkImagem = request.getParameter("linkImagem");
        String login = request.getParameter("login");
        String categoria = request.getParameter("categoria");
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
        Endereco endereco = new Endereco(cep, logradouro, numero, complemento, bairro, cidade, estado);
        Estabelecimento estabelecimento = new Estabelecimento(nome, cnpj, descricao,linkImagem,null ,login, email, senha,"Estabelecimento", telefone, celular, null);

        try {

            EnderecoDAO.getInstance().save(endereco);
            endereco.setId(EnderecoDAO.getInstance().getLastId());
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
