package model;

import java.util.Observable;

public class Cliente extends Usuario {

    private int id;
    private String nome;
    private String cpf;
    private String nascimento;

//    public Cliente(String nome, String cpf, String nascimento, String login, String senha, String email, String tipo, String telefone, String celular, Endereco endereco) {
//        super(login, senha, email, tipo, telefone, celular, endereco);
//
//        this.nome = nome;
//        this.cpf = cpf;
//        this.nascimento = nascimento;
//
//    }
//
//    public Cliente(int id, String nome, String cpf, String nascimento, int usuarioId, String login, String senha, String email, String tipo, String telefone, String celular, Endereco endereco) {
//        super(usuarioId, login, senha, email, tipo, telefone, celular, endereco);
//        this.id = id;
//        this.nome = nome;
//        this.cpf = cpf;
//        this.nascimento = nascimento;
//
//    }

    public int getClienteId() {
        return id;
    }

    public Cliente setClienteId(int id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Cliente setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getNascimento() {
        return nascimento;
    }

    public Cliente setNascimento(String nascimento) {
        this.nascimento = nascimento;
        return this;
    }

    @Override
    public void update(Observable observable, Object arg1) {
        if (observable instanceof Pedido) {
            Pedido pedido = (Pedido) observable;
            System.out.println("Email enviado para o cliente " + this.nome + " com o email " + this.getEmail() + ", o pedido  numero "
                    + pedido.getId() + " está no estado de " + pedido.getEstado().estadoString());
        }
    }
}
