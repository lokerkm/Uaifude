package model;

import java.sql.SQLException;
import persistence.AdministradorDAO;

public class Administrador {

    private int id;
    private String login;
    private String senha;

    public int getId() {
        return id;
    }

    public Administrador setId(int id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public Administrador setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Administrador setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public static Administrador obterAdministrador(String login) throws ClassNotFoundException, SQLException {
        return AdministradorDAO.getInstance().getAdministrador(login);
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        AdministradorDAO.getInstance().save(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        AdministradorDAO.getInstance().update(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        AdministradorDAO.getInstance().delete(this.getId());
    }
}
