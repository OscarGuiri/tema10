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
                   modificarPalabra();
                    break;
                case 3:
                    //eliminarPalabra();
                    break;
                case 4:
                    System.out.println("Introduce la palabra: ");
                    palabra = lector.nextLine();
                    definicion = d.getPalabra(palabra.toLowerCase());
                    System.out.println(definicion);
                    break;
                case 5:
                    //mostrarDicionario();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;

                default:
                    break;
            }
        }while(opcion != 0);


    }

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
            palabra = lector.nextLine();
            System.out.println("Introduce su definicion");
            definicion = lector.nextLine();
            d.add(palabra.toLowerCase(), definicion.toLowerCase());
        }


    }

    /**
     * Traduce la palabra, pidiente una palabra en Ingles
     */


    public void modificarPalabra(){
        String palabra = "";
        String definicion = "";
        System.out.println("Que palabra quieres modificar?");
        palabra = lector.nextLine().toLowerCase();

        if(d.existePalabra(palabra)){
            System.out.println("Introduce la nueva definicion de la palabra " + palabra + ": ");
            definicion = lector.nextLine().toLowerCase();
            d.add(palabra,definicion);
            System.out.println("Palabra Introducida correctamente");
        }else{
            System.out.println("La palabra no exite");
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
