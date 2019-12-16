/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author danie
 */
public class Main {
    
    public static void main(String[] args){
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
          Random r = new Random();
          r.doubles(0, 1);
          for(int i =0; i<=10; i++){
              System.out.println(r.nextDouble());
          }
          
        
    }
}
