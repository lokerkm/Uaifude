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
import model.Produto;
import persistence.EstabelecimentoDAO;
import persistence.ProdutoDAO;
import persistence.PromocaoDAO;

public class PrepararProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String acaoProduto = request.getParameter("acaoProduto");

        if (acaoProduto.equals("Cadastrar")) {
            request.setAttribute("acaoProduto", acaoProduto + "Produto");
            RequestDispatcher view = request.getRequestDispatcher("crudProduto.jsp");
            try {
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PrepararProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int produtoId = Integer.parseInt(request.getParameter("produtoId"));
        try {
            Produto produto = ProdutoDAO.getInstance().getProduto(produtoId);
            acaoProduto += "Produto";
            request.setAttribute("acaoProduto", acaoProduto);
            request.setAttribute("produto", produto);
            request.setAttribute("promocoes", PromocaoDAO.getInstance().getPromocoes());
            request.setAttribute("estabelecimentos", EstabelecimentoDAO.getInstance().getEstabelecimentos());
            RequestDispatcher view = request.getRequestDispatcher("crudProduto.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EditarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
