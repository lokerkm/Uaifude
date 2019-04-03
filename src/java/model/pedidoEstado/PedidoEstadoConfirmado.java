package model.pedidoEstado;

import model.Pedido;

public class PedidoEstadoConfirmado implements PedidoEstado {

    @Override
    public String estadoString() {
        return "Confirmado";
    }

    @Override
    public String toCarrinho(Pedido pedido) {
        return "Pedido Confirmado não pode passar para Carrinho";
    }

    @Override
    public String toConfirmado(Pedido pedido) {
        return "Pedido Confirmado não pode passar para Confirmado";
    }

    @Override
    public String toEntregue(Pedido pedido) {
        return "Pedido Confirmado não pode passar para Entrgeue";
    }

    @Override
    public String toProducao(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoProducao());
        return "Pedido Confirmado pode passar para Produção";
    }@Override
    public String toTransporte(Pedido pedido) {
        return "Pedido Confirmado não pode passar para Transporte";
    }
}
