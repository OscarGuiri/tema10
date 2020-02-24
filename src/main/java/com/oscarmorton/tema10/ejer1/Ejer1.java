package com.oscarmorton.tema10.ejer1;

import utils.Lib;

import java.util.ArrayList;
import java.util.Arrays;

public class Ejer1 {
    public Ejer1(){
        ArrayList<Integer> al = new ArrayList<>();
        int[] numeros = new int[10];
        setRandomValuesArray(numeros);
        al = paresImpares(numeros);

        System.out.println("Array principal: " + Arrays.toString(numeros));

        System.out.println("Array list:" + al);


    }
    public ArrayList<Integer>  paresImpares(int[] numeros){
        int posPar = 0;
        int posImpar = numeros.length -1;
        ArrayList<Integer> numerosList = new ArrayList(numeros.length);
        for(int i = 0; i < numeros.length; i++){
            if(numeros[i] % 2 == 0){
                numerosList.add(numeros[i]);
            }
        }
        for(int i = 0; i < numeros.length; i++){
            if(numeros[i] % 2 != 0){
                numerosList.add(numeros[i]);
            }
        }
        return numerosList;
    }
    public int[] setRandomValuesArray(int[] array){
        for(int i = 0; i < array.length; i++) {
            array[i] = Lib.aleatorio(1, 100);
        }

        return array;
    }


}
