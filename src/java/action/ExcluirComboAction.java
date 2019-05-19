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
import javax.servlet.http.HttpSession;
import model.Combo;
import model.Estabelecimento;
import persistence.EstabelecimentoDAO;
import persistence.ComboDAO;

public class ExcluirComboAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession sessao = request.getSession();
        Estabelecimento estabelecimento = (Estabelecimento) sessao.getAttribute("usuario");

        try {

            ComboDAO.getInstance().delete(id);
            estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(estabelecimento.getLogin());

            sessao.setAttribute("combos", ComboDAO.getInstance().getCombosEstabelecimento(estabelecimento.getEstabelecimentoId()));
            response.sendRedirect("gerenciarCombos.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ExcluirComboAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExcluirComboAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
