/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Categoria;

/**
 *
 * @author kevin
 */
public class CategoriaFactory {
    public static Categoria create(String categoria) {
        Categoria actionObject = null;
        String nomeClasse = "model.Categoria" + categoria;
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }
        if (!(objeto instanceof Categoria)) {
            return null;
        }
        actionObject = (Categoria) objeto;
        return actionObject;
    }
}
