/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.pedidoEstado.PedidoEstado;

/**
 *
 * @author kevin
 */
public class EstadoFactory {

    public static PedidoEstado create(String estado) {
        PedidoEstado actionObject = null;
        String nomeClasse = "model.pedidoEstado.PedidoEstado" + estado;
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }
        if (!(objeto instanceof PedidoEstado)) {
            return null;
        }
        actionObject = (PedidoEstado) objeto;
        return actionObject;
    }
}
