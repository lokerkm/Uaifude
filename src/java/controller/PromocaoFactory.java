package controller;

import model.promocao.*;

public class PromocaoFactory {

    public static Promocao create(String nome) {
        Promocao nomeObject = null;
        String nomeClasse = "model.promocao.Promocao" + nome;
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }
        if (!(objeto instanceof Promocao)) {
            return null;
        }
        nomeObject = (Promocao) objeto;
        return nomeObject;
    }
}
