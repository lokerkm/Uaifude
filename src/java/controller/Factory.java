package controller;

import model.Categoria;
import model.pedidoEstado.PedidoEstado;
import model.promocao.Promocao;

public class Factory {

    public static Object create(String nomeClasse) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }

        return objeto;
    }

    public static Action createAction(String action) {
        String nomeClasse = "action." + action + "Action";
        Object objeto = create(nomeClasse);
        if (!(objeto instanceof Action)) {
            return null;
        }
        Action actionObject = (Action) objeto;
        return actionObject;
    }

    public static Promocao createPromocao(String nome) {
        String nomeClasse = "model.promocao.Promocao" + nome;
        Object objeto = create(nomeClasse);
        if (!(objeto instanceof Promocao)) {
            return null;
        }
        Promocao actionObject = (Promocao) objeto;
        return actionObject;
    }

    public static PedidoEstado createPedidoEstado(String estado) {
        String nomeClasse = "model.pedidoEstado.PedidoEstado" + estado;
        Object objeto = create(nomeClasse);
        if (!(objeto instanceof PedidoEstado)) {
            return null;
        }
        PedidoEstado actionObject = (PedidoEstado) objeto;
        return actionObject;
    }

    public static Categoria createCategoria(String categoria) {
        String nomeClasse = "model.Categoria" + categoria;;
        Object objeto = create(nomeClasse);
        if (!(objeto instanceof Categoria)) {
            return null;
        }
        Categoria actionObject = (Categoria) objeto;
        return actionObject;
    }
}
