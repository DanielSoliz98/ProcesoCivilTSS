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
public class TransformadaInversa {
    
    public static int getX(int a , int b){
        return (int) (a + ((b-a) * NumerosAleatorios.getNumeroAleatorio()));
    }
}
