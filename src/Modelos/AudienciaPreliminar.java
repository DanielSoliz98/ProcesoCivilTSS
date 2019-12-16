/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author danie
 */
public class AudienciaPreliminar extends Etapa {

    public AudienciaPreliminar(Etapa etapa) {
        super("Audiencia Preliminar", etapa);
    }

    @Override
    public void ejecutarEtapa() {
        this.agregarMensaje("Inicia la etapa de Audiencia Preliminar");

        this.agregarMensaje("Termina la etapa de Audiencia Preliminar");
    }

}
