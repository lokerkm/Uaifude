package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoDAO {

    private static ProdutoDAO instance = new ProdutoDAO();

    public static ProdutoDAO getInstance() {
        return instance;
    }

    public List<Produto> getProdutos(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        List<Produto> produtos = new ArrayList<Produto>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from produto");

            rs.first();
            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        rs.getBoolean("disponivel"),
                        rs.getString("descricao")
                );
                produtos.add(produto);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return produtos;
    }

    public Produto getProduto(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Produto produto = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from produto where id =" + id + "");
            rs.first();

           produto = new Produto(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getFloat("preco"),
                        rs.getBoolean("disponivel"),
                        rs.getString("descricao")
                );

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return produto;
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM produto WHERE id='" + id + "'");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();

            String sql = "insert into produto (nome,preco,disponivel,descricao)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, produto.getNome());
            comando.setFloat(2, produto.getPreco());
            comando.setBoolean(3, produto.isDisponivel());
            comando.setString(4, produto.getDescricao());
           
            comando.execute();

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public static void update(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();

            String sql = "UPDATE produto SET nome=?,preco=?,disponivel=?,descricao=? WHERE id=?";
           
            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, produto.getNome());
            comando.setFloat(2, produto.getPreco());
            comando.setBoolean(3, produto.isDisponivel());
            comando.setString(4, produto.getDescricao());
            comando.setInt(5, produto.getId());

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
