package com.oscarmorton.tema10.ejer2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ArrayListEstadisticas extends ArrayList<Double> implements IEstadisticas {
   private  ArrayList<Double> al = new ArrayList(5);




    @Override

    /**
     * Devuelve el elemento minimo del array
     */
    public double minimo() {
        double minimo = Double.MAX_VALUE;
        if(isEmpty() == false) {
            for (int i = 0; i < size(); i++) {
                if (get(i) < minimo) {
                    minimo = get(i);
                }

            }
        }else{
            return 0;
        }
        return  minimo;

    }

    @Override
    public double maximo() {
        double maximo = Double.MIN_VALUE;

            for (int i = 0; i < size(); i++) {
                if (get(i) > maximo) {
                    maximo = get(i);
                }

            }

        return  maximo;
    }

    @Override
    public double sumatorio() {
        double sumaTotal = 0;
        for (int i = 0; i < size(); i++) {
            sumaTotal += get(i);

        }

        return sumaTotal;
    }

    @Override
    public double media() {
        double total = 0;
        for(int i = 0; i < size(); i++ ){
            total+= get(i);

        }
       return  total/size();

    }

    @Override
    /**
     * ESTO FALLA
     */
    public double moda() {
        double contador = 0;
        HashMap<Double,Double> hm = new HashMap<Double, Double>();
        for(int i = 0; i < al.size(); i++ ){
            hm.put(al.get(i), 0.0);
        }
        for(int i = 0; i < al.size(); i++ ){


        }

      return 0;

    }
}
