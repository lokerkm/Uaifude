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

//    public Usuario(int id, String login, String senha, String email, String tipo, String telefone, String celular) {
//        this.id = id;
//        this.login = login;
//        this.senha = senha;
//        this.email = email;
//        this.tipo = tipo;
//        this.telefone = telefone;
//        this.celular = celular;
//    }
//
//    public Usuario(String login, String senha, String email, String tipo, String telefone, String celular, Endereco endereco) {
//
//        this.login = login;
//        this.senha = senha;
//        this.email = email;
//        this.tipo = tipo;
//        this.telefone = telefone;
//        this.celular = celular;
//        this.endereco = endereco;
//    }
//
//    public Usuario(int id, String login, String senha, String email, String tipo, String telefone, String celular, Endereco endereco) {
//        this.id = id;
//        this.login = login;
//        this.senha = senha;
//        this.email = email;
//        this.tipo = tipo;
//        this.telefone = telefone;
//        this.celular = celular;
//        this.endereco = endereco;
//    }

    public int getUsuarioId() {
        return id;
    }

    public Usuario setUsuarioId(int id) {
        this.id = id;
    return this;}

    public String getLogin() {
        return login;
    }

    public Usuario setLogin(String login) {
        this.login = login;
    return this;}

    public String getSenha() {
        return senha;
    }

    public Usuario setSenha(String senha) {
        this.senha = senha;
    return this;}

    public String getEmail() {
        return email;
    }

    public Usuario setEmail(String email) {
        this.email = email;
    return this;}

    public String getTipo() {
        return tipo;
    }

    public Usuario setTipo(String tipo) {
        this.tipo = tipo;
    return this;}

    public String getTelefone() {
        return telefone;
    }

    public Usuario setTelefone(String telefone) {
        this.telefone = telefone;
    return this;}

    public String getCelular() {
        return celular;
    }

    public Usuario setCelular(String celular) {
        this.celular = celular;
    return this;}

    public Endereco getEndereco() {
        return endereco;
    }

    public Usuario setEndereco(Endereco endereco) {
        this.endereco = endereco;
    return this;}

    @Override
    public void update(Observable o, Object o1) {
    }
}
