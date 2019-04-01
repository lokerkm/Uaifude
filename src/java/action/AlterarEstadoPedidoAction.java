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

public class AlterarEstadoPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
        String tipoPedido = request.getParameter("tipoPedido");
        Pedido pedido;
        try {
            pedido = PedidoDAO.getInstance().getPedido(pedidoId);
            request.setAttribute("mensagem", "Pedido " + pedidoId + " alterado de "
                    + pedido.getEstado().estadoString() + " para " + tipoPedido);
            pedido.setEstado(tipoPedido);
            PedidoDAO.getInstance().update(pedido);
            HttpSession sessao = request.getSession();
            Estabelecimento estabelecimento = (Estabelecimento) sessao.getAttribute("usuario");
            sessao.setAttribute("pedidos", PedidoDAO.getInstance().getPedidosEstabelecimento(estabelecimento.getEstabelecimentoId()));

            RequestDispatcher view = request.getRequestDispatcher("painelInicial.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AlterarEstadoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlterarEstadoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(AlterarEstadoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
