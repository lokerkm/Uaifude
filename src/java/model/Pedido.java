package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import model.pedidoEstado.PedidoEstado;
import model.pedidoEstado.PedidoEstadoMemento;
import persistence.PedidoDAO;

public class Pedido extends Observable {

    private int id;
    private PedidoEstado estado;
    private Endereco endereco;
    private Cliente cliente;
    private float total;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private int estabelecimentoId;
    private ArrayList<PedidoEstadoMemento> historicoPedidoEstado = new ArrayList<>();
    private int indexHistoricoPedidoEstado;

    public int getId() {
        return id;
    }

    public Pedido setId(int id) {
        this.id = id;
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

    public PedidoEstado getEstado() {
        if (historicoPedidoEstado.isEmpty()) {
            return estado;
        } else {
            return historicoPedidoEstado.get(indexHistoricoPedidoEstado).getEstado();
        }

    }

    public Pedido setEstado(PedidoEstado estado) {
        if (!this.estado.estadoString().equals(estado.estadoString())) {
            if (historicoPedidoEstado.isEmpty()) {
                indexHistoricoPedidoEstado = 0;
            } else {
                if (indexHistoricoPedidoEstado != historicoPedidoEstado.size() - 1) {
                    while (indexHistoricoPedidoEstado != historicoPedidoEstado.size() - 1) {
                        historicoPedidoEstado.remove(historicoPedidoEstado.size());

                    }
                }
                indexHistoricoPedidoEstado = historicoPedidoEstado.size();
            }
            historicoPedidoEstado.add(new PedidoEstadoMemento(estado));
        }
        this.estado = estado;
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

    public String avancarHistorico() throws SQLException, ClassNotFoundException {
        if (historicoPedidoEstado.isEmpty()) {
            return "Historico vazio";
        }
        if (historicoPedidoEstado.size() - 1 == indexHistoricoPedidoEstado) {
            return "Não possui estado sucedente";
        }
        indexHistoricoPedidoEstado++;
        this.estado = historicoPedidoEstado.get(indexHistoricoPedidoEstado).getEstado();
        PedidoDAO.getInstance().update(this);
        return "Pedido movido de " + historicoPedidoEstado.get(indexHistoricoPedidoEstado - 1).getEstado().estadoString() + " para " + historicoPedidoEstado.get(indexHistoricoPedidoEstado).getEstado().estadoString();

    }

    public String retrocederHistorico() throws SQLException, ClassNotFoundException {
        if (historicoPedidoEstado.isEmpty()) {
            return "Historico vazio";
        }
        if (0 == indexHistoricoPedidoEstado) {
            return "Não possui estado precedente";
        }
        indexHistoricoPedidoEstado--;
        this.estado = historicoPedidoEstado.get(indexHistoricoPedidoEstado).getEstado();
        PedidoDAO.getInstance().update(this);
        return "Pedido movido de " + historicoPedidoEstado.get(indexHistoricoPedidoEstado + 1).getEstado().estadoString() + " para " + historicoPedidoEstado.get(indexHistoricoPedidoEstado).getEstado().estadoString();
    }
}
