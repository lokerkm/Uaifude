package action;

import controller.Action;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Estabelecimento;
import model.Produto;

public class LerProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String acaoProduto = request.getParameter("acaoProduto");
        HttpSession sessao = request.getSession();
        Estabelecimento estabelecimento = (Estabelecimento) sessao.getAttribute("usuario");
        ArrayList<Produto> produtosEstabelecimento = estabelecimento.getProdutos();
        request.setAttribute("produtosEstabelecimento", produtosEstabelecimento);
        request.setAttribute("acaoProduto", acaoProduto);
        response.sendRedirect("crudProduto.jsp");
    }
}
