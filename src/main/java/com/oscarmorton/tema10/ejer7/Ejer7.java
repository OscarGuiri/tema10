package com.oscarmorton.tema10.ejer7;

import java.util.HashMap;
import java.util.Scanner;

public class Ejer7 {
    private Scanner lector;
    private CambioMoneda cm;

    public Ejer7(){
        cm = new CambioMoneda();
        int opcionMenuPrincipal ;
        int opcionMenuQueMoneda = -1;
        double euros = 0;
        double conversion = 0;
        do {
            opcionMenuPrincipal = imprimeMenuPrincipal();
            switch (opcionMenuPrincipal) {
                case 1:
                    opcionMenuQueMoneda = cm.imprimeMenuQueMoneda();
                    euros = pedirEuros();
                    conversion = cm.convertirMonedaUnica(cm.getCambioMoneda(),euros);
                    System.out.printf("%.2f\n", conversion);
                    break;
                case 2:
                    euros = pedirEuros();
                    cm.convertirTodo(cm.getCambioMoneda(),euros);
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                default:
                    break;

            }
        }while(opcionMenuPrincipal != 0);

    }

    /**
     * Imrpime el menu principal del cambio de moneda
     * @return
     */
    public int imprimeMenuPrincipal(){
        lector = new Scanner(System.in);
        int opcion = 0;
        boolean valido = false;
        System.out.println("***CAMBIO DE MONEDA***");
        System.out.println("1) Mirar cambio unico");
        System.out.println("2) Ver todo");
        System.out.println("0) Salir");
        try{
            opcion = Integer.parseInt(lector.nextLine());
            valido = true;
            if(opcion <= 2 && opcion >= 0 ){
                valido = true;
            }else{
                System.out.println("Introduce un numero entre el 2 y el 0");
            }
        }catch (NumberFormatException nfe){
            System.out.println("Por favor, introduce un numero");
        }
        return opcion;

    }

    /**
     * Pide y valida los euros.
     * @return
     */

    public double pedirEuros(){
        boolean valido = false;
        double euros = 0;
        do {
            System.out.println("Introduce los euros: ");
            try{
                euros = Double.parseDouble(lector.nextLine());
                if(euros >= 0){
                    valido = true;
                }else{
                    System.out.println("No puedes introducir un numero negativo.");
                }

            }catch (NumberFormatException nfe){
                System.out.println("Por favor, introduce un numero.");
            }
        }while(!valido);
        return euros;
    }
}
