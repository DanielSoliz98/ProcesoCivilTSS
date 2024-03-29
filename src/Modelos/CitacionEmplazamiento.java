package Modelos;

/**
 * Etapa Citacion y Emplazamiento.
 */
public class CitacionEmplazamiento extends Etapa {

    private boolean rebeldia = false;

    public CitacionEmplazamiento(Etapa etapa) {
        super("Citacion o Emplazamiento", etapa);
    }

    @Override
    public void ejecutarEtapa() {
        this.agregarMensaje("Inicia la etapa de Citacion y Emplazamiento");
        if (DistribucionBernoulli.desicion(0.03)) {
            this.agregarMensaje("Fallecimiento del demandado.");
            this.agregarMensaje("Citacion a herederos bajo pena de nulidad.");
            this.anadirDiasTranscurridos(TransformadaInversa.getX(5, 30));
            this.finalizarProceso();
        } else {
            if (DistribucionBernoulli.desicion(0.90)) {
                int contestacion = TransformadaInversa.getX(5, 30);
                this.agregarMensaje("Contestacion a citacion por la parte demandada en " + contestacion + " dias.");
                this.anadirDiasTranscurridos(contestacion);
                this.finalizarEtapa();
            } else {
                this.agregarMensaje("El demandado no contesto a la citacion");
                this.agregarMensaje("Se declara al demandado en rebeldia.");
                this.anadirDiasTranscurridos(30);
                this.setRebeldia();
            }

        }
        this.agregarMensaje("Termina la etapa de Citacion y Emplazamiento");
    }

    public void setRebeldia(){
        this.rebeldia = true;
    }
    public boolean enRebeldia() {
        return this.rebeldia;
    }

}
