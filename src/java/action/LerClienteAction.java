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
import persistence.ClienteDAO;

/**
 *
 * @author Aluno
 */
public class LerClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int clienteId = Integer.parseInt(request.getParameter("clienteId"));
        String action = request.getParameter("action");

        try {
            Cliente cliente = ClienteDAO.getInstance().getCliente(clienteId);

            request.setAttribute("cliente", cliente);
            request.setAttribute("action", action);
            RequestDispatcher view = request.getRequestDispatcher("/crudCliente.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
