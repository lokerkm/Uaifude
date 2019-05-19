package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Combo;
import persistence.EstabelecimentoDAO;
import persistence.ComboDAO;
import persistence.PromocaoDAO;

public class PrepararComboAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String acaoCombo = request.getParameter("acaoCombo");

        if (acaoCombo.equals("Cadastrar")) {
            request.setAttribute("acaoCombo", acaoCombo + "Combo");

            try {
                HttpSession sessao = request.getSession();
                request.setAttribute("produtos",sessao.getAttribute("produtos"));
                RequestDispatcher view = request.getRequestDispatcher("crudCombo.jsp");
                view.forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(PrepararComboAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        int comboId = Integer.parseInt(request.getParameter("comboId"));
        try {
            Combo combo = ComboDAO.getInstance().getCombo(comboId);
            acaoCombo += "Combo";
            request.setAttribute("acaoCombo", acaoCombo);
            request.setAttribute("combo", combo);
            request.setAttribute("estabelecimentos", EstabelecimentoDAO.getInstance().getEstabelecimentos());
            RequestDispatcher view = request.getRequestDispatcher("crudCombo.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(PrepararComboAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrepararComboAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrepararComboAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
