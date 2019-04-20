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
    private int estabelecimentoId;

//    public Pedido(float total, Endereco endereco, PedidoEstado estado, int estabelecimentoId) {
//        this.estabelecimentoId = estabelecimentoId;
//        this.estado = estado;
//        this.endereco = endereco;
//        this.total = total;
//
//    }
//
//    public Pedido(int id, float total, Endereco endereco, PedidoEstado estado, int estabelecimentoId) {
//        this.estabelecimentoId = estabelecimentoId;
//        this.id = id;
//        this.estado = estado;
//        this.endereco = endereco;
//        this.total = total;
//    }
//
//    public Pedido(int id, float total) {
//        this.id = id;
//        this.total = total;
//    }
    public int getId() {
        return id;
    }

    public Pedido setId(int id) {
        this.id = id;
        return this;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public Pedido setEstado(PedidoEstado estado) {

        this.estado = estado;
        return this;
    }

    public float getTotal() {
        return total;
    }

    public Pedido setTotal(float total) {
        this.total = total;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Pedido setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public Pedido setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
        return this;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
        this.total += produto.getPrecoPosPromocao();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pedido setCliente(Cliente cliente) {
        this.cliente = cliente;
        addObserver(cliente);
        return this;
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

    public int getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public Pedido setEstabelecimentoId(int estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
        return this;
    }

    public String toCarrinho() {
        return estado.toCarrinho(this);
    }

    public String toConfirmado() {
        return estado.toConfirmado(this);
    }

    public String toEntregue() {
        return estado.toEntregue(this);
    }

    public String toProducao() {
        return estado.toProducao(this);
    }

    public String toTransporte() {
        return estado.toTransporte(this);

    }

    public void setChange() {
        setChanged();
        notifyObservers();
    }

}
