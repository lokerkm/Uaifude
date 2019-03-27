package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Administrador;
import model.Cliente;
import model.Estabelecimento;
import persistence.AdministradorDAO;
import persistence.ClienteDAO;
import persistence.EstabelecimentoDAO;

public class LogarUsuarioAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        String tipo = request.getParameter("txtTipo");
        if (login.equals("") || senha.equals("")) {
            response.sendRedirect("index.jsp");
        } else {

            if (tipo.equals("Cliente")) {
                try {
                    Cliente cliente = ClienteDAO.getInstance().getCliente(login);
                    if (cliente == null || !cliente.getSenha().equals(senha)) {
                        response.sendRedirect("index.jsp");
                    } else {
                        HttpSession sessao = request.getSession();
                        sessao.setAttribute("tipo", tipo);
                        sessao.setAttribute("usuario", cliente);
                        response.sendRedirect("painelInicial.jsp");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LogarUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LogarUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (tipo.equals("Estabelecimento")) {
                try {
                    Estabelecimento estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(login);
                    if (estabelecimento == null || !estabelecimento.getSenha().equals(senha)) {
                        response.sendRedirect("index.jsp");
                    } else {
                        HttpSession sessao = request.getSession();
                        sessao.setAttribute("tipo", tipo);
                        sessao.setAttribute("usuario", estabelecimento);
                        response.sendRedirect("painelInicial.jsp");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LogarUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LogarUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                try {
                    Administrador adm = AdministradorDAO.getInstance().getAdministrador(login);
                    if (adm == null || !adm.getSenha().equals(senha)) {
                        response.sendRedirect("index.jsp");
                    } else {
                        HttpSession sessao = request.getSession();
                        sessao.setAttribute("tipo", tipo);
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
    }

}
