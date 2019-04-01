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
import model.Estabelecimento;
import persistence.EstabelecimentoDAO;

public class LerEnderecoEstabelecimentoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("estabelecimentoId"));
        try {
            Estabelecimento estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(id);
            request.setAttribute("endereco", estabelecimento.getEndereco());

            RequestDispatcher view = request.getRequestDispatcher("crudEnderecoEstabelecimento.jsp");
            view.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(LerEnderecoEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LerEnderecoEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LerEnderecoEstabelecimentoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
