package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Combo;
import model.Produto;

public class ComboDAO {

    private static ComboDAO instance = new ComboDAO();

    public static ComboDAO getInstance() {
        return instance;
    }

    private ComboDAO() {
    }

    public ArrayList<Combo> getCombos() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Combo> combos = new ArrayList<>();
        try {
            DatabaseLocator.getInstance().getConnection();
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from combo");
            while (rs.next()) {
                Combo combo = new Combo();
                combo.setId(rs.getInt("id")).setNome(rs.getString("nome")).setIdEstabelecimento(rs.getInt("estabelecimento_id"));
                combo.setProdutos(ProdutoDAO.getInstance().getProdutosCombo(rs.getInt("id")));
                combos.add(combo);
            }

        } catch (SQLException e) {

            return null;
        } finally {
            closeResources(conn, st);
        }
        return combos;
    }

    public ArrayList<Combo> getCombosEstabelecimento(int idEstabelecimento) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        ArrayList<Combo> combos = new ArrayList<>();
        try {
            DatabaseLocator.getInstance().getConnection();
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM combo WHERE estabelecimento_id='" + idEstabelecimento + "'");
            while (rs.next()) {
                Combo combo = new Combo();
                combo.setId(rs.getInt("id")).setNome(rs.getString("nome"));
                combo.setProdutos(ProdutoDAO.getInstance().getProdutosCombo(rs.getInt("id"))).setIdEstabelecimento(rs.getInt("estabelecimento_id"));
                combos.add(combo);
            }

        } catch (SQLException e) {

            return null;
        } finally {
            closeResources(conn, st);
        }
        return combos;
    }

    public Combo getCombo(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        Combo combo = new Combo();;
        try {
            DatabaseLocator.getInstance().getConnection();
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from combo where combo.id ='" + id + "'");
            rs.first();
            combo = new Combo();
            combo.setId(rs.getInt("id")).setNome(rs.getString("nome")).setIdEstabelecimento(rs.getInt("estabelecimento_id"));
            combo.setProdutos(ProdutoDAO.getInstance().getProdutosCombo(id));

        } catch (SQLException e) {

            return null;
        } finally {
            closeResources(conn, st);
        }
        return combo;
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM combo WHERE id='" + id + "'");
            st.execute("DELETE FROM lista_produtos_combo where id_combo='" + id + "'");

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }

    public void save(Combo combo) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            String sql2 = "insert into combo (nome,estabelecimento_id)"
                    + " VALUES (?,?)";
            PreparedStatement comando2 = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
            comando2.setString(1, combo.getNome());
            comando2.setInt(2, combo.getIdEstabelecimento());

            comando2.execute();
            ResultSet rs = comando2.getGeneratedKeys();
            int comboId = 0;
            if (rs != null && rs.next()) {
                comboId = rs.getInt(1);
            }
            for (Produto produto : combo.getProdutos()) {

                String sql = "insert into lista_produtos_combo (id_produto, id_combo)"
                        + " VALUES (?,?)";
                PreparedStatement comando = conn.prepareStatement(sql);
                comando.setInt(1, produto.getId());
                comando.setInt(2, comboId);
                comando.execute();
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }

    }

    public static void update(Combo combo) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();

            String sql = "UPDATE combo SET nome=? WHERE id=?";

            PreparedStatement comando = conn.prepareStatement(sql);
            comando.setString(1, combo.getNome());
            comando.setFloat(2, combo.getId());

            comando.execute();

            String sql2 = "DELETE FROM lista_produtos_combo WHERE id_combo=?";

            PreparedStatement comando2 = conn.prepareStatement(sql2);
            comando2.setInt(1, combo.getId());
            comando2.execute();
            for (Produto produto : combo.getProdutos()) {

                String sql3 = "insert into lista_produtos_combo (id_produto, id_combo)"
                        + " VALUES (?,?)";
                PreparedStatement comando3 = conn.prepareStatement(sql3);
                comando3.setInt(1, produto.getId());
                comando3.setInt(2, combo.getId());
                comando3.execute();
            }
            comando.close();
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
