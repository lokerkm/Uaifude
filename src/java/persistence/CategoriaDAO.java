package persistence;

import controller.Factory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

public class CategoriaDAO {

    private static CategoriaDAO instance = new CategoriaDAO();

    public static CategoriaDAO getInstance() {
        return instance;
    }

    private CategoriaDAO() {
    }

    public List<Categoria> getCategorias() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        List<Categoria> categorias = new ArrayList<Categoria>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from categoria");

            while (rs.next()) {
                Categoria categoria = Factory.createCategoria(rs.getString("nome"));
                categoria.setNome(rs.getString("nome")).setId(rs.getInt("id"));

                categorias.add(categoria);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return categorias;
    }

    ;
//    
    public Categoria getCategoria(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Categoria categoria = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from categoria where id ='" + id + "'");
            rs.first();
            categoria = Factory.createCategoria(rs.getString("nome"));
            categoria.setNome(rs.getString("nome")).setId(rs.getInt("id"));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return categoria;
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM categoria WHERE id='" + id + "'");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Categoria categoria) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "insert into categoria (nome)"
                    + " VALUES (?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, categoria.getNome());

            comando.execute();
            comando.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public static void update(Categoria categoria) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "UPDATE categoria SET nome=? WHERE id=?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, categoria.getNome());
            comando.setInt(2, categoria.getId());

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
