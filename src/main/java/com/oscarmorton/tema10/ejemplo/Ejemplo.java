package com.oscarmorton.tema10.ejemplo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Ejemplo {
    public Ejemplo(){
        // Creo los libros
        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(new Libro(12345,"Harry Potter", 300));
        libros.add(new Libro(12434,"Lord of the rings", 400));
        libros.add(new Libro(21335,"El Quijote", 500));
        libros.add(new Libro(12331,"El Quijote Parte II", 600));

        System.out.println("Libros no ordenados: ");
        System.out.println(libros.toString() + "\n");
        Collections.sort(libros);
        System.out.println("Libros ordenados por titulo: ");
        System.out.println(libros.toString() + "\n");

        System.out.println("Libros ordenados por pagina: ");
        libros.sort(new Libro.CompararNumeroPaginas()); // Llamo a las clase Comparar Numeros Pagina de la clase Libros
        System.out.println(libros.toString());


    }

}
