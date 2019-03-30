package persistence;

import controller.EstadoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;
import model.Pedido;
import model.Produto;
import model.pedidoEstado.PedidoEstado;

public class PedidoDAO {

    private static PedidoDAO instance = new PedidoDAO();

    public static PedidoDAO getInstance() {
        return instance;
    }

    public List<Pedido> getPedidos() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido");

            while (rs.next()) {
                Pedido pedido = new Pedido(rs.getInt("id"),
                        rs.getFloat("total"),
                        EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id")),
                        EstadoFactory.create(rs.getString("estado"))
                );
                pedido.setCliente(ClienteDAO.getInstance().getCliente(rs.getInt("cliente_id")));
                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(rs.getInt("id"));
                pedido.setProdutos(produtos);

                pedidos.add(pedido);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return pedidos;
    }

    public ArrayList<Pedido> getPedidosCliente(int clienteId) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido where cliente_id ='" + clienteId + "'");

            while (rs.next()) {
                PedidoEstado pedidoEstado = EstadoFactory.create(rs.getString("estado"));
                Endereco endereco = EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id"));
                Pedido pedido = new Pedido(rs.getInt("id"),
                        rs.getFloat("total"),
                        endereco,
                        pedidoEstado
                );
                pedido.setCliente(ClienteDAO.getInstance().getCliente(rs.getInt("cliente_id")));
                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(rs.getInt("id"));
                pedido.setProdutos(produtos);

                pedidos.add(pedido);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return pedidos;
    }

    public ArrayList<Pedido> getPedidosEstabelecimento(int estabelecimentoId) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido,lista_produtos,produto,estabelecimento "
                    + "where pedido.id=lista_produtos.pedido_id and lista_produtos.produto_id=produto.id "
                    + "and produto.estabelecimento_id='" + estabelecimentoId + "'");

            while (rs.next()) {
                PedidoEstado pedidoEstado = EstadoFactory.create(rs.getString("estado"));
                Endereco endereco = EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id"));
                Pedido pedido = new Pedido(rs.getInt("id"),
                        rs.getFloat("total"),
                        EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id")),
                        EstadoFactory.create(rs.getString("estado"))
                );
                pedido.setCliente(ClienteDAO.getInstance().getCliente(rs.getInt("cliente_id")));
                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(rs.getInt("id"));
                pedido.setProdutos(produtos);

                pedidos.add(pedido);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return pedidos;
    }

    public Pedido getPedido(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Pedido pedido = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido where id ='" + id + "'");
            rs.first();

            pedido = new Pedido(rs.getInt("id"),
                    rs.getFloat("total"),
                    EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id")),
                    EstadoFactory.create(rs.getString("estado"))
            );
            pedido.setCliente(ClienteDAO.getInstance().getCliente(rs.getInt("cliente_id")));
            ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(rs.getInt("id"));
            pedido.setProdutos(produtos);

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return pedido;
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM pedido WHERE id='" + id + "'");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Pedido pedido, Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            String sql = "insert into pedido (total, estado,cliente_id,endereco_id)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setFloat(1, pedido.getTotal());
            comando.setString(2, pedido.getEstado().estadoString());
            comando.setInt(3, pedido.getCliente().getClienteId());
            comando.setInt(4, endereco.getId());

            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public static void update(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();

            String sql = "UPDATE pedido SET total=? WHERE id=?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setFloat(1, pedido.getTotal());
            comando.setInt(2, pedido.getId());

            comando.execute();

            comando.close();
            conn.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {

        }
    }

}
