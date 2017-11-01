///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// */
//package simulación;
//
//import java.util.ArrayList;
//
///**
// *
// * @author Ccast
// */
//public class promedios {
//    public String pruebaPromedios(ArrayList<Float> randomNumbers, Float alpha) {
//        NormalDistribution nd = new NormalDistribution();
//        double rAlpah = nd.inverseCumulativeProbability(1 - (alpha / 2)), lif = 0.0, lsf = 0.0;
//        float r = 0f, p = 0;
//        String accept = "";
//
//        for (Float rN : randomNumbers) {
//            p += rN;
//        }
//
//        r = p / randomNumbers.size();
//        lif = 0.5 - rAlpah * (1 / Math.sqrt(12 * randomNumbers.size()));
//        lsf = 0.5 + rAlpah * (1 / Math.sqrt(12 * randomNumbers.size()));
//        if (lif < r && r < lsf) {
//            accept = "r está dentro del rango, por lo cual es aceptado";
//        } else {
//            accept = "r no está dentro del rango, por lo cual no es aceptado";
//        }
//        String result = "r= " + r + " LI= " + lif + " LS= " + lsf + " " + accept;
//
//        return result;
//    }
//    
//}
