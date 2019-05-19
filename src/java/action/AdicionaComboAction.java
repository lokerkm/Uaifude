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
import model.Pedido;
import model.Combo;
import model.Produto;
import persistence.EstabelecimentoDAO;
import persistence.ComboDAO;
import persistence.ProdutoDAO;

public class AdicionaComboAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCombo = Integer.parseInt(request.getParameter("comboId"));
        int idEstabelecimeto = Integer.parseInt(request.getParameter("estabelecimentoId"));

        try {
            Estabelecimento estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(idEstabelecimeto);
            Combo combo = ComboDAO.getInstance().getCombo(idCombo);
            HttpSession sessao = request.getSession();
            Pedido pedidoCarrinho = (Pedido) sessao.getAttribute("carrinho");
            if (pedidoCarrinho.getProdutos().isEmpty() || pedidoCarrinho.getProdutos().get(0).getIdEstabelecimento() == estabelecimento.getEstabelecimentoId()) {
                for (int i = 0; i < combo.getProdutos().size(); i++) {
                    pedidoCarrinho.addProduto(combo.getProdutos().get(i));
                }
            } else {
                ArrayList<Combo> combos = ComboDAO.getInstance().getCombosEstabelecimento(idEstabelecimeto);
                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosEstabelecimento(idEstabelecimeto);

                sessao.setAttribute("carrinho", pedidoCarrinho);
                request.setAttribute("estabelecimento", estabelecimento);
                request.setAttribute("combosEstabelecimento", combos);
                request.setAttribute("produtosEstabelecimento", produtos);
                request.setAttribute("mensagemAddCarrinho", "Você  nao pode adicionar combos de lojas diferentes ao carrinho.");

                RequestDispatcher view = request.getRequestDispatcher("paginaEstabelecimento.jsp");
                view.forward(request, response);
            }

            ArrayList<Combo> combos = ComboDAO.getInstance().getCombosEstabelecimento(idEstabelecimeto);
            ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosEstabelecimento(idEstabelecimeto);
            sessao.setAttribute("carrinho", pedidoCarrinho);
            request.setAttribute("estabelecimento", estabelecimento);
            request.setAttribute("combosEstabelecimento", combos);
            request.setAttribute("produtosEstabelecimento", produtos);
            request.setAttribute("mensagemAddCarrinho", "Você adicionou 1 " + combo.getNome() + " ao carrinho.");

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
