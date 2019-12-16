
package Modelos;

import java.util.ArrayList;

/*
*
*/
public class ProcesoCivil {
    private int idProceso;
    private ArrayList<Etapa> etapasProceso;
    private ArrayList<String> mensajes;
    
    public ProcesoCivil(int id){
        this.idProceso = id;
        this.etapasProceso = new ArrayList<>();
        this.mensajes = new ArrayList<>();
        crearEtapas();
    }
    
    private void crearEtapas(){
        this.etapasProceso.add(new ConciliacionPrevia("Conciliacion Previa", null));
    }
    
    public ArrayList<String> getMensajesProceso(){
        etapasProceso.forEach((etapa) -> {
            etapa.getMensages().forEach((mensaje) -> {
                this.mensajes.add(mensaje);
            });
        });
        return this.mensajes;
    }
    
    public int getIdProceso(){
        return this.idProceso;
    }
    
    public ArrayList<Etapa> getEtapasProcesoCivil(){
        return this.etapasProceso;
    }
    
    public int getDiasTotalesTranscurridos(){
        int diasTotales = 0;
        diasTotales = etapasProceso.stream()
                .map((etapa) -> etapa.getDiasTranscurridosEtapa())
                .reduce(diasTotales, Integer::sum);
        return diasTotales;
    }
}
