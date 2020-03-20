package com.oscarmorton.tema10.ejer10;

import com.sun.source.tree.CompoundAssignmentTree;
import org.graalvm.compiler.debug.CSVUtil;
import utils.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Ejer10 {
    private Scanner lector;
    private ArrayList<Empleado> empleados;


    public Ejer10(){
        empleados = new ArrayList<>();
        int opcion = 0;

        do {
            opcion = imprimeMenu();
            switch (opcion) {
                case 1:
                    Lib.limpiarPantalla();
                    empleados.add(nuevoEmpleado()); // Anyado un nuevo empleado al array list de empleados.
                    break;
                case 2:
                    Lib.limpiarPantalla();
                    nuevoHijo();
                    break;
                case 3:
                    Lib.limpiarPantalla();
                    modificarSueldo();
                    break;
                case 4:
                    Lib.limpiarPantalla();
                        borrarEmpleado();
                    break;
                case 5:
                    Lib.limpiarPantalla();
                    borrarHijo();
                    break;
                case 6:
                    Lib.limpiarPantalla();
                    consultar();
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
    public Empleado nuevoEmpleado(){
        lector = new Scanner(System.in);
        Empleado empleado;
        boolean valido = false;
        int id = 0;
        char respuesta = ' ';
        int nHijos = 0;
        int contadorhijos = 0;
        String nombre = "";
        String apellido = "";
        GregorianCalendar fechaNaciemiento = null;
        double sueldo = 0;
       ArrayList<Hijos> hijos = null;
        System.out.println("***CREAR EMPLEADO***");


        id = pedirID(); //Pidiendo id.

        // Si exite el empleado, pido el resto de los detalles, si no, devuelo null.
        if(!empleadoExiste(id)){

        //Pidiendo si tiene hijos, y si tien, los crea
        do{
            System.out.println("Tiene hijos? Si o no?");

                respuesta = lector.nextLine().toLowerCase().charAt(0);
                if(respuesta == 's'){
                    do {
                        System.out.println("Cuantos hijos?");
                        try {
                            nHijos = Integer.parseInt(lector.nextLine());
                            if(nHijos > 0) {

                                    hijos = crearHijos(nHijos);
                                    valido = true;
                            }else{
                                System.out.println("Introduce un numero superior que 0");
                                valido = false;
                                Lib.pausa();
                            }

                        } catch (NumberFormatException nfe) {
                            System.out.println("Introduce una cantidad");
                            valido = false;
                        }
                    }while(!valido);
                }else if(respuesta != 'n'){
                    System.out.println("Por favor, dir si o no.");
                    Lib.pausa();
                    valido = false;
                }else{
                    valido = true;
                }
        }while(!valido);

        //Pido los detallas del nombre del empleado:
        nombre = pedirNombre();

        //Pido el apellido del empleado
        do {
            valido = true;
            System.out.println("Introduce el apellido del empleado:");
            apellido = lector.nextLine().toLowerCase();

            //Compruebo que el nombre no tenga numeros.
            for(int j = 0; j < apellido.length(); j++){
                if(Character.isDigit(apellido.charAt(j))){
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

        do {
            System.out.println("Fecha nacimiento del empleado: (dd-mm-yyyy): ");
            String fechaNacimientoString = lector.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date date = sdf.parse(fechaNacimientoString);
                fechaNaciemiento = new GregorianCalendar();
                fechaNaciemiento.setTime(date);
               valido = true;
            } catch (ParseException pe) {
                valido = false;
                System.out.println("El formato de la fecha de fabricación no es válido. Recuerde (dd-mm-yyyy).");
                Lib.pausa();
            }
        } while (!valido);
        valido = false;
        //Pido el sueldo
        sueldo = pedirSueldo();

       empleado = new Empleado(id, nHijos,nombre,apellido,fechaNaciemiento,sueldo,hijos);
            System.out.println("Empleado creado correctamente");
       return empleado;
        }else{
            System.out.println("El empleado con id " + id + " ya existe");
            return null;

        }


    }

    /**
     * Busca un empleado por DNI, si lo encuentra devuelve TRUE
     * @param DNI
     * @return
     */
    public boolean empleadoExiste(int DNI){
        boolean encontrado = false;
            for(int i = 0; i < empleados.size(); i++){
                if(empleados.get(i).getId() == DNI){
                    encontrado = true;
                }
            }
        return encontrado;
    }

    /**
     * Pido y valido los datos para crear un hijo
     * @param nHijos El hijo.
     * @return
     */
    public ArrayList<Hijos> crearHijos(int nHijos){
        lector = new Scanner(System.in);
        Hijos h;
        ArrayList hijosArray = new ArrayList(nHijos);
        String nombre = "";
        int edad = 0;
        int contador = 0;
        boolean valido = true;

        for(int i = 0; i < nHijos; i++){
            System.out.println("Creando el hijo numero " + (contador + 1));
            do {
                System.out.println("Introduce el nombre:");
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
               }
               // Si el nombre esta vacio, aviso al usuario
               if(nombre.isEmpty()){
                   valido = false;
                   System.out.println("El nombre no puede estar vacio");
                   Lib.pausa();
               }
            }while(!valido);

            // Pido la edad:

            do {
                System.out.println("Introduce la edad");
                try {
                    edad = Integer.parseInt(lector.nextLine());
                    valido = true;
                    if (edad < 0) {
                        System.out.println("La edad no puede ser menor que 0");
                        valido = false;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("La edad tiene que ser un numero");
                    valido = false;
                    Lib.pausa();
                }
            }while(!valido);
            h= new Hijos(nombre, edad); // Introduzco los detalles del hijo
            hijosArray.add(h); // Lo añado a la lista.
            contador++;
        }
        return hijosArray;

    }

    /**
     * Anyade nuevos hijos al id del empleado que le pide.
     */
    public void nuevoHijo(){
        boolean valido = false;
        int id = 0;
        int nHijos = 0;
        ArrayList<Hijos> arrayListHijos;

        id = pedirID(); // Consigo el id.
        if(empleadoExiste(id)){
            do {
                System.out.println("Cuantos hijos quieres anyadir?");
                try {
                    nHijos = Integer.parseInt(lector.nextLine());
                    valido = true;
                } catch (NumberFormatException nfe) {
                    System.out.println("Tienes que introducir un numero.");
                    Lib.pausa();
                }
            }while(!valido);
            arrayListHijos = new ArrayList<>(nHijos);
            arrayListHijos = crearHijos(nHijos);

            for(int i = 0; i < empleados.size(); i++){ // Recorro todos los empleados hasta que encuentro el que tiene el id intrducido y anyado el array de hijos al empleado.

                if( empleados.get(i).getId() == id){
                    empleados.get(i).anyadirHijoALEmpleado(arrayListHijos);
                }

            }
            System.out.println("Hijo creado correctamente");
            Lib.pausa();
        }else{
            System.out.println("El ID del empleado no exite.");
        }

    }
    public void modificarSueldo(){
          boolean valido = false;
          int id = 0;
          double modificacionSueldo = 0;
          double sueldoEmpleado = 0;
          double aux = 0;
          id = pedirID();
          Empleado empleado;
          if(empleadoExiste(id)){

               for(int i = 0; i < empleados.size(); i++){ // Recorro todos los empleados para adquirir su sueldo
                   if( empleados.get(i).getId() == id){
                       sueldoEmpleado = empleados.get(i).getSueldo();
                   }
               }
               System.out.println("El sueldo del empleado con id " + id + " es: " + sueldoEmpleado);
               do {
                   System.out.println("Introduce el sueldo que quieres quitar/introducir");
                   try {
                       modificacionSueldo = Double.parseDouble(lector.nextLine());
                       valido = true;
                   } catch (NumberFormatException nfe) {
                       System.out.println("Has introducido una letra");
                   }
                   // Antes de modificar el sueldo, compruebo que cuando se modifica el sueldo el empleado no se queda con un sueldo negativo.
                  aux = sueldoEmpleado + modificacionSueldo;
                   if(aux > 0){
                       for(int i = 0; i < empleados.size(); i++){
                           if( empleados.get(i).getId() == id){
                               empleados.get(i).setSueldo(aux);

                           }
                       }

                       System.out.println("Sueldo modificado correctamente");
                       valido = true;
                   }else{
                       System.out.println("El sueldo del empleado no puede ser menor que 0");
                       valido = false;
                   }

               }while(!valido);




           }else{
               System.out.println("El empleado no exite.");
           }

    }
    public void borrarEmpleado(){
        int id = 0;
        boolean eliminado = true;
        id = pedirID();
        if(empleadoExiste(id)){
            for(int i = 0; i < empleados.size(); i++){
                if(empleados.get(i).getId() == id){
                    empleados.remove(i);
                    eliminado = true;
                }
            }
        }else{
            System.out.println("El empleado con el id " + id + " no exite.");
            Lib.pausa();
        }
        if(eliminado){
            System.out.println("Empleado eliminado correctamente");
            Lib.pausa();
        }else{
            System.out.println("Empleado no eliminado");
            Lib.pausa();
        }
    }
    public void borrarHijo(){
        int id = 0;
        boolean borrado = false;
        boolean valido = true;
        String nombre = "";
        ArrayList hijosEmpleado;
        id = pedirID();
        if(empleadoExiste(id)){ // Si el empleado exite, elimino el hijo

            // Pido el nombre.
            do {
                System.out.println("Introduce el nombre del hijo que quieres borrar:");
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
                }
                // Si el nombre esta vacio, aviso al usuario
                if(nombre.isEmpty()){
                    valido = false;
                    System.out.println("El nombre no puede estar vacio");
                    Lib.pausa();
                }
            }while(!valido);

            // Recorro todos los empleados hasta encontrar el empleado con el id introducido y elimino su hijo.
            for(int i = 0; i < empleados.size(); i++){
                if(empleados.get(i).getId() == id){
                    borrado = empleados.get(i).eliminarHijoEmpleado(nombre);

                }
            }


        }else{
            System.out.println("El empleado con el id " + id + " no exite");
            Lib.pausa();
        }
        if(borrado){
            System.out.println("hijo borrado correctamente");
        }else{
            System.out.println("Hijo no borrado");
        }

    }
    public void consultar(){
        Lib.limpiarPantalla();
        int opcion = 0;
        String nommbre = "";

        do {
            opcion = imprimirMenuConsultas();
            switch (opcion) {
                case 1: // Buscar empleado por id
                    Lib.limpiarPantalla();
                    int id;
                    id = pedirID();
                    if(empleadoExiste(id)){
                        for(int i = 0; i < empleados.size(); i++){
                            if(empleados.get(i).getId() == id){
                                System.out.println("Detalles del empleado con id " + id);
                                System.out.println("----------------------------------------");
                                System.out.println( empleados.get(i).empleadoToString());
                                System.out.println("----------------------------------------");


                            }
                        }

                    }else{
                        System.out.println("El empleado con id " + id + " no exites");
                    }
                    break;
                case 2: //Buscar empleado por nombre
                    Lib.limpiarPantalla();
                    nommbre = pedirNombre(); // Pido el nombre.
                    buscarEmpleadoPorNombre(nommbre);  // imprimo los empleados con ese nombre
                    break;
                case 3:
                    Lib.limpiarPantalla();
                    //buscarPorRangoDeEdad(); // EN DESAROLLO
                    break;
                case 4:
                    Lib.limpiarPantalla();
                    double sueldo1 = 0;
                    double sueldo2 = 0;
                    System.out.println("Pidiendo el sueldo 1:");
                    sueldo1 = pedirSueldo();
                    System.out.println("Pidiendo el sueldo 2:");
                    sueldo2 = pedirSueldo();
                    buscarPorRangoDeSueldo(sueldo1, sueldo2);
                    break;
                case 5:
                    Lib.limpiarPantalla();
                    buscarPorMenorEdad();
                    break;
                case 0:
                    break;

                default:
                    break;

            }
        }while(opcion != 0);


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
                System.out.println("Introduce el nombre del empleado:");
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


    /**
     * Imprime el menu de consultas
     * @return
     */


    /**
     * Buscar empleado por nombre y emprime el empleado NO SABIA COMO HACERLO POR CARACTERES
     * @param nombre
     * @return
     */
    public void buscarEmpleadoPorNombre(String nombre){
        boolean encontrado = false;

        for(int i = 0;  i < empleados.size(); i++){
            if(empleados.get(i).getNombre().equals(nombre)){
                System.out.println( empleados.get(i).empleadoToString())
               ;
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("Empleado no encotrado");
        }


    }

    /**
     * Pide y valida el sueldo
     * @return
     */
    public double pedirSueldo(){
        double sueldo = 0;
        boolean valido = false;
        do{
            System.out.println("Introduce el sueldo: ");
            try {
                sueldo = Double.parseDouble(lector.nextLine());
                valido = true;
            } catch (NumberFormatException nfe){
                System.out.println("Por favor, introduce un numero.");
                Lib.pausa();
            }
            if(sueldo < 0){
                valido = false;
            }
        }while(!valido);
        return  sueldo;
    }

    /**
     * Imprime los empleados que tienes un sueldo entre los 2 paramentros
     * @param sueldo1 El sueldo minimo
     * @param sueldo2 El el sueldo maximo
     */
    public void buscarPorRangoDeSueldo(double sueldo1, double sueldo2){
        for(int i = 0;  i < empleados.size(); i++){
            if(empleados.get(i).getSueldo() >= sueldo1 || empleados.get(i).getSueldo() <= sueldo2 ){ // Si está entre sueldo 1 y sueldo 2, imprime los detalles del empleado.
                empleados.get(i).empleadoToString();
            }
        }

    }

    /**
     * Imprime todos los empleados que tienes hijos menores de 18 anyos
     *
     */
    public void buscarPorMenorEdad(){

        for(int i = 0;  i < empleados.size(); i++){ // recorro todos los empleados
           if(empleados.get(i).getnHijos() != 0){ // si los empleados tienen tiene hijos, recorre los hijos
                for (int j = 0; j < empleados.get(i).getHijos().size(); j++) { // recorre los hijos del empleado
                    if (empleados.get(i).getHijos().get(j).getEdad() < 18) { // si uno de los hijos es de menor edad, imprime el empleado
                        System.out.println(empleados.get(i).empleadoToString());


                    }
                }
            }
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

    /**
     * Pide y valida el id para un empleado
     * @return el id, validado.
     */
    public int pedirID(){
        int id = 0;
        boolean valido = false;
        do{
            System.out.println("Introduce la id del empleado Entre 111111-999999]");
            try {
                id = Integer.parseInt(lector.nextLine());
                if(id < 111111 | id > 999999){
                    System.out.println("Introduce un valor entre el 111111 y el 999999");
                    Lib.pausa();
                }else{
                    valido = true;
                }
            }catch(NumberFormatException nfe){
                System.out.println("Introduce un valor entre el 111111 y el 999999");
                Lib.pausa();
            }

        }while(!valido);
        return  id;
    }
    public int imprimirMenuConsultas(){
        lector = new Scanner(System.in);
        int opcion = -1;
        boolean valido = false;

        do {
            System.out.println("***********************\n" +
                    "* CONSULTAS EMPLEADOS *\n" +
                    "***********************\n" +
                    "1. Buscar por NIF\n" +
                    "2. Buscar por nombre\n" +
                    "3. Buscar por rango de edad. EN DESAROLLO\n" +
                    "4. Buscar por rango de sueldo.\n" +
                    "5. Buscar por hijos menores de edad\n" +
                    "-----------------------------\n" +
                    "0. Volver al menú principal");
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
