package model;

import java.util.Observable;

import model.pedidoEstado.PedidoEstado;

public class Pedido extends Observable {

    private int id;
    private PedidoEstado estado;
    private Endereco endereco;
    private float total;

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

}
