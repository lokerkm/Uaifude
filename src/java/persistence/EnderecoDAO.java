package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;

public class EnderecoDAO {

    private static EnderecoDAO instance = new EnderecoDAO();

    public static EnderecoDAO getInstance() {
        return instance;
    }

    private EnderecoDAO() {
    }

    public List<Endereco> getEnderecos() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        List<Endereco> enderecos = new ArrayList<Endereco>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from endereco");

            while (rs.next()) {

                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"))
                        .setCep(rs.getString("cep"))
                        .setLogradouro(rs.getString("logradouro"))
                        .setNumero(rs.getString("numero"))
                        .setComplemento(rs.getString("complemento"))
                        .setBairro(rs.getString("bairro"))
                        .setCidade(rs.getString("cidade"))
                        .setEstado(rs.getString("estado"));

//                Endereco endereco = new Endereco(rs.getInt("id"),
//                        rs.getString("cep"),
//                        rs.getString("logradouro"),
//                        rs.getString("numero"),
//                        rs.getString("complemento"),
//                        rs.getString("bairro"),
//                        rs.getString("cidade"),
//                        rs.getString("estado")
//                );
                enderecos.add(endereco);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return enderecos;
    }

    public Endereco getEndereco(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Endereco endereco = new Endereco();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from endereco where id ='" + id + "'");
            rs.first();
            endereco.setId(rs.getInt("id"))
                    .setCep(rs.getString("cep"))
                    .setLogradouro(rs.getString("logradouro"))
                    .setNumero(rs.getString("numero"))
                    .setComplemento(rs.getString("complemento"))
                    .setBairro(rs.getString("bairro"))
                    .setCidade(rs.getString("cidade"))
                    .setEstado(rs.getString("estado"));
//            endereco = new Endereco(rs.getInt("id"),
//                    rs.getString("cep"),
//                    rs.getString("logradouro"),
//                    rs.getString("numero"),
//                    rs.getString("complemento"),
//                    rs.getString("bairro"),
//                    rs.getString("cidade"),
//                    rs.getString("estado")
//            );

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return endereco;
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM endereco WHERE id='" + id + "'");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public int save(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        int enderecoId = 0;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            String sql = "insert into endereco (logradouro,numero,complemento,bairro,cidade,estado,cep)"
                    + " VALUES (?,?,?,?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, endereco.getLogradouro());
            comando.setString(2, endereco.getNumero());
            comando.setString(3, endereco.getComplemento());
            comando.setString(4, endereco.getBairro());
            comando.setString(5, endereco.getCidade());
            comando.setString(6, endereco.getEstado());
            comando.setString(7, endereco.getCep());
            comando.execute();

            ResultSet rs = comando.getGeneratedKeys();

            if (rs != null && rs.next()) {
                enderecoId = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

        return enderecoId;
    }

    public static void update(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();

            String sql = "UPDATE endereco SET logradouro=?,numero=?,complemento=?,bairro=?,cidade=?,estado=?,cep=? WHERE id=?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, endereco.getLogradouro());
            comando.setString(2, endereco.getNumero());
            comando.setString(3, endereco.getComplemento());
            comando.setString(4, endereco.getBairro());
            comando.setString(5, endereco.getCidade());
            comando.setString(6, endereco.getEstado());
            comando.setString(7, endereco.getCep());
            comando.setInt(8, endereco.getId());

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
