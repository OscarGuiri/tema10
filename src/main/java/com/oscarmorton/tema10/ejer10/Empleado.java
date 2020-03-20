package com.oscarmorton.tema10.ejer10;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Empleado {
    private int id;
    private int nHijos;
    private String nombre;
    private String apellido;
    private GregorianCalendar fechaNacimiento;
    private double sueldo;
    private ArrayList<Hijos> hijos;


    public Empleado(int id, int nHijos, String nombre, String apellido, GregorianCalendar fechaNacimiento, double sueldo, ArrayList<Hijos> hijos) {
        this.id = id;
        this.nHijos = nHijos;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.hijos = hijos;
    }

    /**
     * Anyade un los nuevos hijos al empleado
     * @param hijosIntroducidos Nuevos hijos.
     */
    public void anyadirHijoALEmpleado(ArrayList<Hijos> hijosIntroducidos){
        for(int i = 0; i < hijosIntroducidos.size(); i++){
            this.hijos.add(hijosIntroducidos.get(i));
        }
    }

    /**
     * Elimina el hijo con el nombre recibino como paramentro, si el nombre no exite, devuelve false.
     * @param nombreHijo
     * @return
     */
    public boolean eliminarHijoEmpleado(String nombreHijo){
        boolean eliminado = false;
        for(int i = 0; i < this.hijos.size(); i++){
            if(this.hijos.get(i).getNombre().equals(nombreHijo)){
                this.hijos.remove(i);
                eliminado = true;
            }
        }
        return eliminado;
    }

    public String empleadoToString(){
        String detallesHijos = "";
        if(nHijos != 0) {
            for (int i = 0; i < hijos.size(); i++) {
                detallesHijos += hijos.get(i).getNombre() + " " + hijos.get(i).getEdad() + "\n";
            }
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return String.format("id: %-10s",id) +
                String.format(" Numero de hijos: %-14s",nHijos) +
                String.format(" Nombre:  %-12s",nombre) + "\t" +
                String.format(" Apellido: %-20s",apellido) + "\t" +
                String.format(" fercha de nacimiento: %10s", sdf.format(fechaNacimiento.getTime())) +
                String.format(" sueldo: %10s",String.format("%.2f",sueldo) + " euros\n") +
                String.format("Detalles Hijos:\n %-12s",detallesHijos);



    }

    //GETTERS AND SETTERS

    public ArrayList<Hijos> getHijos() {
        return hijos;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getnHijos() {
        return nHijos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getId() {
        return id;
    }
}
