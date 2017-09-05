/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulación;

import java.util.Scanner;

/**
 *
 * @author Ccast
 */
public class Simulación {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Cuantas dimensiones va a usara: ");
        int dimensiones = teclado.nextInt();
        System.out.println("Cuantos puntos usara: ");
        int cant_puntos = teclado.nextInt();
        double contador = 999999999;
        double contador2 = 999999999;
        double puntoC = 0;
        double puntoC2 = 0;
        int elpunto=0;
        int elpunto2=0;
        double[][] puntos = new double[cant_puntos][dimensiones];
        double[] punto = new double[cant_puntos];
        for (int i = 0; i < cant_puntos; i++) {
            for (int j = 0; j < dimensiones; j++) {
                System.out.println("introduzca la "+(j+1)+"° coordenada"+" del "+(i+1)+"° punto");
                puntos[i][j]= Math.pow(teclado.nextDouble(),2);
                
            }
            
        }

        for (int i = 0; i < cant_puntos; i++) {
            for (int j = 0; j < dimensiones; j++) {
                puntoC = puntos[i][j];
                puntoC2 = puntoC + puntoC2;

            }
            punto[i] = Math.sqrt(puntoC2);
            puntoC=0;
            puntoC2=0;
        }
        for (int i = 0; i < punto.length; i++) {
            if (punto[i] != 0) {
                if (contador > punto[i]) {
                    contador = punto[i];
                }
            }
        }
        for (int i = 0; i < punto.length; i++) {
            if (punto[i] != 0) {
                if (contador2 > punto[i]) {
                    if(contador<punto[i]){                        
                    contador2 = punto[i];
                    }
                }
            }
        }
        for (int i = 0; i < cant_puntos; i++) {
            if(contador==punto[i]){
                elpunto=i+1;
            }
            if(contador2==punto[i]){
                elpunto2=i+1;
            }
//jrudascas@gmail.com
        }
        System.out.println("El punto mas cercano es el "+elpunto+" con una distancia de "+contador+"\nEl segundo mas cercano es el "+elpunto2+"° punto con una distancia de "+contador2);

    }
}
