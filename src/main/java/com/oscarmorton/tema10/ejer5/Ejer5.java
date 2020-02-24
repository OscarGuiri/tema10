package com.oscarmorton.tema10.ejer5;

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
        int mayorMenor = 0;



        LocalDate today = LocalDate.now();


        String fechaNacimientoString;
        GregorianCalendar fechaNacimiento = null;




        //LocalDate nacimiento = LocalDate.of(anyo,mes,dia);
        //edad = Period.between(nacimiento, today).getYears()

        //Creo los pacientes.
        Paciente.sexo sexoM = Paciente.sexo.M;
        Paciente.sexo sexoF = Paciente.sexo.F;
        pacientes.add(p1 = new Paciente(1, "Oscar", "Morton", 20, sexoF,1.63,57 ));
        pacientes.add(p2 = new Paciente(2, "Niall", "Horan", 29, sexoF,1.74,60.5));
        pacientes.add(p3 = new Paciente(3, "Zayn", "Malik", 57, sexoF,1.62,50.8));
        pacientes.add(p4 = new Paciente(4, "Liam", "Payne", 47, sexoM,1.78,72.5));
        pacientes.add(p5 = new Paciente(4, "Harry", "Styles", 59, sexoM,1.8,85.2));

        mayorMenor = mayorMenor(pacientes);

        System.out.println(mayorMenor);




    }

    /**
     * Devueve la edad mayor y la edad menor juntos en un int
     * @param pacientes
     * @return
     */
    public int mayorMenor( ArrayList<Paciente> pacientes){
        int idPacientemayor = 0; // No utilizo Integer.MIN_VALUE por que no puede haber edades negativos.
        int idPacienteMenor =Integer.MAX_VALUE;
        String conjutoNumeros = "";

        for(int i  = 0; i < pacientes.size(); i++){
            if(pacientes.get(i).getEdad() > idPacientemayor){
                idPacientemayor = pacientes.get(i).getEdad();

            }
            if(pacientes.get(i).getEdad() < idPacienteMenor){
                idPacienteMenor = pacientes.get(i).getEdad();

            }
        }
        // Conjunto los numeros utilizando un String
        conjutoNumeros += idPacientemayor;
        conjutoNumeros += idPacienteMenor;
        int conjuntoNumerosInt = Integer.parseInt(conjutoNumeros);
        return  conjuntoNumerosInt;

    }
}
