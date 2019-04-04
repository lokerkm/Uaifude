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

import model.Estabelecimento;
import model.Produto;
import model.promocao.Promocao;
import persistence.PromocaoDAO;
import persistence.EstabelecimentoDAO;
import persistence.ProdutoDAO;

public class LerPromocoesAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int promocaoId = Integer.parseInt(request.getParameter("promocaoId"));

        try {
            Promocao promocao = PromocaoDAO.getInstance().getPromocao(promocaoId);
            ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutoPromocao(promocaoId);

            request.setAttribute("produtos", produtos);
            request.setAttribute("promocao", promocao);

            RequestDispatcher view = request.getRequestDispatcher("paginaPromocoes.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LerPromocoesAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerPromocoesAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
