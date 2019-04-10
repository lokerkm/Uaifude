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
import model.Estabelecimento;
import model.Pedido;
import persistence.PedidoDAO;

public class ColocarCarrinhoPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));

        Pedido pedido;
        try {
            pedido = PedidoDAO.getInstance().getPedido(pedidoId);
            String tipoPedido = pedido.getEstado().estadoString();
            request.setAttribute("mensagem", pedido.toCarrinho());
            if (!tipoPedido.equals(pedido.getEstado().estadoString())) {
                PedidoDAO.getInstance().update(pedido);
            }

            HttpSession sessao = request.getSession();
            if (sessao.getAttribute("tipo").equals("Estabelecimento")) {
                Estabelecimento estabelecimento = (Estabelecimento) sessao.getAttribute("usuario");
                sessao.setAttribute("pedidos", PedidoDAO.getInstance().getPedidosEstabelecimento(estabelecimento.getEstabelecimentoId()));

                RequestDispatcher view = request.getRequestDispatcher("painelInicial.jsp");
                view.forward(request, response);
            } else {

                sessao.setAttribute("pedidos", PedidoDAO.getInstance().getPedidos());

                RequestDispatcher view = request.getRequestDispatcher("listaPedidos.jsp");
                view.forward(request, response);
            }
        } catch (ServletException ex) {
            Logger.getLogger(ColocarCarrinhoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ColocarCarrinhoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ColocarCarrinhoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
