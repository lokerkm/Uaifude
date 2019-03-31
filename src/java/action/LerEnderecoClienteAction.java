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

public class LerEnderecoClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("clienteId"));
        try {
            Cliente cliente = ClienteDAO.getInstance().getCliente(id);
            request.setAttribute("endereco", cliente.getEndereco());

            RequestDispatcher view = request.getRequestDispatcher("crudEndereco.jsp");
            view.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(LerEnderecoClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerEnderecoClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LerEnderecoClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
