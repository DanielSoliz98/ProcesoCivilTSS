package Modelos;

import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class SalaCivil extends Thread {

    private int idSala;
    private ArrayList<ProcesoCivil> procesos;

    public SalaCivil(int idSala, ArrayList<ProcesoCivil> procesos) {
        this.idSala = idSala;
        this.procesos = procesos;
    }

    @Override
    public void run() {
        System.out.println("Sala Civil " + this.idSala + ": Comienza a trabajar.");
        for (int i = 0; i < procesos.size(); i++) {
            ProcesoCivil proceso = procesos.get(i);
            System.out.println("Inicio del Proceso Civil: " + proceso.getIdProceso() + " SalaCivil: " + this.idSala);
            ArrayList<Etapa> etapas = proceso.getEtapasProcesoCivil();
            for (int j = 0; j < etapas.size(); j++) {
                Etapa etapa = etapas.get(j);
                System.out.println("Inicio Etapa: " + etapa.getNombreEtapa() + " Proceso Civil: " + proceso.getIdProceso());
                etapa.ejecutarEtapa();
                this.esperarXSegundos(2);
                System.out.println("Fin Etapa: " + etapa.getNombreEtapa() + " Proceso Civil: " + proceso.getIdProceso());
            }
            System.out.println("Fin Proceso Civil: " + proceso.getIdProceso() + " SalaCivil: " + this.idSala);
            System.out.println("Duracion de Proceso Civil " + proceso.getIdProceso() + ": "
                    + proceso.getDiasTotalesTranscurridos() + " dias" + " SalaCivil: " + this.idSala);
        }
    }

    private void esperarXSegundos(int segundos) {
        try {
            SalaCivil.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            SalaCivil.currentThread().interrupt();
        }
    }
}
