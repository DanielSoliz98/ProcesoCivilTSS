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
        System.out.println("Sala Civil " + this.getIdSala() + ": Comienza a trabajar.");
        for (int i = 0; i < procesos.size(); i++) {
            ProcesoCivil proceso = procesos.get(i);
            System.out.println("Inicio del Proceso Civil: " + proceso.getIdProceso() + " SalaCivil: " + this.getIdSala());
            proceso.getEtapasProcesoCivil().stream().map((e) -> {
                e.getMensages().forEach((mensaje) -> {
                    System.out.println("Proceso Civil " + proceso.getIdProceso() + ": " + mensaje);
                });
                return e;
            }).forEachOrdered((e) -> {
                this.esperarXSegundos(e.getDiasTranscurridosEtapa() / 10);
            });
            System.out.println("Fin Proceso Civil: " + proceso.getIdProceso() + " SalaCivil: " + this.getIdSala());
            System.out.println("Duracion de Proceso Civil " + proceso.getIdProceso() + ": "
                    + proceso.getDiasTotalesTranscurridos() + " dias" + " SalaCivil: " + this.getIdSala());
        }
    }

    private void esperarXSegundos(int segundos) {
        try {
            SalaCivil.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            SalaCivil.currentThread().interrupt();
        }
    }

    private int getIdSala() {
        return this.idSala;
    }
}
