/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import persistence.ClienteDAO;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;

/**
 *
 * @author Aluno
 */
public class LerPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("pedidoId"));

        try {
            Pedido pedido = PedidoDAO.getInstance().getPedido(id);
            ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(id);
            request.setAttribute("pedido", pedido);
            request.setAttribute("produtosPedido", produtos);
            RequestDispatcher view = request.getRequestDispatcher("paginaPedido.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LerPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LerPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
