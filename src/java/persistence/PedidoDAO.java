package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;

public class PedidoDAO {

    private static PedidoDAO instance = new PedidoDAO();

    public static PedidoDAO getInstance() {
        return instance;
    }

    public List<Pedido> getPedidos(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido");

            rs.first();
            while (rs.next()) {
                Pedido pedido = new Pedido(rs.getInt("id"),
                        rs.getFloat("total")
                        
                );
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
            ResultSet rs = st.executeQuery("select * from pedido where id =" + id + "");
            rs.first();

            pedido = new Pedido(rs.getInt("id"),
                        rs.getFloat("total")
                        
                );

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

    public void save(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
           

            String sql = "insert into pedido (total)"
                    + " VALUES (?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setFloat(1, pedido.getTotal());
           
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
