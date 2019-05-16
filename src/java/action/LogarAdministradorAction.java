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
            if (adm == null || !listaUsuarios.contains(adm.getClass()) || !adm.getSenha().equals(senha)) {
                request.setAttribute("mensagem", "Senha ou login inválidos!");
               RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
            } else {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("tipo", "Administrador");
                sessao.setAttribute("usuario", adm);
                request.setAttribute("mensagem", "Você está logado como administrador.");
                RequestDispatcher view = request.getRequestDispatcher("painelInicial.jsp");
                  view.forward(request, response);
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(LogarAdministradorAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogarAdministradorAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LogarAdministradorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
