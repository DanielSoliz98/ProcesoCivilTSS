package Modelos;

/**
 *
 * @author danie
 */
public class TransformadaInversa {

    public static int getX(int a, int b) {
        return (int) (a + ((b - a) * NumerosAleatorios.getNumeroAleatorio()));
    }
}
