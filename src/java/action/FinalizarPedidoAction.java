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
import model.Pedido;
import persistence.PedidoDAO;

public class FinalizarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String endercoEntrega = request.getParameter("endercoEntrega");
        if (endercoEntrega.equals("outro")) {
            //pegar treta de endereço
            //setar endereço no pedido
        }
        Pedido pedido = (Pedido) request.getSession().getAttribute("carrinho");
        pedido.setEstado(EstadoFactory.create("Confirmado"));
        try {
            PedidoDAO.getInstance().save(pedido, pedido.getEndereco());
            //mandar pedido pro estabelecimento
             RequestDispatcher view = request.getRequestDispatcher("painelInicial.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(FinalizarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinalizarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
