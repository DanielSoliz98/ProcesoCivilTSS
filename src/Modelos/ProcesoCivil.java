package Modelos;

import java.util.ArrayList;

/*
*
 */
public class ProcesoCivil {

    private int idProceso;
    private ArrayList<Etapa> etapasProceso;
    private ArrayList<String> mensajes;

    public ProcesoCivil(int id) {
        this.idProceso = id;
        this.etapasProceso = new ArrayList<>();
        this.mensajes = new ArrayList<>();
        crearEtapas();
    }

    private void crearEtapas() {
        Etapa conciliacion = new ConciliacionPrevia(null);
        if (conciliacion.finDeProceso()) {
            this.etapasProceso.add(conciliacion);
        } else {
            if (conciliacion.finDeEtapa()) {
                Etapa demanda = new Demanda(conciliacion);
                this.etapasProceso.add(conciliacion);
                if (demanda.finDeProceso()) {
                    this.etapasProceso.add(demanda);
                } else {
                    if (demanda.finDeEtapa()) {
                        Etapa citacion = new CitacionEmplazamiento(demanda);
                        this.etapasProceso.add(demanda);
                        if (citacion.finDeProceso()) {
                            this.etapasProceso.add(citacion);
                        } else {
                            if (citacion.finDeEtapa()) {
                                this.etapasProceso.add(citacion);
                                Etapa contestacion = new Contestacion(citacion);
                                if (contestacion.finDeEtapa()) {
                                    this.etapasProceso.add(contestacion);
                                    Etapa audienciaPreliminar = new AudienciaPreliminar(contestacion);
                                    if (audienciaPreliminar.finDeProceso()) {
                                        this.etapasProceso.add(audienciaPreliminar);
                                    } else {
                                        if (audienciaPreliminar.finDeEtapa()) {
                                            this.etapasProceso.add(audienciaPreliminar);
                                            AudienciaPreliminar a = (AudienciaPreliminar) audienciaPreliminar;
                                            if (a.audienciaComplementaria()) {
                                                Etapa audienciaComplementaria = new AudienciaComplementaria(a);
                                                if (audienciaComplementaria.finDeEtapa()) {
                                                    this.etapasProceso.add(audienciaComplementaria);
                                                }
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public ArrayList<String> getMensajesProceso() {
        etapasProceso.forEach((etapa) -> {
            etapa.getMensages().forEach((mensaje) -> {
                this.mensajes.add(mensaje);
            });
        });
        return this.mensajes;
    }

    public int getIdProceso() {
        return this.idProceso;
    }

    public ArrayList<Etapa> getEtapasProcesoCivil() {
        return this.etapasProceso;
    }

    public int getDiasTotalesTranscurridos() {
        int diasTotales = 0;
        diasTotales = etapasProceso.stream()
                .map((etapa) -> etapa.getDiasTranscurridosEtapa())
                .reduce(diasTotales, Integer::sum);
        return diasTotales;
    }
}
