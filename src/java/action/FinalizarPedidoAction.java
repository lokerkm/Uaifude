package action;

import controller.Action;
import controller.EstadoFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.Pedido;
import persistence.PedidoDAO;

public class FinalizarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String enderecoEntrega = request.getParameter("enderecoEntrega");
        if (enderecoEntrega.equals("outro")) {
            //pegar treta de endereço
            //setar endereço no pedido
        }

        try {
            Pedido pedido = (Pedido) request.getSession().getAttribute("carrinho");
            pedido.setId(PedidoDAO.getInstance().getNextId());
            pedido.toConfirmado();
            HttpSession sessao = request.getSession();
            Cliente cliente = (Cliente) sessao.getAttribute("usuario");
            pedido.setCliente(cliente);
            pedido.setEstabelecimentoId(pedido.getProdutos().get(0).getIdEstabelecimento());
            PedidoDAO.getInstance().save(pedido, pedido.getEndereco());

            Pedido pedidoCarrinho = new Pedido(0, cliente.getEndereco(), EstadoFactory.create("Carrinho"), 0);
            sessao.setAttribute("pedidos", PedidoDAO.getInstance().getPedidosCliente(cliente.getClienteId()));
            sessao.setAttribute("carrinho", pedidoCarrinho);
            response.sendRedirect("painelInicial.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(FinalizarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinalizarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
