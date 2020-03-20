package com.oscarmorton.tema10.ejer11;

import sun.security.x509.IssuerAlternativeNameExtension;
import utils.Lib;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejer11 {
    private ArrayList<Alumno> alumnos;
    private Scanner lector;
    private ArrayList aulas;
    private ArrayList grupos;

    public Ejer11(){
        // ESTE EJERCICIO NO PUDE TERMINAR.

        aulas = new ArrayList();
        grupos = new ArrayList();
        //AULAS POR DEFECTO:
        Aula alula101 = new Aula(101, 20.00);
        Aula alula102 = new Aula(102, 20.00);
        Aula alula103 = new Aula(103, 20.00);
        Aula alula104 = new Aula(104, 30.00);
        Aula alula105 = new Aula(105, 15.00);

        // Anyado las aulas al array list de aulas
        aulas.add(alula101);
        aulas.add(alula102);
        aulas.add(alula103);
        aulas.add(alula104);


        //GRUPOS POR DEFECTO
        Grupo dam1 = new Grupo(1,"1DAM",alula101);
        Grupo dam2 = new Grupo(2,"2DAM",alula102);
        Grupo smx1 = new Grupo(3,"1SMX",alula103);
        Grupo smx2 = new Grupo(4,"2SMX",alula104);
        grupos.add(dam1);
        grupos.add(dam2);
        grupos.add(smx1);
        grupos.add(smx2);
        alumnos = new ArrayList<>();
        int opcion = 0;
        boolean salir =false;

        do {
            opcion  = imprimeMenuPrincipal();
            switch (opcion) {
                case 1:
                    crearAlumno();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    salir = true;
                    break;

            }
            opcion = -1;
        }while (!salir);



    }
    public void crearAlumno(){
        String nombre = "";
        String apellido = "";
        int idGrupo = 0;
        nombre = pedirNombre();
        apellido = pedirApellido();
        System.out.println("En que grupo quieres poner el alumno nuevo?");
        mostarGrupos();
        System.out.println("En cual grupo quires poner el alumno?");
        idGrupo = Integer.parseInt(lector.nextLine());
        for(int i = 0; i < grupos.size(); i++){
           // if(grupos.get(i).getId == id){ No funciona

            //}
        }



    }
    public void mostarGrupos(){
        for(int i = 0; i < grupos.size(); i++){
            System.out.println(grupos.get(i).toString());

        }

    }


    /**
     * Pide y valida el nombre de un empleado.
     * @return
     */
    public String pedirNombre(){
        boolean valido = false;
        lector = new Scanner(System.in);
        String nombre = "";
        do {
            valido = true;
            System.out.println("Introduce el nombre del alumno:");
            nombre = lector.nextLine().toLowerCase();

            //Compruebo que el nombre no tenga numeros.
            for(int j = 0; j < nombre.length(); j++){
                if(Character.isDigit(nombre.charAt(j))){
                    valido = false;

                }
            }
            // Aviso al usuario que los nombres no pueden tener numeros
            if(!valido){
                System.out.println("Los nombres no pueden tener numeros.");
                Lib.pausa();
            }
            // Si el nombre esta vacio, aviso al usuario
            if(nombre.isEmpty()){
                valido = false;
                System.out.println("El nombre no puede estar vacio");
                Lib.pausa();
            }
        }while(!valido);
        return nombre;
    }
    public String pedirApellido(){
        boolean valido = false;
        lector = new Scanner(System.in);
        String nombre = "";
        do {
            valido = true;
            System.out.println("Introduce el apellido del alumno:");
            nombre = lector.nextLine().toLowerCase();

            //Compruebo que el nombre no tenga numeros.
            for(int j = 0; j < nombre.length(); j++){
                if(Character.isDigit(nombre.charAt(j))){
                    valido = false;

                }
            }
            // Aviso al usuario que los nombres no pueden tener numeros
            if(!valido){
                System.out.println("Los apellidos no pueden tener numeros.");
                Lib.pausa();
            }
            // Si el nombre esta vacio, aviso al usuario
            if(nombre.isEmpty()){
                valido = false;
                System.out.println("El apellidos no puede estar vacio");
                Lib.pausa();
            }
        }while(!valido);
        return nombre;
    }
    public int imprimeMenuAltas(){
        lector = new Scanner(System.in);
        int opcion = -1;
        boolean valido = false;

        do {
            System.out.println("*********************\n" +
                    "* ALTAS *\n" +
                    "*********************\n" +
                    "1. Nuevo alumno EN DESAROLLO\n" +
                    "2. Nuevo Asignatura EN DESAROLLO\n" +
                    "3. Nuevo Grupo EN DESAROLLO\n" +
                    "3. Nuevo Profesor EN DESAROLLO\n" +
                    "---------------------\n" +
                    "0. Salir");
            try {
                opcion = Integer.parseInt(lector.nextLine());
                if(opcion < 0 || opcion > 4 ){
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
    /**
     * Imprime el valor y valora si la entrada es lo que deberia.
     * @return
     */
    public int imprimeMenuPrincipal(){
        lector = new Scanner(System.in);
        int opcion = -1;
        boolean valido = false;

        do {
            System.out.println("*********************\n" +
                    "* GESTION DE COLEGIO *\n" +
                    "*********************\n" +
                    "1. Altas EN DESAROLLO\n" +
                    "2. Consultas EN DESAROLLO\n" +
                    "---------------------\n" +
                    "0. Salir");
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
