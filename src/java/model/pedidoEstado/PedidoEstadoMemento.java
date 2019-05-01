package model.pedidoEstado;

public class PedidoEstadoMemento {

    private PedidoEstado estado;

    public PedidoEstadoMemento(PedidoEstado estado) {
        this.estado = estado;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

}
