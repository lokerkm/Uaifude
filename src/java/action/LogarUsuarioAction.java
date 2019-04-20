package action;

import controller.Action;
import controller.Factory;
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
import model.Pedido;
import persistence.AdministradorDAO;
import persistence.CategoriaDAO;
import persistence.ClienteDAO;
import persistence.EstabelecimentoDAO;
import persistence.PedidoDAO;
import persistence.ProdutoDAO;
import persistence.PromocaoDAO;

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
            } else if (tipo.equals("Estabelecimento")) {
                try {
                    Estabelecimento estabelecimento = EstabelecimentoDAO.getInstance().getEstabelecimento(login);
                    if (estabelecimento == null || !estabelecimento.getSenha().equals(senha)) {
                        response.sendRedirect("index.jsp");
                    } else {
                        estabelecimento.setProdutos(ProdutoDAO.getInstance().getProdutos(estabelecimento.getEstabelecimentoId()));
                        HttpSession sessao = request.getSession();
                        sessao.setAttribute("tipo", tipo);
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
