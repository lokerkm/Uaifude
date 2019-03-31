package model;

import java.util.ArrayList;
import java.util.Observable;

import model.pedidoEstado.PedidoEstado;

public class Pedido extends Observable {

    private int id;
    private PedidoEstado estado;
    private Endereco endereco;
    private Cliente cliente;
    private float total;
    private ArrayList<Produto> produtos = new ArrayList<>();

    public Pedido(float total, Endereco endereco, PedidoEstado estado) {

        this.estado = estado;
        this.endereco = endereco;
        this.total = total;
    }

    public Pedido(int id, float total, Endereco endereco, PedidoEstado estado) {
        this.id = id;
        this.estado = estado;
        this.endereco = endereco;
        this.total = total;
    }

    public Pedido(int id, float total) {
        this.id = id;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
        this.total += produto.getPreco();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void removeProduto(int idProduto) {
        for (Produto produto : produtos) {
            if (produto.getId() == idProduto) {
                float precoAUX = produto.getPreco();
                total -= precoAUX;
                produtos.remove(produto);
                break;
            }

        }
    }

}
