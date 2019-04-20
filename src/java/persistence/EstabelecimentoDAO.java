package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;
import model.Estabelecimento;
import model.Pedido;
import model.Produto;

public class EstabelecimentoDAO {

    private static EstabelecimentoDAO instance = new EstabelecimentoDAO();

    public static EstabelecimentoDAO getInstance() {
        return instance;
    }

    private EstabelecimentoDAO() {
    }

    public ArrayList<Estabelecimento> getEstabelecimentos() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Estabelecimento> estabelecimentos = new ArrayList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from estabelecimento,usuario where usuario.id = estabelecimento.usuario_id");

            while (rs.next()) {
                Endereco endereco = EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id"));
                Estabelecimento estabelecimento = new Estabelecimento();
                estabelecimento.setEstabelecimentoId(rs.getInt("estabelecimento.id"))
                        .setNome(rs.getString("nome"))
                        .setCnpj(rs.getString("cnpj"))
                        .setDescricao(rs.getString("descricao"))
                        .setLinkImagem(rs.getString("linkImagem"))
                        .setCategoria(CategoriaDAO.getInstance().getCategoria(rs.getInt("categoria_id")))
                        .setUsuarioId(rs.getInt("usuario_id"))
                        .setLogin(rs.getString("login"))
                        .setSenha(rs.getString("senha"))
                        .setEmail(rs.getString("email"))
                        .setTipo(rs.getString("tipo"))
                        .setTelefone(rs.getString("telefone"))
                        .setCelular(rs.getString("celular"))
                        .setEndereco(endereco);
                //                Estabelecimento estabelecimento = new Estabelecimento(rs.getInt("id"),
                //                        rs.getString("nome"),
                //                        rs.getString("cnpj"),
                //                        rs.getString("descricao"),
                //                        rs.getInt("usuario_id"),
                //                        rs.getString("login"),
                //                        rs.getString("senha"),
                //                        rs.getString("email"),
                //                        rs.getString("tipo"),
                //                        rs.getString("telefone"),
                //                        rs.getString("celular"),
                //                        rs.getString("linkImagem"));
//                estabelecimento.setCategoria(CategoriaDAO.getInstance().getCategoria(rs.getInt("categoria_id")));

//                estabelecimento.setEndereco(endereco);
                estabelecimentos.add(estabelecimento);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return estabelecimentos;
    }

    public ArrayList<Estabelecimento> getEstabelecimentosCategoria(int idCategoria) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Estabelecimento> estabelecimentos = new ArrayList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from estabelecimento,usuario where usuario.id = estabelecimento.usuario_id"
                    + " and estabelecimento.categoria_id = '" + idCategoria + "'");

            while (rs.next()) {
                Endereco endereco = EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id"));
                Estabelecimento estabelecimento = new Estabelecimento();
                estabelecimento.setEstabelecimentoId(rs.getInt("estabelecimento.id"))
                        .setNome(rs.getString("nome"))
                        .setCnpj(rs.getString("cnpj"))
                        .setDescricao(rs.getString("descricao"))
                        .setLinkImagem(rs.getString("linkImagem"))
                        .setCategoria(CategoriaDAO.getInstance().getCategoria(rs.getInt("categoria_id")))
                        .setUsuarioId(rs.getInt("usuario_id"))
                        .setLogin(rs.getString("login"))
                        .setSenha(rs.getString("senha"))
                        .setEmail(rs.getString("email"))
                        .setTipo(rs.getString("tipo"))
                        .setTelefone(rs.getString("telefone"))
                        .setCelular(rs.getString("celular"))
                        .setEndereco(endereco);
//                Estabelecimento estabelecimento = new Estabelecimento(rs.getInt("estabelecimento.id"),
//                        rs.getString("nome"),
//                        rs.getString("cnpj"),
//                        rs.getString("descricao"),
//                        rs.getInt("usuario_id"),
//                        rs.getString("login"),
//                        rs.getString("senha"),
//                        rs.getString("email"),
//                        rs.getString("tipo"),
//                        rs.getString("telefone"),
//                        rs.getString("celular"),
//                        rs.getString("linkImagem"));
//                estabelecimento.setCategoria(CategoriaDAO.getInstance().getCategoria(rs.getInt("categoria_id")));
//
//                estabelecimento.setEndereco(endereco);
                estabelecimentos.add(estabelecimento);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return estabelecimentos;
    }

    public Estabelecimento getEstabelecimento(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Estabelecimento estabelecimento = new Estabelecimento();;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from estabelecimento,usuario where estabelecimento.id ='" + id
                    + "' and estabelecimento.usuario_id=usuario.id");
            rs.first();
            Endereco endereco = EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id"));
            estabelecimento.setEstabelecimentoId(rs.getInt("estabelecimento.id"))
                    .setNome(rs.getString("nome"))
                    .setCnpj(rs.getString("cnpj"))
                    .setDescricao(rs.getString("descricao"))
                    .setLinkImagem(rs.getString("linkImagem"))
                    .setCategoria(CategoriaDAO.getInstance().getCategoria(rs.getInt("categoria_id")))
                    .setProdutos(ProdutoDAO.getInstance().getProdutos(rs.getInt("estabelecimento.id")))
                    .setUsuarioId(rs.getInt("usuario_id"))
                    .setLogin(rs.getString("login"))
                    .setSenha(rs.getString("senha"))
                    .setEmail(rs.getString("email"))
                    .setTipo(rs.getString("tipo"))
                    .setTelefone(rs.getString("telefone"))
                    .setCelular(rs.getString("celular"))
                    .setEndereco(endereco);
//            estabelecimento = new Estabelecimento(rs.getInt("estabelecimento.id"),
//                    rs.getString("nome"),
//                    rs.getString("cnpj"),
//                    rs.getString("descricao"),
//                    rs.getInt("usuario_id"),
//                    rs.getString("login"),
//                    rs.getString("senha"),
//                    rs.getString("email"),
//                    rs.getString("tipo"),
//                    rs.getString("telefone"),
//                    rs.getString("celular"),
//                    rs.getString("linkImagem"));
//            estabelecimento.setCategoria(CategoriaDAO.getInstance().getCategoria(rs.getInt("categoria_id")));
//            estabelecimento.setEndereco(endereco);
//            estabelecimento.setProdutos(ProdutoDAO.getInstance().getProdutos(rs.getInt("estabelecimento.id")));
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return estabelecimento;
    }

    public Estabelecimento getEstabelecimento(String login) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Estabelecimento estabelecimento = new Estabelecimento();;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from estabelecimento,usuario where login ='" + login + "' and estabelecimento.usuario_id=usuario.id");
            rs.first();
            Endereco endereco = EnderecoDAO.getInstance().getEndereco(rs.getInt("endereco_id"));
            estabelecimento.setEstabelecimentoId(rs.getInt("estabelecimento.id"))
                    .setNome(rs.getString("nome"))
                    .setCnpj(rs.getString("cnpj"))
                    .setDescricao(rs.getString("descricao"))
                    .setLinkImagem(rs.getString("linkImagem"))
                    .setCategoria(CategoriaDAO.getInstance().getCategoria(rs.getInt("categoria_id")))
                    .setProdutos(ProdutoDAO.getInstance().getProdutos(rs.getInt("estabelecimento.id")))
                    .setUsuarioId(rs.getInt("usuario_id"))
                    .setLogin(rs.getString("login"))
                    .setSenha(rs.getString("senha"))
                    .setEmail(rs.getString("email"))
                    .setTipo(rs.getString("tipo"))
                    .setTelefone(rs.getString("telefone"))
                    .setCelular(rs.getString("celular"))
                    .setEndereco(endereco);
//            estabelecimento = new Estabelecimento(rs.getInt("estabelecimento.id"),
//                    rs.getString("nome"),
//                    rs.getString("cnpj"),
//                    rs.getString("descricao"),
//                    rs.getInt("usuario_id"),
//                    rs.getString("login"),
//                    rs.getString("senha"),
//                    rs.getString("email"),
//                    rs.getString("tipo"),
//                    rs.getString("telefone"),
//                    rs.getString("celular"),
//                    rs.getString("linkImagem"));
//            estabelecimento.setCategoria(CategoriaDAO.getInstance().getCategoria(rs.getInt("categoria_id")));
//            estabelecimento.setEndereco(endereco);
        } catch (SQLException e) {
            return null;
        } finally {
            closeResources(conn, st);
        }
        return estabelecimento;
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM estabelecimento WHERE usuario_id='" + id + "'");
            st.execute("DELETE FROM usuario WHERE id='" + id + "'");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Estabelecimento estabelecimento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql = "insert into usuario (login,senha,tipo,email,telefone,celular,endereco_id)"
                    + " VALUES (?,?,?,?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            comando.setString(1, estabelecimento.getLogin());
            comando.setString(2, estabelecimento.getSenha());
            comando.setString(3, estabelecimento.getTipo());
            comando.setString(4, estabelecimento.getEmail());
            comando.setString(5, estabelecimento.getTelefone());
            comando.setString(6, estabelecimento.getCelular());
            comando.setInt(7, estabelecimento.getEndereco().getId());
            comando.execute();

            ResultSet rs = comando.getGeneratedKeys();
            int usuarioId = 0;
            if (rs != null && rs.next()) {
                usuarioId = rs.getInt(1);
            }

            String sql2 = "insert into estabelecimento (nome,cnpj,descricao,usuario_id,linkImagem,categoria_id)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement comando2 = conn.prepareStatement(sql2);
            comando2.setString(1, estabelecimento.getNome());
            comando2.setString(2, estabelecimento.getCnpj());
            comando2.setString(3, estabelecimento.getDescricao());
            comando2.setInt(4, usuarioId);
            comando2.setString(5, estabelecimento.getLinkImagem());
            comando2.setInt(6, estabelecimento.getCategoria().getId());
            comando2.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public static void update(Estabelecimento estabelecimento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            String sql = "UPDATE usuario SET login=?,senha=?,tipo=?,email=?,telefone=?, celular=?, endereco_id=? WHERE id=?";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, estabelecimento.getLogin());
            comando.setString(2, estabelecimento.getSenha());
            comando.setString(3, estabelecimento.getTipo());
            comando.setString(4, estabelecimento.getEmail());
            comando.setString(5, estabelecimento.getTelefone());
            comando.setString(6, estabelecimento.getCelular());
            comando.setInt(7, estabelecimento.getEndereco().getId());
            comando.setInt(8, estabelecimento.getUsuarioId());
            comando.execute();

            String sql2 = "UPDATE estabelecimento SET nome=?,cnpj=?,descricao=?, linkImagem=? WHERE id=?";
            PreparedStatement comando2 = conn.prepareStatement(sql2);
            comando2.setString(1, estabelecimento.getNome());
            comando2.setString(2, estabelecimento.getCnpj());
            comando2.setString(3, estabelecimento.getDescricao());
            comando2.setString(4, estabelecimento.getLinkImagem());
            comando2.setInt(5, estabelecimento.getEstabelecimentoId());

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
