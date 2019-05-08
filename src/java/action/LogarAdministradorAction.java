package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Administrador;
import model.Estabelecimento;
import persistence.AdministradorDAO;

public class LogarAdministradorAction implements Action {

    protected ArrayList listaUsuarios = new ArrayList();

    public LogarAdministradorAction() {
        listaUsuarios.add(Administrador.class);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");

        try {
            Administrador adm = AdministradorDAO.getInstance().getAdministrador(login);
            if (adm == null || !adm.getSenha().equals(senha)) {
                response.sendRedirect("index.jsp");
            } else {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("tipo", "Administrador");
                sessao.setAttribute("usuario", adm);
                response.sendRedirect("painelInicial.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogarUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogarUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
