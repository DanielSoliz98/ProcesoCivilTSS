/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Random;

/**
 *
 * @author danie
 */
public class NumerosAleatorios {
    public static double getNumeroAleatorio(){
        Random randomNumber = new Random();
        randomNumber.doubles(0, 1);
        return randomNumber.nextDouble();
    }
}
