package model;

import java.util.ArrayList;
import java.util.Observable;

public class Cliente extends Usuario {

    private int id;
    private String nome;
    private String cpf;
    private String nascimento;

    public Cliente(int id, String nome, String cpf, String nascimento, int usuarioId, String login, String senha, String email, String tipo, String telefone, String celular, Endereco endereco) {
        super(usuarioId, login, senha, email, tipo, telefone, celular, endereco);
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;

    }

    public int getClienteId() {
        return id;
    }

    public void setClienteId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

}
