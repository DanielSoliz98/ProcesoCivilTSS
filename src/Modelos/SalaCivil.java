package Modelos;

import java.util.ArrayList;

/**
 * Implementacion para una simulacion personalizada.
 */
public class SalaCivil extends Thread {

    private int idSala;
    private ArrayList<ProcesoCivil> procesos;
    private ArrayList<String> mensajes;

    public SalaCivil(int idSala, ArrayList<ProcesoCivil> procesos) {
        this.idSala = idSala;
        this.procesos = procesos;
        this.mensajes = new ArrayList<>();
    }

    @Override
    public void run() {
        this.mensajes.add("Sala Civil " + this.getIdSala() + ": Comienza a trabajar.");
        for (int i = 0; i < procesos.size(); i++) {
            ProcesoCivil proceso = procesos.get(i);
            this.mensajes.add("Inicio del Proceso Civil: " + proceso.getIdProceso() + " SalaCivil: " + this.getIdSala());
            proceso.getEtapasProcesoCivil().stream().map((e) -> {
                e.getMensages().forEach((mensaje) -> {
                    this.mensajes.add("Proceso Civil " + proceso.getIdProceso() + ": " + mensaje);
                });
                return e;
            });
            this.mensajes.add("Fin Proceso Civil: " + proceso.getIdProceso() + " SalaCivil: " + this.getIdSala());
            this.mensajes.add("Duracion de Proceso Civil " + proceso.getIdProceso() + ": "
                    + proceso.getDiasTotalesTranscurridos() + " dias" + " SalaCivil: " + this.getIdSala());
        }
    }

    public double getMediaProcesos() {
        int suma = 0;
        for (ProcesoCivil p : procesos) {
            suma += p.getDiasTotalesTranscurridos();
        }
        return (double) suma / procesos.size();
    }

    public int getIdSala() {
        return this.idSala;
    }

    public ArrayList<ProcesoCivil> getProcesos() {
        return this.procesos;
    }

    public int procesosConSentencia() {
        int numeroProcesos = 0;
        for (ProcesoCivil p : this.procesos) {
            if (p.getEtapasProcesoCivil().size() >= 5) {
                numeroProcesos++;
            }
        }
        return numeroProcesos;
    }
}
