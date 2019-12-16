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
public class Contestacion extends Etapa {

    public Contestacion(Etapa etapa) {
        super("Contestacion", etapa);
    }

    @Override
    public void ejecutarEtapa() {
        this.agregarMensaje("Inicia la etapa de Contestacion");
        Etapa e = this.getEtapaAnterior();
        if ("Citacion o Emplazamiento".equals(e.getNombreEtapa())) {
            CitacionEmplazamiento citacion = (CitacionEmplazamiento) e;
            if (citacion.enRebeldia()) {
                this.audienciaPrliminar();
                this.finalizarEtapa();
            } else {
                this.tipoContestacion();
            }
        }
        this.agregarMensaje("Termina la etapa de Contestacion");
    }

    private void tipoContestacion() {
        if (DistribucionBernoulli.desicion(0.05)) {
            this.agregarMensaje("Allanamiento a la demanda por el demandado.");
            this.anadirDiasTranscurridos(TransformadaInversa.getX(1, 5));
            this.agregarMensaje("Se dicta sentencia inmediatamente.");
            this.finalizarProceso();
        } else {
            if (DistribucionBernoulli.desicion(0.70)) {
                this.agregarMensaje("Planteamiento de Excepciones Previas en traslado al demandante.");
                if (DistribucionBernoulli.desicion(0.35)) {
                    this.agregarMensaje("Reconvencion de la parte demanda.");
                    int demandante = TransformadaInversa.getX(5, 30);
                    this.agregarMensaje("El demandante contestara en " + demandante + " dias.");
                    this.anadirDiasTranscurridos(demandante);
                    this.audienciaPrliminar();
                } else {
                    int demandante = TransformadaInversa.getX(5, 15);
                    this.agregarMensaje("El demandante contestara en " + demandante + " dias.");
                    this.anadirDiasTranscurridos(demandante);
                    this.audienciaPrliminar();
                }
            } else {
                if (DistribucionBernoulli.desicion(0.35)) {
                    this.agregarMensaje("Reconvencion de la parte demanda.");
                    int demandante = TransformadaInversa.getX(5, 30);
                    this.agregarMensaje("El demandante contestara en " + demandante + " dias.");
                    this.anadirDiasTranscurridos(demandante);
                    this.audienciaPrliminar();
                }
            }

        }
    }

    private void audienciaPrliminar() {
        int audienciaPreliminar = TransformadaInversa.getX(1, 5);
        this.agregarMensaje("Audiencia Preliminar en " + audienciaPreliminar + " dias.");
        this.anadirDiasTranscurridos(audienciaPreliminar);
    }

}
