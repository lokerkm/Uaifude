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
import model.Estabelecimento;
import persistence.ClienteDAO;
import persistence.EnderecoDAO;
import persistence.EstabelecimentoDAO;

/**
 *
 * @author Aluno
 */
public class EditarEnderecoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String logradouro = request.getParameter("logradouro");
        String cep = request.getParameter("cep");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Endereco endereco = EnderecoDAO.getInstance().getEndereco(id);
            endereco.setBairro(bairro);
            endereco.setCep(cep);
            endereco.setCidade(cidade);
            endereco.setComplemento(complemento);
            endereco.setEstado(estado);
            endereco.setLogradouro(logradouro);
            endereco.setNumero(numero);
            EnderecoDAO.getInstance().update(endereco);
            HttpSession sessao = request.getSession();
            String tipo = (String) sessao.getAttribute("tipo");
            if (tipo.equalsIgnoreCase("Cliente")) {
                Cliente clienteSessao = (Cliente) sessao.getAttribute("usuario");
                Cliente cliente = ClienteDAO.getInstance().getCliente(clienteSessao.getClienteId());
                sessao.setAttribute("usuario", cliente);
                RequestDispatcher view = request.getRequestDispatcher("perfilCliente.jsp");
                view.forward(request, response);
            }
            if (tipo.equalsIgnoreCase("Estabelecimento")) {
                Estabelecimento estabelecimentoSessao = (Estabelecimento) sessao.getAttribute("usuario");
                Estabelecimento estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(estabelecimentoSessao.getEstabelecimentoId());
                sessao.setAttribute("usuario", estabelecimento);
                RequestDispatcher view = request.getRequestDispatcher("perfilEstabelecimento.jsp");
                view.forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EditarEnderecoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarEnderecoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(EditarEnderecoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
