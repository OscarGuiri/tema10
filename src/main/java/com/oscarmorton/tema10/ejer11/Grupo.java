package com.oscarmorton.tema10.ejer11;

public class Grupo {
    private int id;
    private String nombre;
    Aula alulaRefecencia;

    public Grupo(int id, String nombre, Aula alulaRefecencia) {
        this.id = id;
        this.nombre = nombre;
        this.alulaRefecencia = alulaRefecencia;
    }

    // GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Aula getAlulaRefecencia() {
        return alulaRefecencia;
    }
    @Override
    public String toString(){
        return String.format("id: %-10s",id) +
                String.format(" Nombre: %-14s",nombre) +
                String.format(" Id aula: %-14s",alulaRefecencia.getIdAula()) +
                String.format(" Metros aula: %-14s",alulaRefecencia.getMetrosCuadrados());



    }



}
