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
import model.Pedido;
import model.Produto;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;

public class LerCarrinhoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            Pedido pedido = (Pedido) request.getSession().getAttribute("carrinho");

            request.setAttribute("pedido", pedido);
            request.setAttribute("produtosPedido", pedido.getProdutos());
            RequestDispatcher view = request.getRequestDispatcher("paginaPedido.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LerPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
