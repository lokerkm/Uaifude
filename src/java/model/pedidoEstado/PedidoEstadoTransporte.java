package model.pedidoEstado;

import model.Pedido;

public class PedidoEstadoTransporte implements PedidoEstado {

    public PedidoEstadoTransporte() {
        System.out.println("dskgnsd");
    }

    @Override
    public String estadoString() {
        return "Transporte";
    }

    @Override
    public String toCarrinho(Pedido pedido) {
        return "Pedido Transporte não pode passar para Carrinho";
    }

    @Override
    public String toConfirmado(Pedido pedido) {
        return "Pedido Transporte não pode passar para Confirmado";
    }

    @Override
    public String toEntregue(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoEntregue());
        pedido.setChange();
        return "Pedido Transporte pode passar para Entregue";
    }

    @Override
    public String toProducao(Pedido pedido) {
        return "Pedido Transporte não pode passar para Produção";
    }

    @Override
    public String toTransporte(Pedido pedido) {
        return "Pedido Transporte não pode passar para Transporte";
    }
}
