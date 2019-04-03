package model.pedidoEstado;

import model.Pedido;

public interface PedidoEstado {

    String toCarrinho(Pedido pedido);

    String toConfirmado(Pedido pedido);

    String toEntregue(Pedido pedido);

    String toProducao(Pedido pedido);

    String toTransporte(Pedido pedido);

    String estadoString();
}
