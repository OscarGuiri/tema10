package com.oscarmorton.tema10.ejer3;
import java.util.ArrayList;
import java.util.Stack;

public class Pila implements IPila {
    private static final int INITIAL_SIZE = 10;
    private ArrayList<String> datos;
    private int nElementos;
    public Pila() {
        this(INITIAL_SIZE);
    }

    public Pila(int size) {
        datos = new ArrayList();
        nElementos = 0;
    }


    @Override
    public void push(Object e) {

    }

    @Override
    public String pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String top() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
