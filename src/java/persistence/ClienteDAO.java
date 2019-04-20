package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Endereco;

public class ClienteDAO {

    private static ClienteDAO instance = new ClienteDAO();

    public static ClienteDAO getInstance() {
        return instance;
    }

    private ClienteDAO() {
    }

    public List<Cliente> getClientes() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente,usuario where usuario.id = cliente.usuario_id");

            while (rs.next()) {
                Endereco endereco = EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id"));
                Cliente cliente = new Cliente();
                cliente.setClienteId(rs.getInt("cliente.id"))
                        .setNome(rs.getString("nome"))
                        .setCpf(rs.getString("cpf"))
                        .setNascimento(rs.getString("nascimento"))
                        .setUsuarioId(rs.getInt("usuario_id"))
                        .setLogin(rs.getString("login"))
                        .setSenha(rs.getString("senha"))
                        .setEmail(rs.getString("email"))
                        .setTipo(rs.getString("tipo"))
                        .setTelefone(rs.getString("telefone"))
                        .setCelular(rs.getString("celular"))
                        .setEndereco(endereco);

//                Cliente cliente = new Cliente(rs.getInt("cliente.id"),
//                        rs.getString("nome"),
//                        rs.getString("cpf"),
//                        rs.getString("nascimento"),
//                        rs.getInt("usuario_id"),
//                        rs.getString("login"),
//                        rs.getString("senha"),
//                        rs.getString("email"),
//                        rs.getString("tipo"),
//                        rs.getString("telefone"),
//                        rs.getString("celular"), endereco);
                clientes.add(cliente);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return clientes;
    }

    public Cliente getCliente(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Cliente cliente = new Cliente();;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente,usuario where cliente.id ='" + id + "' and cliente.usuario_id=usuario.id");
            rs.first();

            Endereco endereco = EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id"));

            cliente.setClienteId(rs.getInt("cliente.id"))
                    .setNome(rs.getString("nome"))
                    .setCpf(rs.getString("cpf"))
                    .setNascimento(rs.getString("nascimento"))
                    .setUsuarioId(rs.getInt("usuario_id"))
                    .setLogin(rs.getString("login"))
                    .setSenha(rs.getString("senha"))
                    .setEmail(rs.getString("email"))
                    .setTipo(rs.getString("tipo"))
                    .setTelefone(rs.getString("telefone"))
                    .setCelular(rs.getString("celular"))
                    .setEndereco(endereco);
//            cliente = new Cliente(rs.getInt("cliente.id"),
//                    rs.getString("nome"),
//                    rs.getString("cpf"),
//                    rs.getString("nascimento"),
//                    rs.getInt("usuario_id"),
//                    rs.getString("login"),
//                    rs.getString("senha"),
//                    rs.getString("email"),
//                    rs.getString("tipo"),
//                    rs.getString("telefone"),
//                    rs.getString("celular"), endereco);

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return cliente;
    }

    public Cliente getCliente(String login) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Cliente cliente = new Cliente();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente,usuario where login ='" + login + "' and cliente.usuario_id=usuario.id");
            rs.first();
            Endereco endereco = EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id"));

            cliente.setClienteId(rs.getInt("cliente.id"))
                    .setNome(rs.getString("nome"))
                    .setCpf(rs.getString("cpf"))
                    .setNascimento(rs.getString("nascimento"))
                    .setUsuarioId(rs.getInt("usuario_id"))
                    .setLogin(rs.getString("login"))
                    .setSenha(rs.getString("senha"))
                    .setEmail(rs.getString("email"))
                    .setTipo(rs.getString("tipo"))
                    .setTelefone(rs.getString("telefone"))
                    .setCelular(rs.getString("celular"))
                    .setEndereco(endereco);
//            cliente = new Cliente(rs.getInt("cliente.id"),
//                    rs.getString("nome"),
//                    rs.getString("cpf"),
//                    rs.getString("nascimento"),
//                    rs.getInt("usuario_id"),
//                    rs.getString("login"),
//                    rs.getString("senha"),
//                    rs.getString("email"),
//                    rs.getString("tipo"),
//                    rs.getString("telefone"),
//                    rs.getString("celular"), endereco);

        } catch (SQLException e) {
            return null;
        } finally {
            closeResources(conn, st);
        }
        return cliente;
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM cliente WHERE usuario_id='" + id + "'");
            st.execute("DELETE FROM usuario WHERE id='" + id + "'");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "insert into usuario (login,senha,tipo,email,telefone,celular,endereco_id)"
                    + " VALUES (?,?,?,?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, cliente.getLogin());
            comando.setString(2, cliente.getSenha());
            comando.setString(3, cliente.getTipo());
            comando.setString(4, cliente.getEmail());
            comando.setString(5, cliente.getTelefone());
            comando.setString(6, cliente.getCelular());
            comando.setInt(7, cliente.getEndereco().getId());
            comando.execute();
            ResultSet rs = comando.getGeneratedKeys();
            int usuarioId = 0;
            if (rs != null && rs.next()) {
                usuarioId = rs.getInt(1);
            }

            String sql2 = "insert into cliente (nome,cpf,nascimento,usuario_id)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement comando2 = conn.prepareStatement(sql2);
            comando2.setString(1, cliente.getNome());
            comando2.setString(2, cliente.getCpf());
            comando2.setString(3, cliente.getNascimento());
            comando2.setInt(4, usuarioId);
            comando2.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public static void update(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "UPDATE usuario SET login=?,senha=?,tipo=?,email=?,telefone=?, celular=?, endereco_id=? WHERE id=?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, cliente.getLogin());
            comando.setString(2, cliente.getSenha());
            comando.setString(3, cliente.getTipo());
            comando.setString(4, cliente.getEmail());
            comando.setString(5, cliente.getTelefone());
            comando.setString(6, cliente.getCelular());
            comando.setInt(7, cliente.getEndereco().getId());
            comando.setInt(8, cliente.getUsuarioId());
            comando.execute();

            String sql2 = "UPDATE cliente SET nome=?,cpf=?,nascimento=? WHERE id=?";
            PreparedStatement comando2 = conn.prepareStatement(sql2);
            comando2.setString(1, cliente.getNome());
            comando2.setString(2, cliente.getCpf());
            comando2.setString(3, cliente.getNascimento());
            comando2.setInt(4, cliente.getClienteId());

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
