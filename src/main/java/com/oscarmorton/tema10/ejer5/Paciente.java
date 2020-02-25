package com.oscarmorton.tema10.ejer5;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.time.Period;


public class Paciente {
    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    enum sexo{M,F}
    private sexo s;
    private double altura;
    private double peso;

    /**
     * Contructor principal.
     * @param id
     * @param nombre
     * @param apellidos
     * @param
     * @param s
     * @param altura
     * @param peso
     */
    public Paciente(int id, String nombre, String apellidos, int edad, sexo s, double altura, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.s = s;
        this.altura = altura;
        this.peso = peso;
    }

    /**
     * Contructor por defecto.
     */
    public Paciente() {
        this.id = 111111111;
        this.nombre = "nomPaciente";
        this.apellidos = "apePaciente";
        this.edad = 21;
        this.s = s;
        this.altura = altura;
        this.peso = peso;
    }

    /**
     * Convierte las detalles del paciente a un string
     * @return
     */
    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return  String.format("%9d ",id) +
                String.format("%2d ",edad) +
                String.format("%-4s ", s) +
                String.format("%.2f ",peso) +
                String.format("%.2f ",altura) +
                String.format("%16s ",String.format("%-12s",nombre)) +
                String.format("%-25s ",apellidos);



    }


    // GETTERS AND SETTERS
    public int getEdad() {
        return edad;
    }
    public sexo getS() {
        return s;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }
}
