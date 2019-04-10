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
import javax.servlet.http.HttpSession;
import model.Estabelecimento;
import persistence.EstabelecimentoDAO;

/**
 *
 * @author Aluno
 */
public class EditarEstabelecimentoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String descricao = request.getParameter("descricao");
        String linkImagem = request.getParameter("linkImagem");
        HttpSession sessao = request.getSession();

        Estabelecimento estabelecimento = (Estabelecimento) sessao.getAttribute("usuario");
        estabelecimento.setNome(nome);
        estabelecimento.setDescricao(descricao);
        estabelecimento.setCnpj(cnpj);
        estabelecimento.setLinkImagem(linkImagem);

        try {
            EstabelecimentoDAO.getInstance().update(estabelecimento);
            sessao.setAttribute("Usuario", estabelecimento);
            RequestDispatcher view = request.getRequestDispatcher("perfilEstabelecimento.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditarEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(EditarEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
