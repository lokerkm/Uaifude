package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Estabelecimento;
import model.Produto;
import persistence.EstabelecimentoDAO;
import persistence.ProdutoDAO;

public class ExcluirProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession sessao = request.getSession();
        Estabelecimento estabelecimento = (Estabelecimento) sessao.getAttribute("usuario");

        try {
            ProdutoDAO.getInstance().delete(id);
            estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(estabelecimento.getLogin());
            estabelecimento.setProdutos(ProdutoDAO.getInstance().getProdutos(estabelecimento.getEstabelecimentoId()));
            sessao.setAttribute("produtos", estabelecimento.getProdutos());
            response.sendRedirect("gerenciarProdutos.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
