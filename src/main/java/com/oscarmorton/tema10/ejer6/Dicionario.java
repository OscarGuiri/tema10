package com.oscarmorton.tema10.ejer6;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Dicionario {
    private HashMap<String,String> elementosDicionario;
    private int numeroPalabras = 0;

    public Dicionario(int numeroPalabras) {
        this.numeroPalabras = numeroPalabras;
        this.elementosDicionario = new HashMap<>();
    }
    public Dicionario(){
        this.numeroPalabras = 0 ;
        this.elementosDicionario = new HashMap<>();
    }

    /**
     *
     * @param palabraIngles
     * @param palabraValenciano
     */
    public void add(String palabraIngles, String palabraValenciano){

        elementosDicionario.put(palabraIngles, palabraValenciano);

    }
    public String translate(String palabraIngles){
        boolean existe = false;
        if(elementosDicionario.get(palabraIngles) == null){
         return "No se a encontrado la palanra";
        }else {
            return elementosDicionario.get(palabraIngles);
        }

    }

    public void remove(String palabraIngles){
       elementosDicionario.remove(palabraIngles);
    }


}

