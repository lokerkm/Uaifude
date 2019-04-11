/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Estabelecimento;
import persistence.EstabelecimentoDAO;

/**
 *
 * @author kevin
 */
public class PrepararEstabelecimentoAction implements Action {
     @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String acaoEstabelecimento = request.getParameter("acaoEstabelecimento");

        if (acaoEstabelecimento.equals("Cadastrar")) {
            request.setAttribute("acaoEstabelecimento", acaoEstabelecimento + "Estabelecimento");
            RequestDispatcher view = request.getRequestDispatcher("crudEstabelecimento.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PrepararEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int estabelecimentoId = Integer.parseInt(request.getParameter("estabelecimentoId"));
        try {
            Estabelecimento estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(estabelecimentoId);
            acaoEstabelecimento += "Estabelecimento";
            request.setAttribute("acaoEstabelecimento", acaoEstabelecimento);
            request.setAttribute("estabelecimento", estabelecimento);
            request.setAttribute("produtosEstabelecimento", estabelecimento.getProdutos());

            RequestDispatcher view = request.getRequestDispatcher("crudEstabelecimento.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditarEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
