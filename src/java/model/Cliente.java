package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import persistence.ClienteDAO;

public class Cliente extends Usuario {

    private int id;
    private String nome;
    private String cpf;
    private String nascimento;

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

    public static Cliente obterCliente(String login) throws ClassNotFoundException, SQLException {
        return ClienteDAO.getInstance().getCliente(login);
    }

    public static ArrayList<Cliente> obterClientes() throws ClassNotFoundException, SQLException {
        return ClienteDAO.getInstance().getClientes();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        ClienteDAO.getInstance().save(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        ClienteDAO.getInstance().update(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        ClienteDAO.getInstance().delete(this.getClienteId());
    }
}
