package Modelos;

/**
 * Etapa de Contestacion.
 */
public class Contestacion extends Etapa {

    private boolean allanamiento = false;
    private boolean excepcionesPrevias = false;
    private boolean reconvencion = false;

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
    }

    private void tipoContestacion() {
        if (DistribucionBernoulli.desicion(0.05)) {
            this.agregarMensaje("Allanamiento a la demanda por el demandado.");
            this.anadirDiasTranscurridos(TransformadaInversa.getX(1, 5));
            this.setAllanamiento();
            this.agregarMensaje("Termina la etapa de Contestacion");
            this.finalizarEtapa();
        } else {
            if (DistribucionBernoulli.desicion(0.70)) {
                this.agregarMensaje("Planteamiento de Excepciones Previas en traslado al demandante.");
                this.setExcepcionesPrevias();
                if (DistribucionBernoulli.desicion(0.35)) {
                    this.agregarMensaje("Reconvencion de la parte demanda.");
                    this.setReconvencion();
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
                    this.setReconvencion();
                    int demandante = TransformadaInversa.getX(5, 30);
                    this.agregarMensaje("El demandante contestara en " + demandante + " dias.");
                    this.anadirDiasTranscurridos(demandante);
                    this.audienciaPrliminar();
                }
            }

        }
    }

    private void audienciaPrliminar() {
        this.agregarMensaje("Termina la etapa de Contestacion");
        int audienciaPreliminar = TransformadaInversa.getX(1, 5);
        this.agregarMensaje("Audiencia Preliminar en " + audienciaPreliminar + " dias.");
        this.anadirDiasTranscurridos(audienciaPreliminar);
        this.finalizarEtapa();
    }

    public void setReconvencion() {
        this.reconvencion = true;
    }

    public void setExcepcionesPrevias() {
        this.excepcionesPrevias = true;
    }

    public void setAllanamiento() {
        this.allanamiento = true;
    }

    public boolean reconvencion() {
        return this.reconvencion;
    }

    public boolean excepcionesPrevias() {
        return this.excepcionesPrevias;
    }

    public boolean allanamiento() {
        return this.allanamiento;
    }
}
