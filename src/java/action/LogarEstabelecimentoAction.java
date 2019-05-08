package action;

import controller.Action;
import controller.Factory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Estabelecimento;
import model.Estabelecimento;
import model.Pedido;
import persistence.CategoriaDAO;
import persistence.EstabelecimentoDAO;
import persistence.EstabelecimentoDAO;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;
import persistence.PromocaoDAO;

public class LogarEstabelecimentoAction implements Action {

    Action superior = new LogarAdministradorAction();
    protected ArrayList listaUsuarios = new ArrayList();

    public LogarEstabelecimentoAction() {
        listaUsuarios.add(Estabelecimento.class);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");

        try {
            Estabelecimento estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(login);
            if (estabelecimento == null || !listaUsuarios.contains(estabelecimento.getClass()) || !estabelecimento.getSenha().equals(senha)) {
                superior.execute(request, response);
            } else {
                estabelecimento.setProdutos(ProdutoDAO.getInstance().getProdutos(estabelecimento.getEstabelecimentoId()));
                HttpSession sessao = request.getSession();
                sessao.setAttribute("tipo", "Estabelecimento");
                sessao.setAttribute("usuario", estabelecimento);
                sessao.setAttribute("pedidos", PedidoDAO.getInstance().getPedidosEstabelecimento(estabelecimento.getEstabelecimentoId()));
                sessao.setAttribute("produtos", estabelecimento.getProdutos());
                sessao.setAttribute("promocoes", PromocaoDAO.getInstance().getPromocoes());
                response.sendRedirect("painelInicial.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogarUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogarUsuarioAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
