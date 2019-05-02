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
import javax.servlet.http.HttpSession;
import model.Pedido;
import persistence.ClienteDAO;
import persistence.PedidoDAO;

/**
 *
 * @author Aluno
 */
public class EditarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
        String tipoPedido = request.getParameter("tipoPedido");
        try {
            HttpSession sessao = request.getSession();
            ArrayList<Pedido> pedidos = (ArrayList<Pedido>) sessao.getAttribute("pedidos");
            Pedido pedido = null;
            for (Pedido pedido1 : pedidos) {
                if (pedido1.getId() == pedidoId) {
                    pedido = pedido1;
                }
            }

            request.setAttribute("tipoPedido", tipoPedido);
            request.setAttribute("produtosPedido", pedido.getProdutos());
            request.setAttribute("pedido", pedido);
            RequestDispatcher view = request.getRequestDispatcher("crudPedido.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(EditarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
