package org.iesalandalus.programacion.damas.modelo;

public class Posicion {
    private int fila;
    private char columna;

    // constructor que valida y asigna los valores usando los setters
    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }

    // getter fila
    public int getFila() {
        return fila;
    }

    // setter fila con validación
    public void setFila(int fila) {
        if (fila < 1 || fila > 8) { // fila fuera del rango válido
            throw new IllegalArgumentException("La fila debe estar desde el 1 hasta el 8.");
        }
        this.fila = fila; // solo se asigna si el valor es válido
    }

    // getter para columna
    public int getColumna() {
        return columna;
    }

    //setter para columna con validación
    public void setColumna(char columna) {
        if(columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("La columna debe estar desde la 'a' hasta la 'h'");
        }
        this.columna = columna; // solo se asigna si el valor es válido
    }
}
