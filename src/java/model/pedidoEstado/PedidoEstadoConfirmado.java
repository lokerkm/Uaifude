package model.pedidoEstado;


public class PedidoEstadoConfirmado implements PedidoEstado {
@Override
    public String estadoString() {
        return "Confirmado";
    }
}
