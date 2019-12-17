package Modelos;

/**
 *
 */
public class Demanda extends Etapa {

    public Demanda(Etapa etapa) {
        super("Demanda", etapa);
    }

    @Override
    public void ejecutarEtapa() {
        this.agregarMensaje("Inicia la etapa de Demanda");
        this.revisionDemanda();
        this.agregarMensaje("Termina la etapa de Demanda");
    }

    private void revisionDemanda() {
        int revision = TransformadaInversa.getX(1, 10);
        this.agregarMensaje("Revision de demanda realizada en: " + revision + " dias.");
        this.anadirDiasTranscurridos(revision);
        if (DistribucionBernoulli.desicion(0.10)) {
            this.agregarMensaje("Demanda defectuosa.");
            this.subsanarDemanda();
        } else {
            this.citacionDemandado();
        }
    }

    private void subsanarDemanda() {
        double caso = NumerosAleatorios.getNumeroAleatorio();
        if (caso >= 0 && caso <= 0.98) {
            int subsanar = TransformadaInversa.getX(1, 3);
            this.agregarMensaje("Subanar defectos de demanda en " + subsanar + " dias.");
            this.anadirDiasTranscurridos(subsanar);
            this.revisionDemanda();
        } else if (caso > 0.98 && caso < 1) {
            this.agregarMensaje("Demanda manifiestamente improponible");
            this.anadirDiasTranscurridos(1);
            this.finalizarProceso();
        }
    }

    private void citacionDemandado() {
        int citacion = TransformadaInversa.getX(1, 10);
        this.agregarMensaje("Citacion a la parte demandada en " + citacion + " dias.");
        this.anadirDiasTranscurridos(citacion);
        this.finalizarEtapa();
    }

}
