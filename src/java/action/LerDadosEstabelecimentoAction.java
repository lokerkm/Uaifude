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
 * @author Aluno
 */
public class LerDadosEstabelecimentoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int estabelecimentoId = Integer.parseInt(request.getParameter("estabelecimentoId"));
        String action = request.getParameter("action");

        try {
            Estabelecimento estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(estabelecimentoId);

            request.setAttribute("estabelecimento", estabelecimento);
            request.setAttribute("action", action);
            RequestDispatcher view = request.getRequestDispatcher("crudEstabelecimento.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LerEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LerEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
