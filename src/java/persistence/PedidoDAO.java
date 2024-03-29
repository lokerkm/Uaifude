package persistence;

import controller.Factory;
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

    private PedidoDAO() {
    }

//    public int getNextId() throws ClassNotFoundException, SQLException {
//        Connection conn = null;
//        Statement st = null;
//        int idNext;
//        try {
//            conn = DatabaseLocator.getInstance().getConnection();
//            st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM `pedido` WHERE 1 ORDER BY `pedido`.`id` DESC");
//            rs.first();
//            idNext = rs.getInt("id");
//        } catch (SQLException e) {
//            throw e;
//        } finally {
//            closeResources(conn, st);
//        }
//        return idNext + 1;
//    }
    public ArrayList<Pedido> getPedidos() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido");

            while (rs.next()) {
                Pedido pedido = new Pedido();
                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(rs.getInt("id"));
                pedido.setId(rs.getInt("id"))
                        .setTotal(rs.getFloat("total"))
                        .setEndereco(EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id")))
                        .setEstado(Factory.createPedidoEstado(rs.getString("estado")))
                        .setEstabelecimentoId(rs.getInt("estabelecimento_id"))
                        .setCliente(ClienteDAO.getInstance().getCliente(rs.getInt("cliente_id")))
                        .setProdutos(produtos);

//                Pedido pedido = new Pedido(rs.getInt("id"),
//                        rs.getFloat("total"),
//                        EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id")),
//                        Factory.createPedidoEstado(rs.getString("estado")),
//                        rs.getInt("estabelecimento_id")
//                );
//                pedido.setCliente(ClienteDAO.getInstance().getCliente(rs.getInt("cliente_id")));
//                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(rs.getInt("id"));
//                pedido.setProdutos(produtos);
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
//                PedidoEstado pedidoEstado = Factory.createPedidoEstado(rs.getString("estado"));
//                Endereco endereco = EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id"));
//                Pedido pedido = new Pedido(rs.getInt("id"),
//                        rs.getFloat("total"),
//                        endereco,
//                        pedidoEstado,
//                        rs.getInt("estabelecimento_id")
//                );
//                pedido.setCliente(ClienteDAO.getInstance().getCliente(rs.getInt("cliente_id")));
//                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(rs.getInt("id"));
//                pedido.setProdutos(produtos);
                Pedido pedido = new Pedido();
                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(rs.getInt("id"));
                pedido.setId(rs.getInt("id"))
                        .setTotal(rs.getFloat("total"))
                        .setEndereco(EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id")))
                        .setEstado(Factory.createPedidoEstado(rs.getString("estado")))
                        .setEstabelecimentoId(rs.getInt("estabelecimento_id"))
                        .setCliente(ClienteDAO.getInstance().getCliente(rs.getInt("cliente_id")))
                        .setProdutos(produtos);
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
            ResultSet rs = st.executeQuery("select * from pedido "
                    + "where pedido.estabelecimento_id='" + estabelecimentoId + "'");

            while (rs.next()) {
//                PedidoEstado pedidoEstado = Factory.createPedidoEstado(rs.getString("estado"));
//                Endereco endereco = EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id"));
//                Pedido pedido = new Pedido(rs.getInt("id"),
//                        rs.getFloat("total"),
//                        endereco,
//                        pedidoEstado,
//                        rs.getInt("estabelecimento_id")
//                );
//
//                pedido.setCliente(ClienteDAO.getInstance().getCliente(rs.getInt("cliente_id")));
//                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(rs.getInt("id"));
//                pedido.setProdutos(produtos);
                Pedido pedido = new Pedido();
                ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(rs.getInt("id"));
                pedido.setId(rs.getInt("id"))
                        .setTotal(rs.getFloat("total"))
                        .setEndereco(EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id")))
                        .setEstado(Factory.createPedidoEstado(rs.getString("estado")))
                        .setEstabelecimentoId(rs.getInt("estabelecimento_id"))
                        .setCliente(ClienteDAO.getInstance().getCliente(rs.getInt("cliente_id")))
                        .setProdutos(produtos);
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
        Pedido pedido = new Pedido();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido where id ='" + id + "'");
            rs.first();

            ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(rs.getInt("id"));
            pedido.setId(rs.getInt("id"))
                    .setTotal(rs.getFloat("total"))
                    .setEndereco(EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id")))
                    .setEstado(Factory.createPedidoEstado(rs.getString("estado")))
                    .setEstabelecimentoId(rs.getInt("estabelecimento_id"))
                    .setCliente(ClienteDAO.getInstance().getCliente(rs.getInt("cliente_id")))
                    .setProdutos(produtos);
//            pedido = new Pedido(rs.getInt("id"),
//                    rs.getFloat("total"),
//                    EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id")),
//                    Factory.createPedidoEstado(rs.getString("estado")), rs.getInt("estabelecimento_id")
//            );
//            pedido.setCliente(ClienteDAO.getInstance().getCliente(rs.getInt("cliente_id")));
//            ArrayList<Produto> produtos = ProdutoDAO.getInstance().getProdutosPedido(rs.getInt("id"));
//            pedido.setProdutos(produtos);

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

            String sql = "insert into pedido (total, estado,cliente_id,endereco_id,estabelecimento_id)"
                    + " VALUES (?,?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            comando.setFloat(1, pedido.getTotal());
            comando.setString(2, pedido.getEstado().estadoString());
            comando.setInt(3, pedido.getCliente().getClienteId());
            comando.setInt(4, endereco.getId());
            comando.setInt(5, pedido.getEstabelecimentoId());

            comando.execute();

            ResultSet rs = comando.getGeneratedKeys();
            int pedidoId = 0;
            if (rs != null && rs.next()) {
                pedidoId = rs.getInt(1);
            }

            for (Produto produto : pedido.getProdutos()) {
                String sql2 = "insert into lista_produtos (produto_id, pedido_id, quantidade)"
                        + " VALUES (?,?,1)";
                PreparedStatement comando2 = conn.prepareStatement(sql2);
                comando2.setFloat(1, produto.getId());
                comando2.setInt(2, pedidoId);

                comando2.execute();
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

//    public int getLastId() throws ClassNotFoundException, SQLException {
//        Connection conn = null;
//        Statement st = null;
//        int idNext;
//        try {
//            conn = DatabaseLocator.getInstance().getConnection();
//            st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM `pedido` WHERE 1 ORDER BY `pedido`.`id` DESC");
//            rs.first();
//            idNext = rs.getInt("id");
//        } catch (SQLException e) {
//            throw e;
//        } finally {
//            closeResources(conn, st);
//        }
//        return idNext;
//    }
    public static void update(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();

            String sql = "UPDATE pedido SET total=?,estado=? WHERE id=?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setFloat(1, pedido.getTotal());
            comando.setString(2, pedido.getEstado().estadoString());
            comando.setInt(3, pedido.getId());

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
