package action;

import controller.Action;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Pedido;

public class ExcluirProdutoPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idProduto = Integer.parseInt(request.getParameter("produtoId"));
        HttpSession sessao = request.getSession();
        Pedido pedidoCarrinho = (Pedido) sessao.getAttribute("carrinho");
        pedidoCarrinho.removeProduto(idProduto);
        sessao.setAttribute("carrinho", pedidoCarrinho);


        request.setAttribute("pedido", pedidoCarrinho);

        request.setAttribute("produtosPedido", pedidoCarrinho.getProdutos());
        RequestDispatcher view = request.getRequestDispatcher("paginaPedido.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ExcluirProdutoPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
