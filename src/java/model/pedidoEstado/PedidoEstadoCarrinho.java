package model.pedidoEstado;

import model.Pedido;

public class PedidoEstadoCarrinho implements PedidoEstado {

    @Override
    public String estadoString() {
        return "Carrinho";
    }

    @Override
    public String toCarrinho(Pedido pedido) {
        return "Pedido Carrinho não pode passar para Carrinho";
    }

    @Override
    public String toConfirmado(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoConfirmado());
        pedido.setChange();
        return "Pedido Carrinho pode passar para Confirmado";
    }

    @Override
    public String toEntregue(Pedido pedido) {
        return "Pedido Carrinho não pode passar para Entregue";
    }

    @Override
    public String toProducao(Pedido pedido) {
        return "Pedido Carrinho não pode passar para Produção";
    }

    @Override
    public String toTransporte(Pedido pedido) {
        return "Pedido Carrinho não pode passar para Transporte";
    }

}
