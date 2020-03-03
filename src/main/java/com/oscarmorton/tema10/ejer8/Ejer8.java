package com.oscarmorton.tema10.ejer8;

import java.util.Scanner;

public class Ejer8 {
    private Scanner lector;
    private Dicionario d = new Dicionario();
    public Ejer8(){
        int opcion = -1;
        String palabra = "";
        String definicion = "";
        do {
            opcion = imprimeMenu();
            switch (opcion) {
                case 1:
                    introducirpalabra();
                    break;
                case 2:
                   d.modificarPalabra();
                    break;
                case 3:
                    eliminarPalabra();
                    break;
                case 4:
                    System.out.println("Introduce la palabra: ");
                    palabra = lector.nextLine();
                    definicion = d.getDefinicionPalabra(palabra.toLowerCase());
                    System.out.println(definicion);
                    break;
                case 5:

                    d.mostrarDicionario();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;

                default:
                    break;
            }
        }while(opcion != 0);


    }

    /**
     * Para introducir palabras. Los valida tambien
     */
    public void introducirpalabra(){
        lector = new Scanner(System.in);

        boolean valido = false;
        int nPalabras = 0;
        String palabra = "";
        String definicion = "";

        do {
            System.out.println("¿Cuántas parejas deseas introducir?");
            try{
                nPalabras = Integer.parseInt(lector.nextLine());
                valido = true;
            }catch (NumberFormatException nfe){
                System.out.println("Por favor, introduce un numero");
            }
        }while(!valido);

        for(int i = 0; i < nPalabras; i++){
            System.out.println("Introduce la palabra");
            palabra = lector.nextLine().trim();
            System.out.println("Introduce su definicion");
            definicion = lector.nextLine();
            d.add(palabra.toLowerCase(), definicion.toLowerCase());
        }


    }

    /**
     * Traduce la palabra, pidiente una palabra en Ingles
     */



    /**
     * Pide por salida una palabra y lo elimina despues de comprobar que exite
     */
    public void eliminarPalabra(){
        String palabra = "";
        System.out.println("Cual palabra quieres eliminar?");
        palabra = lector.nextLine().trim();
        if(d.existePalabra(palabra)){
            d.remove(palabra);
        }else{
            System.out.println("No existe la palabra " + palabra);
        }
    }

    /**
     * Imprime el valor y valora si la entrada es lo que deberia.
     * @return
     */
    public int imprimeMenu(){
        lector = new Scanner(System.in);
        int opcion = -1;
        boolean valido = false;

        do {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("==============");
            System.out.println("1. Añadir palabra");
            System.out.println("2. Modificar palabra");
            System.out.println("3. Eliminar palabra");
            System.out.println("4. Consultar palabra");
            System.out.println("5. Mostrar diccionario");
            System.out.println("0. Salir de la aplicación.");
            System.out.println("Elige una opción: ");
            try {
                opcion = Integer.parseInt(lector.nextLine());
                if(opcion < 0 || opcion > 5 ){
                    valido = false;
                }else {
                    valido = true;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Por favor, introduce un valor entre el 0 y el 2");
            }
        }while(!valido);
        return opcion;
    }
}
