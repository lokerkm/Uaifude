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
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.Endereco;
import persistence.ClienteDAO;
import persistence.EnderecoDAO;

/**
 *
 * @author kevin
 */
public class CadastrarClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String dataNasciemnto = request.getParameter("dataNasciemnto");
        String login = request.getParameter("login");
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
//        Endereco endereco = new Endereco(cep, logradouro, numero, complemento, bairro, cidade, estado);
//        Cliente cliente = new Cliente(nome, cpf, dataNasciemnto, login, senha, email, "Cliente", telefone, celular, null);
        Endereco endereco = new Endereco().setCep(cep).setLogradouro(logradouro).setNumero(numero).setComplemento(complemento).setBairro(bairro).setCidade(cidade).setEstado(estado);
        Cliente cliente = (Cliente) new Cliente().setNome(nome).setCpf(cpf).setNascimento(dataNasciemnto).setLogin(login).setSenha(senha).setEmail(email).setTipo("Cliente").setTelefone(telefone).setCelular(celular);
        try {

            endereco.setId(EnderecoDAO.getInstance().save(endereco));
            cliente.setEndereco(endereco);
            ClienteDAO.getInstance().save(cliente);

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
