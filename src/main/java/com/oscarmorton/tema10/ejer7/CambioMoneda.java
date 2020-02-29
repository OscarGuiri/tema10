package com.oscarmorton.tema10.ejer7;

import java.util.HashMap;
import java.util.Scanner;

public class CambioMoneda {
    private Scanner lector;

    private enum MONEDAS{USD,GBP, INR,AUD,CAD,ARS,BOB,CLP,VEZ,CRC,CUP,DOP ,MXN}
    private HashMap<MONEDAS, Double> cambioMoneda;
    private int opcion;

    //Contructor por defecto.
    public CambioMoneda(){
        cambioMoneda = new HashMap<>();
        this.cambioMoneda.put(MONEDAS.USD,1.09);
        this.cambioMoneda.put(MONEDAS.GBP,0.84);
        this.cambioMoneda.put(MONEDAS.INR,77.98);
        this.cambioMoneda.put(MONEDAS.AUD,1.66);
        this.cambioMoneda.put(MONEDAS.CAD,1.45);
        this.cambioMoneda.put(MONEDAS.ARS,67.21);
        this.cambioMoneda.put(MONEDAS.BOB,7.50);
        this.cambioMoneda.put(MONEDAS.CLP,886.33);
        this.cambioMoneda.put(MONEDAS.VEZ,10.8674);
        this.cambioMoneda.put(MONEDAS.CRC,620.56);
        this.cambioMoneda.put(MONEDAS.CUP,1.08);
        this.cambioMoneda.put(MONEDAS.DOP,57.93);
        this.cambioMoneda.put(MONEDAS.MXN,20.82);

    }

    public HashMap<MONEDAS, Double> getCambioMoneda() {
        return cambioMoneda;
    }

    /**
     * El menu para elegir la moneda que queremos
     * @return
     */
    public int imprimeMenuQueMoneda(){
        lector = new Scanner(System.in);
        boolean valido = false;
        int opcion = -1;
        do {
            System.out.println("***ELIGE LA MONEDA: ");
            System.out.println(" 1) USD (Dólar USA)\n" +
                    " 2) GBP (Libra esterlina)\n" +
                    " 3) INR (Rupia India)\n" +
                    " 4) AUD (Dólar Australiano)\n" +
                    " 5) CAD (Dólar Canadiense)\n" +
                    " 6) ARS (Peso Argentino)\n" +
                    " 7) BOB (Boliviano Boliviano)\n" +
                    " 8) CLP (Peso Chileno)\n" +
                    " 9) VEZ (Peso Colombiano)\n" +
                    " 10) CRC (Colón Costarricense)\n" +
                    " 11) CUP (Peso Cubano)\n" +
                    " 12) DOP (Peso Dominicano)\n" +
                    " 13) MXN (Peso Mexicano)");
            try{
                opcion = Integer.parseInt(lector.nextLine());

                if(opcion <= 13 && opcion > 0 ){
                    valido = true;
                }else{
                    System.out.println("Introduce un numero entre el 1 y el 13");
                }
            }catch (NumberFormatException nfe){
                System.out.println("Por favor, introduce un numero");
            }

        }while(!valido);
        this.opcion = opcion;
        return opcion;
    }
    public MONEDAS traduccionMoneda(int opcion){
        switch(opcion){
            case 1:
                return MONEDAS.USD;

            case 2:
                return MONEDAS.GBP;

            case 3:
                return MONEDAS.INR;

            case 4:
                return MONEDAS.AUD;

            case 5:
                return MONEDAS.CAD;

            case 6:
                return MONEDAS.ARS;

            case 7:
                return MONEDAS.BOB;

            case 8:
                return MONEDAS.CLP;

            case 9:
                return MONEDAS.VEZ;

            case 10:
                return MONEDAS.CRC;

            case 11:
                return MONEDAS.CUP;

            case 12:
                return MONEDAS.DOP;


            case 13:
                return MONEDAS.MXN;

            default:
                System.out.println("ERROR FORMATO MONEDA");
                break;


        }
        return MONEDAS.USD;
    }
    public double convertirMonedaUnica(HashMap<MONEDAS,Double> cambio, double euros){
        double conversion = 0;

        return conversion = (cambio.get(traduccionMoneda(opcion)) * euros);

    }
    public void convertirTodo(HashMap<MONEDAS,Double> cambio, double euros){
        System.out.printf("USD %.2f\n", + (cambio.get(MONEDAS.USD)) * euros);
        System.out.printf("GPB %.2f\n", + (cambio.get(MONEDAS.GBP)) * euros);
        System.out.printf("INR %.2f\n", + (cambio.get(MONEDAS.INR)) * euros);
        System.out.printf("AUD %.2f\n", + (cambio.get(MONEDAS.AUD)) * euros);
        System.out.printf("CAD %.2f\n", + (cambio.get(MONEDAS.CAD)) * euros);
        System.out.printf("ARS %.2f\n", + (cambio.get(MONEDAS.ARS)) * euros);
        System.out.printf("BOB %.2f\n", + (cambio.get(MONEDAS.BOB)) * euros);
        System.out.printf("CLP %.2f\n", + (cambio.get(MONEDAS.CLP)) * euros);
        System.out.printf("VEZ %.2f\n", + (cambio.get(MONEDAS.VEZ)) * euros);
        System.out.printf("CRC %.2f\n", + (cambio.get(MONEDAS.CRC)) * euros);
        System.out.printf("CUP %.2f\n", + (cambio.get(MONEDAS.CUP)) * euros);
        System.out.printf("DOP %.2f\n", + (cambio.get(MONEDAS.GBP)) * euros);
        System.out.printf("MXN %.2f\n", + (cambio.get(MONEDAS.GBP)) * euros);



    }

}
