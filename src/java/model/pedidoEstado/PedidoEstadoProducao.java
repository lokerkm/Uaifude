package model.pedidoEstado;

import model.Pedido;

public class PedidoEstadoProducao implements PedidoEstado {

    @Override
    public String estadoString() {
        return "Producao";
    }

    @Override
    public String toCarrinho(Pedido pedido) {
        return "Pedido Produção não pode passar para Carrinho";
    }

    @Override
    public String toConfirmado(Pedido pedido) {
        return "Pedido Produção não pode passar para Confirmado";
    }

    @Override
    public String toEntregue(Pedido pedido) {
        return "Pedido Produção não pode passar para Entregue";
    }

    @Override
    public String toProducao(Pedido pedido) {
        return "Pedido Produção não pode passar para Produção";
    }

    @Override
    public String toTransporte(Pedido pedido) {
        pedido.setEstado(new PedidoEstadoTransporte());
        return "Pedido Produção pode passar para Transporte";
    }
}
