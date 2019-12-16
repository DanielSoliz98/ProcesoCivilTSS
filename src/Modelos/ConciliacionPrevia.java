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
public class ConciliacionPrevia extends Etapa{
    
    public ConciliacionPrevia(String nombre, Etapa etapa) {
        super("Conciliacion Previa", null);
    }

    @Override
    public void ejecutarEtapa() {
        this.agregarMensaje("Inicia la etapa de Conciliacion Previa");
        
        this.agregarMensaje("Termina la etapa de Conciliacion Previa");
    }
    
}
