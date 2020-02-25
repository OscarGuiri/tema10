package com.oscarmorton.tema10.ejer6;
import java.util.Scanner;

public class Ejer6 {
    private Scanner lector;
    private  Dicionario d = new Dicionario();
    public Ejer6(){
        int opcion = -1;
        do {
            opcion = imprimeMenu();
            switch (opcion) {
                case 1:
                    introducirParejasDePalabra();
                    break;
                case 2:
                   traducePalabra();
                    break;
                default:

                    break;
            }
        }while(opcion != 0);


    }

    public void introducirParejasDePalabra(){
        lector = new Scanner(System.in);

        boolean valido = false;
        int nPalabras = 0;
        String palabraIngles = "";
        String palabraValenciano = "";

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
            System.out.println("Introduce palabra en inglés:");
            palabraIngles = lector.nextLine();
            System.out.println("Introduce la palabra en Valenciano");
            palabraValenciano = lector.nextLine();
            d.add(palabraIngles.toLowerCase(), palabraValenciano.toLowerCase());
        }


    }

    /**
     * Traduce la palabra, pidiente una palabra en Ingles
     */
    public void traducePalabra(){
        String palabreIngles = "";
        String palabraTraducida = "";
        lector = new Scanner(System.in);
        System.out.println("Palabra a buscar: ");
        palabreIngles = lector.nextLine();
        palabraTraducida = d.translate(palabreIngles.toLowerCase());
        System.out.println(palabraTraducida);

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
            System.out.println("1. Introducir parejas de palabras.");
            System.out.println("2. Traducir palabras.");
            System.out.println("0. Salir de la aplicación.");
            System.out.println("Elige una opción: ");
            try {
                opcion = Integer.parseInt(lector.nextLine());
                if(opcion < 0 || opcion > 2 ){
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
