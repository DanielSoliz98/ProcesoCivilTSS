package Modelos;

import java.util.ArrayList;

/**
 *
 */
public abstract class Etapa {

    private String nombreEtapa;
    private Etapa etapaAnterior;
    private int diasTranscurridos;
    private ArrayList<String> mensajes;
    private boolean finProceso;
    private boolean finEtapa;

    public Etapa(String nombre, Etapa etapa) {
        this.nombreEtapa = nombre;
        this.etapaAnterior = etapa;
        this.mensajes = new ArrayList<>();
        this.diasTranscurridos = 0;
        this.finProceso = false;
        this.finEtapa = false;
    }

    public void finalizarEtapa() {
        this.finEtapa = true;
    }

    public boolean finDeEtapa() {
        return this.finEtapa;
    }

    public void finalizarProceso() {
        this.finProceso = true;
    }

    public boolean finDeProceso() {
        return this.finProceso;
    }

    public String getNombreEtapa() {
        return this.nombreEtapa;
    }

    public int getDiasTranscurridosEtapa() {
        return this.diasTranscurridos;
    }

    public void anadirDiasTranscurridos(int dias) {
        this.diasTranscurridos += dias;
    }

    public void agregarMensaje(String mensaje) {
        this.mensajes.add(mensaje);
    }

    public ArrayList<String> getMensages() {
        return this.mensajes;
    }

    public abstract void ejecutarEtapa();
}
