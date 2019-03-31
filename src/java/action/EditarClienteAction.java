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
import persistence.ClienteDAO;

/**
 *
 * @author Aluno
 */
public class EditarClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String dataNascimento = request.getParameter("dataNasciemnto");
        HttpSession sessao = request.getSession();
      

        Cliente cliente = (Cliente) sessao.getAttribute("usuario");
        cliente.setNome(nome);
        cliente.setNascimento(dataNascimento);
        cliente.setCpf(cpf);

        try {
            ClienteDAO.getInstance().update(cliente);
            sessao.setAttribute("Usuario", cliente);
            RequestDispatcher view = request.getRequestDispatcher("perfilCliente.jsp");
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
