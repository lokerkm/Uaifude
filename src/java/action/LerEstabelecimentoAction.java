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
import model.Estabelecimento;
import model.Produto;
import persistence.ClienteDAO;
import persistence.EstabelecimentoDAO;
import persistence.ProdutoDAO;

/**
 *
 * @author Aluno
 */
public class LerEstabelecimentoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("estabelecimentoId"));

        try {
            Estabelecimento estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(id);
            ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosEstabelecimento(id);
            request.setAttribute("estabelecimento", estabelecimento);
            request.setAttribute("produtosEstabelecimento", produtos);
            request.setAttribute("mensagemAddCarrinho", null);

            RequestDispatcher view = request.getRequestDispatcher("paginaEstabelecimento.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LerEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LerEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
