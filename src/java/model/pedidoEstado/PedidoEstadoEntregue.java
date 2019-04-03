package model.pedidoEstado;

import model.Pedido;

public class PedidoEstadoEntregue implements PedidoEstado {

    @Override
    public String estadoString() {
        return "Entregue";
    }

    @Override
    public String toCarrinho(Pedido pedido) {
        return "Pedido Entregue não pode passar para Carrinho";
    }

    @Override
    public String toConfirmado(Pedido pedido) {
        return "Pedido Entregue não pode passar para Confirmado";
    }

    @Override
    public String toEntregue(Pedido pedido) {
        return "Pedido Entregue não pode passar para Entrgeue";
    }

    @Override
    public String toProducao(Pedido pedido) {
        return "Pedido Entregue não pode passar para Produção";
    }

    @Override
    public String toTransporte(Pedido pedido) {
        return "Pedido Entregue não pode passar para Transporte";
    }
}
