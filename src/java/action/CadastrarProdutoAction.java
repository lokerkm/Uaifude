package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Estabelecimento;
import model.Produto;
import persistence.EstabelecimentoDAO;
import persistence.ProdutoDAO;
import persistence.PromocaoDAO;

public class CadastrarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        int promocao = Integer.parseInt(request.getParameter("promocao"));
        float preco = Float.parseFloat(request.getParameter("preco"));
        String linkImagem = request.getParameter("linkImagem");

//        Produto produto = new Produto(nome, preco, true, descricao, linkImagem);
        Produto produto = new Produto().setNome(nome).setPreco(preco).setDisponivel(true).setDescricao(descricao).setLinkImagem(linkImagem);
        HttpSession sessao = request.getSession();
        Estabelecimento estabelecimento = (Estabelecimento) sessao.getAttribute("usuario");
        produto.setIdEstabelecimento(estabelecimento.getEstabelecimentoId());
        try {
            produto.setPromocao(PromocaoDAO.getInstance().getPromocao(promocao));
            ProdutoDAO.getInstance().save(produto);
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
