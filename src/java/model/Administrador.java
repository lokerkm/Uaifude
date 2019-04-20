package model;

public class Administrador {

    private int id;
    private String login;
    private String senha;

//    public Administrador(int id, String login, String senha) {
//        this.id = id;
//        this.login = login;
//        this.senha = senha;
//    }
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

}
