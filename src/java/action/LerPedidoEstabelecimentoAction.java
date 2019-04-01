package action;

import controller.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pedido;

public class LerPedidoEstabelecimentoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipoPedido = request.getParameter("tipoPedido");
        HttpSession sessao = request.getSession();
        ArrayList<Pedido> pedidosAUX = (ArrayList<Pedido>) sessao.getAttribute("pedidos");
        ArrayList<Pedido> pedidosFiltrados = new ArrayList<>();
        for (Pedido pedido : pedidosAUX) {
            if (pedido.getEstado().estadoString().equals(tipoPedido)) {
                pedidosFiltrados.add(pedido);
            }
        }

        request.setAttribute("tipoPedido", tipoPedido);
        request.setAttribute("pedidosFiltrados", pedidosFiltrados);
        RequestDispatcher view = request.getRequestDispatcher("pedidosEstabelecimento.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LerPedidoEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
