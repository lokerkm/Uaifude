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
import model.Produto;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;

public class PrepararPedidosAdmAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.setAttribute("pedidos", PedidoDAO.getInstance().getPedidos());
            RequestDispatcher view = request.getRequestDispatcher("listaPedidos.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararPedidosAdmAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
