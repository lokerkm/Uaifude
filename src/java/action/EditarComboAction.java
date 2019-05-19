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
import model.Combo;
import model.Estabelecimento;
import model.Produto;
import persistence.ComboDAO;
import persistence.EstabelecimentoDAO;
import persistence.ProdutoDAO;

public class EditarComboAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String produtosSTR[];
        produtosSTR = request.getParameterValues("produtosId");
        ArrayList<Produto> produtos = new ArrayList<>();
        for (int i = 0; i < produtosSTR.length; i++) {
            try {
                produtos.add(ProdutoDAO.getInstance().getProduto(Integer.parseInt(produtosSTR[i])));
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarComboAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CadastrarComboAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        HttpSession sessao = request.getSession();
        Estabelecimento estabelecimento = (Estabelecimento) sessao.getAttribute("usuario");
        Combo combo = new Combo().setNome(nome).setIdEstabelecimento(estabelecimento.getEstabelecimentoId()).setProdutos(produtos).setId(id);

        try {

            ComboDAO.getInstance().update(combo);
            estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(estabelecimento.getLogin());

            sessao.setAttribute("combos", ComboDAO.getInstance().getCombosEstabelecimento(estabelecimento.getEstabelecimentoId()));
            response.sendRedirect("gerenciarCombos.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(EditarComboAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditarComboAction.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
}
