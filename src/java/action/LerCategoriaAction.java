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
import model.Categoria;
import model.Cliente;
import model.Estabelecimento;
import persistence.CategoriaDAO;
import persistence.ClienteDAO;
import persistence.EstabelecimentoDAO;

public class LerCategoriaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int categoriaId = Integer.parseInt(request.getParameter("categoriaId"));

        try {
            Categoria categoria = CategoriaDAO.getInstance().getCategoria(categoriaId);
            ArrayList<Estabelecimento> estabelecimentos = EstabelecimentoDAO.getInstance().getEstabelecimentosCategoria(categoriaId);

            request.setAttribute("estabelecimentos", estabelecimentos);
            request.setAttribute("categoria", categoria);

            RequestDispatcher view = request.getRequestDispatcher("estabelecimentoCategoria.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LerClienteAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LerCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerCategoriaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
