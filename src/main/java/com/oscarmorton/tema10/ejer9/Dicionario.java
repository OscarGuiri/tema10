package com.oscarmorton.tema10.ejer9;

import utils.Lib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Dicionario {
    private HashMap<String,String> elementosDicionario;
    private int numeroPalabras = 0;
    private Scanner lector;

    /**
     * Creo un nuevo diccionario
     * @param numeroPalabras Numero de palabras por defecto
     */
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

    /**
     * Devuelve la definicion de la palabra.
     * @param palabra La palabra KEY
     * @return
     */
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

    /**
     * Extrae un definico aleatorio del dicionario y el usuario tiene que intentar adivinarlo. Si lo adivina, juega otra vez. Si lo falla, el juego termina y devuelve los puntos;
     * CON DUDA
     */
    public int jugarJuego() {
        lector = new Scanner(System.in);
        int puntos = 0;
        boolean salir = false;
        int numAleatorio = 0;
        int contador = 0;
        String palabra = "";
        Set setOfKeys = this.elementosDicionario.keySet();
        System.out.println("EMPEZAMOS EL JUEGO");
        do {

            for (String setOfKey : (Iterable<String>) setOfKeys) {
                if (contador == numAleatorio) {
                    String key = (String) setOfKey;
                    System.out.println("Definicion: " + this.elementosDicionario.get(key));
                    System.out.println("Cual es la palabra?");
                    palabra = lector.nextLine();
                    if (palabra.equals(key)) {
                        System.out.println("CORRECTO!");
                        puntos++;
                    } else {
                        salir = true;
                    }
                }
                contador++;
            }
            contador = 0;
      } while (!salir);
    return puntos;

    }

    public void mostrarDicionario(){
            System.out.println(elementosDicionario.entrySet());
    }
    /**
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

