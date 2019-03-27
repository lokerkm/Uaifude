package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Administrador;

public class AdministradorDAO {

    private static AdministradorDAO instance = new AdministradorDAO();

    public static AdministradorDAO getInstance() {
        return instance;
    }

    public Administrador getAdministrador(String login) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Administrador administrador = null;
        try {
            DatabaseLocator.getInstance().getConnection();
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from administrador where login ='" + login + "'");
            rs.first();

            administrador = new Administrador(rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("senha"));

        } catch (SQLException e) {

            return null;
        } finally {
            closeResources(conn, st);
        }
        return administrador;
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM administrador WHERE id='" + id + "'");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Administrador administrador) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql2 = "insert into administrador (id,login,senha)"
                    + " VALUES (?,?,?)";
            PreparedStatement comando2 = conn.prepareStatement(sql2);
            comando2.setInt(1, administrador.getId());
            comando2.setString(2, administrador.getLogin());
            comando2.setString(3, administrador.getSenha());

            comando2.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public static void update(Administrador administrador) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();

            String sql2 = "UPDATE administrador SET login=?,senha=? WHERE id=?";
            PreparedStatement comando2 = conn.prepareStatement(sql2);
            comando2.setString(1, administrador.getLogin());
            comando2.setString(2, administrador.getSenha());
            comando2.setInt(3, administrador.getId());

            comando2.execute();

            comando2.close();
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
