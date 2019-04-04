package persistence;

import controller.PromocaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.promocao.Promocao;

public class PromocaoDAO {

    private static PromocaoDAO instance = new PromocaoDAO();

    public static PromocaoDAO getInstance() {
        return instance;
    }

    public List<Promocao> getPromocoes() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement st = null;
        List<Promocao> promocoes = new ArrayList<Promocao>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from promocao");

            while (rs.next()) {
                Promocao promocao
                        = PromocaoFactory.create(rs.getString("nome"));

                promocoes.add(promocao);

            }

        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return promocoes;
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
