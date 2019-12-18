package Modelos;

/**
 * Transformada inversa para distribucion uniforme simulacion.
 */
public class TransformadaInversa {

    public static int getX(int a, int b) {
        return (int) (a + ((b - a) * NumerosAleatorios.getNumeroAleatorio()));
    }
}
