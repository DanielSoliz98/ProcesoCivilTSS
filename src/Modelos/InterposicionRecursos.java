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
public class InterposicionRecursos extends Etapa {

    public InterposicionRecursos(Etapa etapa) {
        super("Interposicion de Recursos", etapa);
    }

    @Override
    public void ejecutarEtapa() {
        this.agregarMensaje("Inicia la etapa de Interposicion de Recursos");
        this.agregarMensaje("Recursos disponibles para utilizar: ");
        this.agregarMensaje("Reposicion, Apleacion, Casacion, Compulsa o Revision de Sentencia.");

    }

}
