package Modelos;

/**
 * Funcion de Desicion.
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
