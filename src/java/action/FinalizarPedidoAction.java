package action;

import controller.Action;
import controller.Factory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cliente;
import model.Endereco;
import model.Pedido;
import persistence.EnderecoDAO;
import persistence.PedidoDAO;

public class FinalizarPedidoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String enderecoEntrega = request.getParameter("enderecoEntrega");
        String tipoPagamento = request.getParameter("tipoPagamento");
        Pedido pedido = (Pedido) request.getSession().getAttribute("carrinho");
        HttpSession sessao = request.getSession();
        Cliente cliente = (Cliente) sessao.getAttribute("usuario");
        Endereco endereco = null;
        if (enderecoEntrega.equals("outro")) {
            String logradouro = request.getParameter("logradouro");
            String cep = request.getParameter("cep");
            String numero = request.getParameter("numero");
            String complemento = request.getParameter("complemento");
            String estado = request.getParameter("estado");
            String cidade = request.getParameter("cidade");
            String bairro = request.getParameter("bairro");
//            endereco = new Endereco(cep, logradouro, numero, complemento, bairro, cidade, estado);
            endereco.setCep(cep).setLogradouro(logradouro).setNumero(numero).setComplemento(complemento).setBairro(bairro).setCidade(cidade).setEstado(estado);
        }
        if (tipoPagamento.equals("Cartao")) {
            String numeroCartao = request.getParameter("numeroCartao");
            String nomeTitular = request.getParameter("nomeTitular");
            String validadeCartao = request.getParameter("validadeCartao");
            String codigoSeguranca = request.getParameter("codigoSeguranca");
            System.out.println("***************");
            System.out.println("Verificando cartão:" + numeroCartao);
            System.out.println("Nome do titular:" + nomeTitular);
            System.out.println("Validade do cartão:" + validadeCartao);
            System.out.println("Codigo de segurança:" + codigoSeguranca);
            System.out.println("Transação aceita!");
            System.out.println("Email enviado para " + cliente.getEmail());
            System.out.println("***************");
        }
        try {
            if (endereco != null) {
                ;
                pedido.setEndereco(EnderecoDAO.getInstance().getEndereco(EnderecoDAO.getInstance().save(endereco)));
            }
//            pedido.setId(PedidoDAO.getInstance().getNextId());
            pedido.toConfirmado();

            pedido.setCliente(cliente);
            pedido.setEstabelecimentoId(pedido.getProdutos().get(0).getIdEstabelecimento());
            PedidoDAO.getInstance().save(pedido, pedido.getEndereco());

//            Pedido pedidoCarrinho = new Pedido(0, cliente.getEndereco(), Factory.createPedidoEstado("Carrinho"), 0);
            Pedido pedidoCarrinho = new Pedido().setId(0).setEndereco(cliente.getEndereco()).setEstado(Factory.createPedidoEstado("Carrinho")).setEstabelecimentoId(0);
            sessao.setAttribute("pedidos", PedidoDAO.getInstance().getPedidosCliente(cliente.getClienteId()));
            sessao.setAttribute("carrinho", pedidoCarrinho);
            response.sendRedirect("painelInicial.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(FinalizarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinalizarPedidoAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
