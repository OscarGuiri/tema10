package com.oscarmorton.tema10.ejer5;

import org.w3c.dom.ls.LSOutput;
import utils.Lib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class Ejer5 {
    private Scanner lector;
    private Paciente p1, p2, p3, p4, p5;

    // Enum de la masa
    private enum MASA{
        INSUFICIENTE, NORMAL, GRADO1, GRADO2, GRADO3
    }

    public Ejer5(){
        lector = new Scanner(System.in);
        ArrayList<Paciente> pacientes = new ArrayList<>(5);
        int[] mayorMenor = new int[2];
        int[] pacientesPerSexe = new int[2];
        double masaCorporal = 0;


        /**
        LocalDate today = LocalDate.now();
        String fechaNacimientoString;
        GregorianCalendar fechaNacimiento = null;
        LocalDate nacimiento = LocalDate.of(anyo,mes,dia);
        edad = Period.between(nacimiento, today).getYears()
         */
        //Creo los pacientes.
        Paciente.sexo sexoM = Paciente.sexo.M;
        Paciente.sexo sexoF = Paciente.sexo.F;
        pacientes.add(p1 = new Paciente(1, "Oscar", "Morton", 20, sexoF,1.63,57 ));
        pacientes.add(p2 = new Paciente(2, "Niall", "Horan", 29, sexoF,1.74,60.5));
        pacientes.add(p3 = new Paciente(3, "Zayn", "Malik", 57, sexoF,1.62,50.8));
        pacientes.add(p4 = new Paciente(4, "Liam", "Payne", 47, sexoM,1.78,72.5));
        pacientes.add(p5 = new Paciente(4, "Harry", "Styles", 59, sexoM,1.8,85.2));

        // Llamo los metodos
        mayorMenor = mayorMenor(pacientes);
        for(int i = 0; i < pacientes.size(); i++) {
            if(pacientes.get(i).getEdad() == mayorMenor[0]){
                System.out.println("PACIENTE MAYOR Edad: " + mayorMenor[0] + " Sexo: " + pacientes.get(i).getS());
            }
            if(pacientes.get(i).getEdad() == mayorMenor[1]) {
                System.out.println("PACIENTE MENOR Edad: " + mayorMenor[1]+ " Sexo: " + pacientes.get(i).getS());
            }
        }
        pacientesPerSexe = pacientsPerSexe(pacientes);
        System.out.println("Cantidad de pacientes por sexo: ");
        System.out.println("Hombres: " + pacientesPerSexe[0] + " Mujeres: " + pacientesPerSexe[1]);


        // NO ENTIENDO POR QUE UN SWITCH NO ACEPTE DOUBLES
        for(int i  = 0; i < pacientes.size(); i++){
           masaCorporal = calculoMasaCorporal(pacientes.get(i));
            if(masaCorporal < 18.5){
                System.out.println("Paciente numero " + (i + 1) + ": " + "Peso Insuficiente" );
            }
            if(masaCorporal > 18.5 && masaCorporal < 24.9){
                System.out.println("Paciente numero " + (i + 1) + ": " + "Peso Normal" );
            }
            if(masaCorporal > 25 && masaCorporal < 26.9){
                System.out.println("Paciente numero " + (i + 1) + ": " + "Sobrepeso grado I" );
            }
            if(masaCorporal > 27 && masaCorporal < 29.9){
                System.out.println("Paciente numero " + (i + 1) + ": " + "Sobrepeso grado II" );
            }
            if(masaCorporal > 29.9){
                System.out.println("Paciente numero " + (i + 1) + ": " + "Sobrepeso grado III" );
            }
        }



    }

    /**
     * Devueve la edad mayor y menor de los paciente.
     * @param pacientes
     * @return
     */
    public int[] mayorMenor( ArrayList<Paciente> pacientes){
        int pacienteMayor = 0; // No utilizo Integer.MIN_VALUE por que no puede haber edades negativos.
        int pacienteMenor =Integer.MAX_VALUE;
        int[] numeros = new int[2];

        for(int i  = 0; i < pacientes.size(); i++){
            if(pacientes.get(i).getEdad() > pacienteMayor){
                pacienteMayor = pacientes.get(i).getEdad();

            }
            if(pacientes.get(i).getEdad() < pacienteMenor){
                pacienteMenor = pacientes.get(i).getEdad();

            }
        }
        numeros[0] = pacienteMayor;
        numeros[1] = pacienteMenor;

        return  numeros;

    }

    /**
     * Devuelve un array de 2 posiciones con el numero de hombre en posicion 0, y en el otro posicoon las mujeres.
     * @param pacientes
     * @return
     */
    public int[] pacientsPerSexe(ArrayList<Paciente> pacientes){
        int contM = 0;
        int contF = 0;
        int[] numeros = new int[2];
        for(int i  = 0; i < pacientes.size(); i++){
            if(pacientes.get(i).getS() == Paciente.sexo.M){
                contM++;

            }
            if(pacientes.get(i).getS() == Paciente.sexo.F){
                contF++;

            }
        }
        numeros[0] = contM;
        numeros[1] = contF;
        return numeros;
    }

    /**
     * Calcual la masa corporal de un paciente.
     * @param paciente  el IMC del paciente
     * @return
     */
    public double calculoMasaCorporal(Paciente paciente){
        //IMC = pes / (altura*altura)
        double pes = 0;
        double altura = 0;

        altura = paciente.getAltura();
        pes = paciente.getPeso();

        return pes / (altura * altura);

    }
}
