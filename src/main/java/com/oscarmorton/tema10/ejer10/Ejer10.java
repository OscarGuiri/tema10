package com.oscarmorton.tema10.ejer10;

import java.util.Scanner;

public class Ejer10 {
    private Scanner lector;
    public Ejer10(){
        int opcion = 0;
        opcion = imprimeMenu();



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
            System.out.println("*********************\n" +
                    "* GESTIÓN EMPLEADOS *\n" +
                    "*********************\n" +
                    "1. Nuevo empleado\n" +
                    "2. Nuevo hijo\n" +
                    "3. Modificar sueldo\n" +
                    "5 IES Número1 de Jávea\n" +
                    " 1.º DAM - Programación POO 1\n" +
                    "4. Borrar empleado\n" +
                    "5. Borrar hijo\n" +
                    "6. Consultas\n" +
                    "---------------------\n" +
                    "0. Salir");
            try {
                opcion = Integer.parseInt(lector.nextLine());
                if(opcion < 0 || opcion > 6 ){
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
