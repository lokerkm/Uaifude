package action;

import controller.Action;
import controller.EstadoFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pedido;

public class ConfirmarCarrinhoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipoPagamento = request.getParameter("tipoPagamento");
        String enderecoEntrega = request.getParameter("enderecoEntrega");
        Pedido pedido = (Pedido) request.getSession().getAttribute("carrinho");
        request.setAttribute("pedido", pedido);
        request.setAttribute("produtosPedido", pedido.getProdutos());
        request.setAttribute("tipoPagamento", tipoPagamento);
        request.setAttribute("enderecoEntrega", enderecoEntrega);
        RequestDispatcher view = request.getRequestDispatcher("paginaPagamento.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ConfirmarCarrinhoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
