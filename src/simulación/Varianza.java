/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulación;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 *
 * @author Ccast
 */
public class Varianza {
    double [] datos = { 0.0449, 0.6015, 0.63, 0.5514, 0.0207,
0.1733, 0.6694, 0.2531, 0.3116, 0.1067,
0.5746, 0.3972, 0.8297, 0.3587, 0.3587,
0.049, 0.7025, 0.6483, 0.7041, 0.1746,
0.8406, 0.1055, 0.6972, 0.5915, 0.3362,
0.8349, 0.1247, 0.9582, 0.2523, 0.1589,
0.92,  0.1977, 0.9085, 0.2545, 0.3727,
0.2564, 0.0125, 0.8524, 0.3044, 0.4145};
 
 
int cant_datos = datos.length;
int grados_libertad = cant_datos-1;
double confianza= .95;
double alfa = 1-confianza;
 

NormalDistribution nd = new NormalDistribution();
ChiSquaredDistribution chi = new ChiSquaredDistribution(grados_libertad);
DescriptiveStatistics estadistica = new DescriptiveStatistics();
 
 
double media, li, ls;
double z;
int i;
 
 
for (i=0; i<cant_datos; i++){
estadistica.addValue(datos[i]);
}
 
 
media = estadistica.getMean();
 
z= nd.inverseCumulativeProbability(1 - alfa/2 );

 
li = 0.5 - z * (1/Math.sqrt(12*estadistica.getN()));
ls = 0.5 + z * (1/Math.sqrt(12*estadistica.getN()));

System.out.println("---Prueba de medias---");
System.out.println("Media: " + media);
System.out.println("Limite inferior: "+ li);
System.out.println("Limite superior: " + ls);
 

double varianza,li2, ls2;
varianza = estadistica.getVariance();
 
//Obtenemos los valores de la tabla de Chi cuadrada:
 
li2 = chi.inverseCumulativeProbability(alfa/2)/(12*grados_libertad);
ls2 = chi.inverseCumulativeProbability(1-alfa/2)/(12*grados_libertad);
 

 
System.out.println("---Prueba de varianza---");
System.out.println("Varianza: "+ varianza);
System.out.println("Limite inferior: " + li2);
System.out.println("Limite superior: " + ls2);
}
