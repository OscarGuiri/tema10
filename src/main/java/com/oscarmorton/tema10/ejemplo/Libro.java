package com.oscarmorton.tema10.ejemplo;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Libro implements Comparable<Libro>  {
    private int ISBN;
    private String titulo;
    private int nPaginas;

    /**
     * Contructor para introducir datos.
     * @param ISBN
     * @param titulo
     * @param nPaginas
     */
    public Libro(int ISBN, String titulo, int nPaginas) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.nPaginas = nPaginas;
    }


    /**
     * Contructor por defecto
     */
    public Libro() {
        this.ISBN = 1234;
        this.titulo = "Harry Potter";
        this.nPaginas = 300;
    }

    // La clase para compara numero de paginas
    public static class CompararNumeroPaginas implements Comparator<Libro>{

        @Override
        public int compare(Libro libro1, Libro libro2) {
            return libro1.getnPaginas() - libro2.getnPaginas();
        }

    }


    @Override
    public int compareTo(Libro libro) {
        return  this.titulo.compareTo(libro.getTitulo());
    }

    //Para imprimir los libros
    @Override
    public String toString(){
        return "Titulo: " + getTitulo() + "\nPAGINAS: " + getnPaginas() + "\nISBN: " + getISBN();
    }



    // GETTERS AND SETTERS
    public int getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getnPaginas() {
        return nPaginas;
    }
}
