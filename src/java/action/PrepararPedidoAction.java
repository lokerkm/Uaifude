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
import model.Pedido;
import persistence.PedidoDAO;

public class PrepararPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String acaoPedido = request.getParameter("acaoPedido");

        if (acaoPedido.equals("Cadastrar")) {
            request.setAttribute("acaoPedido", acaoPedido + "Pedido");
            RequestDispatcher view = request.getRequestDispatcher("crudPedido.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PrepararPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
        try {
            Pedido pedido = PedidoDAO.getInstance().getPedido(pedidoId);
            acaoPedido += "Pedido";
            request.setAttribute("acaoPedido", acaoPedido);
            request.setAttribute("pedido", pedido);
            request.setAttribute("produtosPedido", pedido.getProdutos());

            RequestDispatcher view = request.getRequestDispatcher("crudPedido.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
