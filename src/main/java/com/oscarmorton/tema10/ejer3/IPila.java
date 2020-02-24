package com.oscarmorton.tema10.ejer3;

public interface IPila<String> {
    void push(String e);
    String pop();
    int size();
    String top();
    boolean isEmpty();
}
