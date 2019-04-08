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
import persistence.ProdutoDAO;

public class PrepararProdutosAdmAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.setAttribute("produtos", ProdutoDAO.getInstance().getProdutos());
            RequestDispatcher view = request.getRequestDispatcher("/listaProdutos.jsp");
            view.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PrepararProdutosAdmAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrepararProdutosAdmAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararProdutosAdmAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
