package org.iesalandalus.programacion.damas.modelo;

import java.util.Objects;

public class Posicion {
    private int fila;
    private char columna;

    // constructor que valida y asigna los valores usando los setters
    public Posicion(int fila, char columna) {
        setFila(fila);
        setColumna(columna);
    }
    // constructor copia
    public Posicion(Posicion otraPosicion) {
        if (otraPosicion == null) { // validar que no sea nulo el objeto recibido
            throw new IllegalArgumentException("No se puede copiar una posición nula.");
        }
        setFila(otraPosicion.getFila());
        setColumna(otraPosicion.getColumna());
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
    public char getColumna() {
        return columna;
    }

    // setter para columna con validación
    public void setColumna(char columna) {
        if(columna < 'a' || columna > 'h') {
            throw new IllegalArgumentException("La columna debe estar desde la 'a' hasta la 'h'");
        }
        this.columna = columna; // solo se asigna si el valor es válido
    }

    // compara dos objetos "Posicion" por igualdad en fila y columna
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // mismo objeto
        if (o == null || getClass() != o.getClass()) return false; // nulo o diferente clase
        Posicion posicion = (Posicion) o; // cast seguro
        return fila == posicion.fila && columna == posicion.columna;
    }

    // genera un código hash único basado en fila y columna
    @Override
    public int hashCode() {
        return Objects.hash(fila, columna);
    }

    @Override
    public String toString() {
        return fila + " " + columna;
    }
}