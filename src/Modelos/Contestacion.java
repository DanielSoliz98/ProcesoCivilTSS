package Modelos;

/**
 *
 */
public class Contestacion extends Etapa {

    private boolean allanamiento;
    private boolean excepcionesPrevias;
    private boolean reconvencion;

    public Contestacion(Etapa etapa) {
        super("Contestacion", etapa);
        this.allanamiento = false;
        this.excepcionesPrevias = false;
        this.reconvencion = false;
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
            this.allanamiento = true;
            this.finalizarEtapa();
        } else {
            if (DistribucionBernoulli.desicion(0.70)) {
                this.agregarMensaje("Planteamiento de Excepciones Previas en traslado al demandante.");
                this.excepcionesPrevias = true;
                if (DistribucionBernoulli.desicion(0.35)) {
                    this.agregarMensaje("Reconvencion de la parte demanda.");
                    this.reconvencion = true;
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
                    this.reconvencion = true;
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
        this.finalizarEtapa();
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
