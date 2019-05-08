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
import model.Cliente;
import model.Pedido;
import persistence.CategoriaDAO;
import persistence.ClienteDAO;
import persistence.EstabelecimentoDAO;
import persistence.PedidoDAO;
import persistence.PromocaoDAO;

public class LogarClienteAction implements Action {

    private Action superior = new LogarEstabelecimentoAction();
    protected ArrayList listaDocumentos = new ArrayList();

    public LogarClienteAction() {
        listaDocumentos.add(Cliente.class);
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("txtLogin");
        String senha = request.getParameter("txtSenha");
        if (login.equals("") || senha.equals("")) {
            response.sendRedirect("index.jsp");
        }
        try {
            
            Cliente cliente = ClienteDAO.getInstance().getCliente(login);
           
            if (cliente == null || !cliente.getSenha().equals(senha)) {
                superior.execute(request, response);
               
            } else {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("tipo", "Cliente");
                sessao.setAttribute("usuario", cliente);
                sessao.setAttribute("estabelecimentos", EstabelecimentoDAO.getInstance().getEstabelecimentos());
                sessao.setAttribute("pedidos", PedidoDAO.getInstance().getPedidosCliente(cliente.getClienteId()));
                sessao.setAttribute("categorias", CategoriaDAO.getInstance().getCategorias());
//                        Pedido pedidoCarrinho = new Pedido(0, cliente.getEndereco(), Factory.createPedidoEstado("Carrinho"), 0);
                Pedido pedidoCarrinho = new Pedido().setId(0).setEndereco(cliente.getEndereco()).setEstado(Factory.createPedidoEstado("Carrinho")).setEstabelecimentoId(0);
                sessao.setAttribute("carrinho", pedidoCarrinho);
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
