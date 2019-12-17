package Modelos;

/**
 *
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
        this.finalizarProceso();
    }

}
