package com.oscarmorton.tema10.ejer10;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Empleado {
    private int id;
    private int nHijos = 0;
    private String nombre;
    private String apellido;
    private GregorianCalendar fechaNacimiento;
    private double sueldo;
    private ArrayList<Hijos> hijos;


    public Empleado(int id, String nombre, int nHijos, String apellido, GregorianCalendar fechaNacimiento, double sueldo, ArrayList<Hijos> hijos) {
        this.id = id;
        this.nHijos = 0;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.hijos = hijos;
    }

    //GETTERS AND SETTERS
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
