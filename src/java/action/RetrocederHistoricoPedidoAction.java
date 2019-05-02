package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pedido;

public class RetrocederHistoricoPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));

        HttpSession sessao = request.getSession();
        ArrayList<Pedido> pedidos = (ArrayList<Pedido>) sessao.getAttribute("pedidos");
        Pedido pedido = null;
        int indexMudanca = -1;
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId() == pedidoId) {
                pedido = pedidos.get(i);
                indexMudanca = i;
            }
        }
        try {
            request.setAttribute("mensagem", pedido.retrocederHistorico());
            if (indexMudanca != -1) {
                pedidos.set(indexMudanca, pedido);
                sessao.setAttribute("pedidos", pedidos);
            }
            RequestDispatcher view = request.getRequestDispatcher("painelInicial.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AvancarHistoricoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AvancarHistoricoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(AvancarHistoricoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
