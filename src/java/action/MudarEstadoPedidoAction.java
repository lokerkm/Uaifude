package action;

import controller.Action;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
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

public class MudarEstadoPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
        String acao = "to" + request.getParameter("acao");
        Pedido pedido = null;

        try {

            HttpSession sessao = request.getSession();
            ArrayList<Pedido> pedidos = (ArrayList<Pedido>) sessao.getAttribute("pedidos");

            int indexMudanca = -1;
            for (int i = 0; i < pedidos.size(); i++) {
                if (pedidos.get(i).getId() == pedidoId) {
                    pedido = pedidos.get(i);
                    indexMudanca = i;
                }
            }

            String tipoPedido = pedido.getEstado().estadoString();
            Method metodo = pedido.getClass().getMethod(acao);
            request.setAttribute("mensagem", metodo.invoke(pedido));
            if (!tipoPedido.equals(pedido.getEstado().estadoString())) {
                PedidoDAO.getInstance().update(pedido);

                if (indexMudanca != -1) {
                    pedidos.set(indexMudanca, pedido);

                }
            }

            if (sessao.getAttribute("tipo").equals("Estabelecimento")) {

                sessao.setAttribute("pedidos", pedidos);

                RequestDispatcher view = request.getRequestDispatcher("painelInicial.jsp");
                view.forward(request, response);
            } else {

                sessao.setAttribute("pedidos", PedidoDAO.getInstance().getPedidos());

                RequestDispatcher view = request.getRequestDispatcher("listaPedidos.jsp");
                view.forward(request, response);
            }

        } catch (ServletException | SQLException | ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(MudarEstadoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
