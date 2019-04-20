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
import persistence.ClienteDAO;

/**
 *
 * @author kevin
 */
public class PrepararClientesAdmAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.setAttribute("clientes", ClienteDAO.getInstance().getClientes());
            RequestDispatcher view = request.getRequestDispatcher("listaClientes.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararClientesAdmAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}