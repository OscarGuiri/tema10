package com.oscarmorton.tema10.ejer8;

import java.util.HashMap;
import java.util.Scanner;

public class Dicionario {
    private HashMap<String,String> elementosDicionario;
    private int numeroPalabras = 0;
    private Scanner lector;

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

    public String getDefinicionPalabra(String palabra){

        if(existePalabra(palabra)){
            return "Definicion de " + palabra + ": " + elementosDicionario.get(palabra);
        }
        return "La palabra no exite";

    }

    /**
     * Elimina una palabra
     * @param palabra
     */
    public void remove(String palabra){
        if(existePalabra(palabra)) {
            elementosDicionario.remove(palabra);
            System.out.println("Palabra eliminado correctamente");
        }else{
            System.out.println("No exite la palabra");
        }
    }
    //Devuelve true si existe la palabra
    public boolean existePalabra(String palabra){
        boolean encontrado = false;
        if(elementosDicionario.get(palabra) == null){
            encontrado = false;
        }else{
            encontrado = true;
        }
        return encontrado;


    }
    public void mostrarDicionario(){
            System.out.println(elementosDicionario.entrySet());
    }
    /**
     *
     * Modifica la palabra introducida despues de comprobar que exite
     */
    public void modificarPalabra(){
        lector = new Scanner(System.in);
        String palabra = "";
        String definicion = "";
        System.out.println("Que palabra quieres modificar?");
        palabra = lector.nextLine().toLowerCase();

        if(existePalabra(palabra)){
            System.out.println("Introduce la nueva definicion de la palabra " + palabra + ": ");
            definicion = lector.nextLine().toLowerCase().trim();
            elementosDicionario.replace(palabra,definicion);
            System.out.println("Palabra Introducida correctamente");
        }else{
            System.out.println("La palabra no exite");
        }

    }



}

