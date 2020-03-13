package com.oscarmorton.tema10.ejer10;

public class Hijos {
    private String nombre;
    private int edad;

    /**
     * Contructor para crear un nuevo hijo
     * @param nombre
     * @param edad
     */
    public Hijos(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;

    }

    //GETTERS AND SETTER
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
