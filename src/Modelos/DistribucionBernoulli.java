/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author danie
 */
public class DistribucionBernoulli {

    public static boolean desicion(double probabilidad) {
        boolean result = false;

        if (probabilidad > 0 && probabilidad < 1) {
            double r = 1 - probabilidad;
            if (NumerosAleatorios.getNumeroAleatorio() > r) {
                result = true;
            }
        }

        return result;
    }
}
