package Modelos;

import java.util.Random;

/**
 * Numeros aleatorios para simulacion.
 */
public class NumerosAleatorios {

    public static double getNumeroAleatorio() {
        Random randomNumber = new Random();
        randomNumber.doubles(0, 1);
        return randomNumber.nextDouble();
    }
}
