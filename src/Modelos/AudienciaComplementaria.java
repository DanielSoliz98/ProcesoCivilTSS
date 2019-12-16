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
public class AudienciaComplementaria extends Etapa {

    public AudienciaComplementaria(Etapa etapa) {
        super("Audiencia Complementaria", etapa);
    }

    @Override
    public void ejecutarEtapa() {
        this.agregarMensaje("Inicia la etapa de Audiencia COmplementaia");
        Etapa e = this.getEtapaAnterior();
        if (e.getNombreEtapa() == "Audiencia Preliminar") {
            AudienciaPreliminar preliminar = (AudienciaPreliminar) e;
            if (preliminar.audienciaComplementaria()) {
                this.faltaDiligenciamietoPrueba();
            }
        }
        this.agregarMensaje("Termina la etapa de Audiencia COmplementaia");
    }

    private void faltaDiligenciamietoPrueba() {
        if (DistribucionBernoulli.desicion(0.10)) {
            int reanudacion = TransformadaInversa.getX(5, 15);
            this.agregarMensaje("Reanudacion de audiencia complementaria en " + reanudacion + " dias");
            this.anadirDiasTranscurridos(reanudacion);
            this.alegatos();
        } else {
            this.alegatos();
        }
    }

    private void alegatos() {
        this.agregarMensaje("Alegatos de 10 minutos de ambas partes. Se dicta sentencia.");
        this.anadirDiasTranscurridos(1);
        this.finDeEtapa();
    }

}
