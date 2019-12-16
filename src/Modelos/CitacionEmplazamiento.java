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
public class CitacionEmplazamiento extends Etapa {

    public CitacionEmplazamiento(Etapa etapa) {
        super("Citacion o Emplazamiento", etapa);
    }

    @Override
    public void ejecutarEtapa() {
        this.agregarMensaje("Inicia la etapa de Citacion y Emplazamiento");

        this.agregarMensaje("Termina la etapa de Citacion y Emplazamiento");
    }

}
