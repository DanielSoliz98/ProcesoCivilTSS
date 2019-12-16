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

    private boolean audienciaComplementaria;

    public AudienciaPreliminar(Etapa etapa) {
        super("Audiencia Preliminar", etapa);
        this.audienciaComplementaria = false;
    }

    @Override
    public void ejecutarEtapa() {
        this.agregarMensaje("Inicia la etapa de Audiencia Preliminar");
        if (this.asistenciaPartes()) {
            Etapa e = this.getEtapaAnterior();
            if ("Contestacion".equals(e.getNombreEtapa())) {
                Contestacion c = (Contestacion) e;
                if (c.allanamiento()) {
                    this.anadirDiasTranscurridos(1);
                    this.finalizarProceso();
                } else {
                    if (this.conciliacionIntraprocesal()) {
                        this.agregarMensaje("Conciliacion Intraprocesal exitosa.");
                        this.anadirDiasTranscurridos(2);
                        this.finalizarProceso();
                    } else {
                        this.agregarMensaje("Conciliacion Intraprocesal fallida. Continua el proceso");
                        this.anadirDiasTranscurridos(1);
                        this.agregarMensaje("Saneamiento Procesal. Diligenciamiento de las pruebas");
                        if (this.diligenciamientoPruebas()) {
                            this.agregarMensaje("Se diligenciaron todas las pruebas.");
                            this.agregarMensaje("Alegacion de las partes. Se dicta sentencia.");
                            this.anadirDiasTranscurridos(1);
                            this.finalizarProceso();
                        } else {
                            this.agregarMensaje("No se diligenciaron todas las pruebas.");
                            int complementaria = TransformadaInversa.getX(15, 1);
                            this.agregarMensaje("Audiencia Complementaria en " + complementaria + " dias");
                            this.anadirDiasTranscurridos(complementaria);
                            this.audienciaComplementaria = true;
                            this.finalizarEtapa();
                        }
                    }
                }
            }
        } else {
            this.agregarMensaje("Inasistencia de las partes a audiencia preliminar.");
            this.anadirDiasTranscurridos(2);
            this.finalizarProceso();
        }

        this.agregarMensaje("Termina la etapa de Audiencia Preliminar");
    }

    private boolean asistenciaPartes() {
        return DistribucionBernoulli.desicion(0.90);
    }

    private boolean conciliacionIntraprocesal() {
        return DistribucionBernoulli.desicion(0.15);
    }

    private boolean diligenciamientoPruebas() {
        return DistribucionBernoulli.desicion(0.75);
    }
    
    public boolean audienciaComplementaria(){
        return this.audienciaComplementaria;
    }
}
