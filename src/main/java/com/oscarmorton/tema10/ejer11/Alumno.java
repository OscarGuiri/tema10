package com.oscarmorton.tema10.ejer11;

import java.util.ArrayList;

public class Alumno {
    private int id;
    private String nomnbre;
    private String apellido;
    Grupo grupoAlumno;
    ArrayList asignaturasMatriculadas;

    public Alumno(int id, String nomnbre, String apellido, Grupo grupoAlumno, ArrayList asignaturasMatriculadas) {
        this.id = id;
        this.nomnbre = nomnbre;
        this.apellido = apellido;
        this.grupoAlumno = grupoAlumno;
        this.asignaturasMatriculadas = asignaturasMatriculadas;
    }
}
