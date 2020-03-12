package com.oscarmorton.tema10.ejer10;

import utils.Lib;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ejer10 {
    private Scanner lector;
    private ArrayList<Empleado> empleados;

    public Ejer10(){
        int opcion = 0;
        do {
            opcion = imprimeMenu();
            switch (opcion) {
                case 1:
                        //nuevoEmpleato();
                    break;
                case 2:
                        //nuevoHijo();
                    break;
                case 3:
                        //modificarSueldo();
                    break;
                case 4:
                        //borrarEmpleado();
                    break;
                case 5:
                        //borrarHijo();
                    break;
                case 6:
                        //consultar();
                case 0:
                    System.out.println("Hasta pronto!");
                    break;

                default:
                    break;
            }
        }while(opcion != 0);




    }

    /**
     * Crea un nuevo empleado, validando los datos.
     */
    public void nuevoEmpleado(){
        lector = new Scanner(System.in);
        boolean valido = false;
        int id = 0;
        char respuesta = ' ';
        int nHijos = 0;
        String nombre = "";
        String apellido = "";
        GregorianCalendar fechaNaciemiento;
        double sueldo = 0;
        Hijos hijos;
        System.out.println("***CREAR EMPLEADO***");

        //Pidiendo id. FALTA COMPROBAR SI EXISTE!
        do{
            System.out.println("Introduce la id del empleado Entre 111111-999999]");
            try {
                id = Integer.parseInt(lector.nextLine());
                if(id < 111111 | id > 999999){
                    System.out.println("Introduce un valor entre el 111111 y el 999999");
                }else{
                    valido = true;
                }
            }catch(NumberFormatException nfe){
                System.out.println("Introduce un valor entre el 111111 y el 999999");
            }

        }while(!valido);
        valido = false;
        //Pidiendo si tiene hijos, y si tien, los crea
        do{
            System.out.println("Tiene hijos? Si o no?");

                respuesta = lector.nextLine().charAt(0);
                if(respuesta == 's'){
                    do {
                        System.out.println("Cuantos hijos?");
                        try {
                            nHijos = Integer.parseInt(lector.nextLine());
                            if(nHijos > 0) {
                                    hijos = crearHijo(nHijos);
                            }else{
                                System.out.println("Introduce un numero superior que 0");
                                valido = false;
                            }

                        } catch (NumberFormatException nfe) {
                            System.out.println("Introduce una cantidad");
                            valido = false;
                        }
                    }while(!valido);
                }


        }while(!valido);

    }

    /**
     * Pido y valido los datos para crear un hijo
     * @param nHijos El hijo.
     * @return
     */
    public Hijos crearHijo(int nHijos){
        lector = new Scanner(System.in);
        Hijos h;
        String nombre = "";
        int edad = 0;
        boolean valido = true;

        for(int i = 0; i < nHijos; i++){
            do {
                System.out.println("Introduce el nombre:");
                nombre = lector.nextLine();

                //Compruebo que el nombre no tenga numeros.
               for(int j = 0; j < nombre.length(); j++){
                   if(Character.isDigit(nombre.charAt(j))){
                       valido = false;

                   }
               }
               // Aviso al usuario que los nombres no pueden tener numeros
               if(!valido){
                   System.out.println("Los nombres no pueden tener numeros.");
               }
               // Si el nombre esta vacio, aviso al usuario
               if(nombre.isEmpty()){
                   valido = false;
                   System.out.println("El nombre no puede estar vacio");
               }
            }while(!valido);

            // Pido la edad:
            System.out.println("Introduce la edad");
            do {
                try {
                    edad = Integer.parseInt(lector.nextLine());
                    if (edad < 0) {
                        System.out.println("La edad no puede ser menor que 0");
                        valido = false;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("La edad tiene que ser un numero");
                    valido = false;
                }
            }while(!valido);
        }
        return h = new Hijos(nombre,edad);
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
