package com.oscarmorton.tema10.ejer8;

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
     * @param palabra
     * @param definicion
     */
    public void add(String palabra, String definicion){

        elementosDicionario.put(palabra, definicion);
        this.numeroPalabras++;

    }
    public String getPalabra(String palabra){
        boolean existe = false;
        if(elementosDicionario.get(palabra) == null){
         return "No se a encontrado la palanra";
        }else {
            return elementosDicionario.get(palabra);
        }

    }

    public void remove(String palabra){

        elementosDicionario.remove(palabra);
    }
    //Devuelve true si existe la palabra
    public boolean existePalabra(String palabra){
        boolean encontrado = false;
        for(int i = 0; i < elementosDicionario.size(); i++){
            if(elementosDicionario.get(i) == palabra){
                encontrado = true;
            }
        }
        return encontrado;


    }


}

