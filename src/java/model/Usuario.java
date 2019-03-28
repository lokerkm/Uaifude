package model;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {

    private int id;
    private String login;
    private String senha;
    private String email;
    private String tipo;
    private String telefone;
    private String celular;
    private Endereco endereco;

    public Usuario(int id, String login, String senha, String email, String tipo, String telefone, String celular) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
        this.telefone = telefone;
        this.celular = celular;
    }

    public Usuario(int id, String login, String senha, String email, String tipo, String telefone, String celular, Endereco endereco) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
        this.telefone = telefone;
        this.celular = celular;
        this.endereco = endereco;
    }

    public int getUsuarioId() {
        return id;
    }

    public void setUsuarioId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public void update(Observable o, Object o1) {
    }
}
