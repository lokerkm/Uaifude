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
import persistence.EstabelecimentoDAO;
import persistence.ProdutoDAO;
import persistence.PromocaoDAO;

public class EditarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        float preco = Float.parseFloat(request.getParameter("preco"));
        int id = Integer.parseInt(request.getParameter("id"));
        String linkImagem = request.getParameter("linkImagem");
        int promocao = Integer.parseInt(request.getParameter("promocao"));

//        Produto produto = new Produto(id, nome, preco, true, descricao, linkImagem);
        Produto produto = new Produto().setId(id).setNome(nome).setPreco(preco).setDisponivel(true).setDescricao(descricao).setLinkImagem(linkImagem);
        HttpSession sessao = request.getSession();
        Estabelecimento estabelecimento = null;
        if (sessao.getAttribute("tipo").equals("Administrador")) {
            try {
                int estabelecimentoId = Integer.parseInt(request.getParameter("estabelecimentoId"));
                estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(estabelecimentoId);
            } catch (SQLException ex) {
                Logger.getLogger(EditarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            estabelecimento = (Estabelecimento) sessao.getAttribute("usuario");
        }
        produto.setIdEstabelecimento(estabelecimento.getEstabelecimentoId());
        try {
            produto.setPromocao(PromocaoDAO.getInstance().getPromocao(promocao));
            ProdutoDAO.getInstance().update(produto);
            estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(estabelecimento.getLogin());
            estabelecimento.setProdutos(ProdutoDAO.getInstance().getProdutos(estabelecimento.getEstabelecimentoId()));
            sessao.setAttribute("produtos", estabelecimento.getProdutos());
            if (sessao.getAttribute("tipo").equals("Administrador")) {
                request.setAttribute("produtos", ProdutoDAO.getInstance().getProdutos());
                RequestDispatcher view = request.getRequestDispatcher("/listaProdutos.jsp");
                view.forward(request, response);
            } else {
                response.sendRedirect("gerenciarProdutos.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastrarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(EditarProdutoAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
