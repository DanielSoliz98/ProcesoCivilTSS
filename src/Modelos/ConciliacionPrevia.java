package Modelos;

/**
 *
 */
public class ConciliacionPrevia extends Etapa {

    public ConciliacionPrevia(Etapa etapa) {
        super("Conciliacion Previa", null);
    }

    @Override
    public void ejecutarEtapa() {
        this.agregarMensaje("Inicia la etapa de Conciliacion Previa.");
        this.citacionAudienciaConciliar();
        this.audienciaConciliar();
    }

    private void citacionAudienciaConciliar() {
        int citacionDemandado = TransformadaInversa.getX(3, 10);
        this.anadirDiasTranscurridos(citacionDemandado);
        this.agregarMensaje("Citacion al demandado a la audiencia Conciliar en: "
                + citacionDemandado + " dias.");
    }

    private void audienciaConciliar() {
        if (DistribucionBernoulli.desicion(0.75)) {
            this.agregarMensaje("Se produce la audiencia conciliar");
            this.anadirDiasTranscurridos(1);
            this.resultadosConciliacion();
        } else {
            this.agregarMensaje("No se produce la audiencia conciliar");
            double incomparecencia = NumerosAleatorios.getNumeroAleatorio();
            if (incomparecencia >= 0 && incomparecencia <= 0.35) {
                this.agregarMensaje("Ausencia justificada de las partes");
                this.agregarMensaje("Nueva citacion dentro de 3 dias");
                this.anadirDiasTranscurridos(3);
                this.audienciaConciliar();
            } else if (incomparecencia > 0.35 && incomparecencia <= 0.6) {
                this.agregarMensaje("El citado no concurre a la audiencia.");
                this.agregarMensaje("Se pasa a la etapa de demanda.");
                this.agregarMensaje("Termina la etapa de Conciliacion Previa.");
                this.anadirDiasTranscurridos(2);
                this.finalizarEtapa();
            } else if (incomparecencia > 0.6 && incomparecencia <= 1) {
                this.agregarMensaje("Ambas partes no concurren a la audiencia");
                this.anadirDiasTranscurridos(1);
                this.finalizarProceso();
            }
        }
    }

    private void resultadosConciliacion() {
        double conciliacion = NumerosAleatorios.getNumeroAleatorio();
        if (conciliacion >= 0 && conciliacion <= 0.45) {
            this.agregarMensaje("Conciliacion Fallida");
            this.agregarMensaje("Termina la etapa de Conciliacion Previa.");
            this.agregarMensaje("Se pasa a etapa de demanda");
            this.anadirDiasTranscurridos(1);
            this.presentacionDemanda();
            this.finalizarEtapa();
        } else if (conciliacion > 0.45 && conciliacion <= 0.75) {
            this.agregarMensaje("Conciliacion Parcial");
            this.agregarMensaje("Termina la etapa de Conciliacion Previa.");
            this.agregarMensaje("Se pasa a etapa de demanda");
            this.anadirDiasTranscurridos(1);
            this.presentacionDemanda();
            this.finalizarEtapa();
        } else if (conciliacion > 0.75 && conciliacion <= 1) {
            this.agregarMensaje("Ambas partes no concurren a la audiencia");
            this.agregarMensaje("Termina la etapa de Conciliacion Previa.");
            this.anadirDiasTranscurridos(1);
            this.finalizarProceso();
        }
    }

    private void presentacionDemanda() {
        int demanda = TransformadaInversa.getX(1, 10);
        this.agregarMensaje("Se presenta demanda en: " + demanda + " dias.");
        this.anadirDiasTranscurridos(demanda);
    }
}
