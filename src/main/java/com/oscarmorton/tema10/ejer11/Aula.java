package com.oscarmorton.tema10.ejer11;

public class Aula {
    private int idAula;
    double metrosCuadrados;

    public Aula(int idAula, double metrosCuadrados) {
        this.idAula = idAula;
        this.metrosCuadrados = metrosCuadrados;
    }
    @Override
    public String toString(){
        return "";
    }
        // GETTERS AND SETTERS
    public int getIdAula() {
        return idAula;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }


}
