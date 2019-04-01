package action;

import controller.Action;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Estabelecimento;

public class CadastrarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String acaoProduto = request.getParameter("acaoProduto");
       
        request.setAttribute("acaoProduto", acaoProduto);
        response.sendRedirect("crudProduto.jsp");
    }
}
