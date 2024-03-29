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
import model.Combo;
import model.Estabelecimento;
import model.Pedido;
import model.Produto;
import persistence.ComboDAO;
import persistence.EstabelecimentoDAO;
import persistence.ProdutoDAO;

public class AdicionaProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idProduto = Integer.parseInt(request.getParameter("produtoId"));
        int idEstabelecimeto = Integer.parseInt(request.getParameter("estabelecimentoId"));

        try {
            Estabelecimento estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(idEstabelecimeto);
            Produto produto = ProdutoDAO.getInstance().getProduto(idProduto);
            HttpSession sessao = request.getSession();
            Pedido pedidoCarrinho = (Pedido) sessao.getAttribute("carrinho");
            if (pedidoCarrinho.getProdutos().isEmpty() || pedidoCarrinho.getProdutos().get(0).getIdEstabelecimento() == estabelecimento.getEstabelecimentoId()) {
                pedidoCarrinho.addProduto(produto);
            } else {
                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosEstabelecimento(idEstabelecimeto);
                ArrayList<Combo> combos = ComboDAO.getInstance().getCombosEstabelecimento(idEstabelecimeto);
                sessao.setAttribute("carrinho", pedidoCarrinho);
                request.setAttribute("estabelecimento", estabelecimento);
                request.setAttribute("produtosEstabelecimento", produtos);
                request.setAttribute("combosEstabelecimento", combos);
                request.setAttribute("mensagemAddCarrinho", "Você  nao pode adicionar produtos de lojas diferentes ao carrinho.");

                RequestDispatcher view = request.getRequestDispatcher("paginaEstabelecimento.jsp");
                view.forward(request, response);
            }

            ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosEstabelecimento(idEstabelecimeto);
            ArrayList<Combo> combos = ComboDAO.getInstance().getCombosEstabelecimento(idEstabelecimeto);
            sessao.setAttribute("carrinho", pedidoCarrinho);
            request.setAttribute("estabelecimento", estabelecimento);
            request.setAttribute("produtosEstabelecimento", produtos);
            request.setAttribute("combosEstabelecimento", combos);
            request.setAttribute("mensagemAddCarrinho", "Você adicionou 1 " + produto.getNome() + " ao carrinho.");

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
