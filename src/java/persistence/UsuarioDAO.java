package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {

    private static UsuarioDAO instance = new UsuarioDAO();

    public static UsuarioDAO getInstance() {
        return instance;
    }

    public List<Usuario> getUsuarios() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        List<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from usuario");

            rs.first();
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("id"),
                    
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("email"),
                    rs.getString("tipo"),
                    rs.getString("telefone"),
                    rs.getString("celular"));
                usuarios.add(usuario);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return usuarios;
    }

    public Usuario getUsuario(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Usuario usuario = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from usuario where id ='" + id + "'");
            rs.first();

            usuario = new Usuario(rs.getInt("id"),
                    
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getString("email"),
                    rs.getString("tipo"),
                    rs.getString("telefone"),
                    rs.getString("celular"));

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return usuario;
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM usuario WHERE id='" + id + "'");
            

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "insert into usuario (login,senha,tipo,email,telefone,celular,endereco_id)"
                    + " VALUES (?,?,?,?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, usuario.getLogin());
            comando.setString(2, usuario.getSenha());
            comando.setString(3, usuario.getTipo());
            comando.setString(4, usuario.getEmail());
            comando.setString(5, usuario.getTelefone());
            comando.setString(6, usuario.getCelular());
            comando.setInt(7, usuario.getEndereco().getId());
            comando.execute();

           

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public static void update(Usuario usuario) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "UPDATE usuario SET login=?,senha=?,tipo=?,email=?,telefone=?, celular=?, endereco_id=? WHERE id=?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, usuario.getLogin());
            comando.setString(2, usuario.getSenha());
            comando.setString(3, usuario.getTipo());
            comando.setString(4, usuario.getEmail());
            comando.setString(5, usuario.getTelefone());
            comando.setString(6, usuario.getCelular());
            comando.setInt(7, usuario.getEndereco().getId());
            comando.setInt(8, usuario.getUsuarioId()); 
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
