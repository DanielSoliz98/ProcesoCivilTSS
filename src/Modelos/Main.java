package Modelos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author danie
 */
public class Main {

    public static void main(String[] args) {
//        ArrayList<ProcesoCivil> procesosSala1 = new ArrayList<>();
//        procesosSala1.add(new ProcesoCivil(1));
//        procesosSala1.add(new ProcesoCivil(2));
//        procesosSala1.add(new ProcesoCivil(3));
//        procesosSala1.add(new ProcesoCivil(4));
//        procesosSala1.add(new ProcesoCivil(5));
//        
//        ArrayList<ProcesoCivil> procesosSala2 = new ArrayList<>();
//        procesosSala2.add(new ProcesoCivil(1));
//        procesosSala2.add(new ProcesoCivil(2));
//        procesosSala2.add(new ProcesoCivil(3));
//        
//        SalaCivil sala1 = new SalaCivil(1, procesosSala1);
//        SalaCivil sala2 = new SalaCivil(2, procesosSala2);
//        SalaCivil sala3 = new SalaCivil(3, procesosSala2);
//        SalaCivil sala4 = new SalaCivil(4, procesosSala1);
//        SalaCivil sala5 = new SalaCivil(5, procesosSala2);
//        
//        sala1.start();
//        sala2.start();
//        sala3.start();
//        sala4.start();
//        sala5.start();
        ProcesoCivil cv = new ProcesoCivil(1);
        ArrayList<String> mensajes = cv.getMensajesProceso();
        for (String a : mensajes) {
            System.out.println(a);
        }
        System.out.println(cv.getDiasTotalesTranscurridos());
    }
}
