package org.iesalandalus.programacion.damas.modelo;

import java.util.Random;
import java.util.List;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    // constructor
    public Dama() {
        this.color = Color.BLANCO; // blanca por defecto
        this.posicion = posicionInicialAleatoria();
        this.esDamaEspecial = false; // por defecto no es especial
    }
    // getter color
    public Color getColor() {
        return color;
    }

    // setter color con validación
    public void setColor(Color color) {
        if (color == null) { // que no sea nulo
            throw new IllegalArgumentException("El color no puede ser nulo.");
        }
        this.color = color; // solo se asigna si el valor es válido
    }

    // getter posicion
    public Posicion getPosicion() {
        return posicion;
    }

    // setter posicion con validación
    public void setPosicion(Posicion posicion) {
        if (posicion == null) {
            throw new IllegalArgumentException("La posición no puede ser nula");
        }
        this.posicion = posicion;
    }

    // getter esDamaEspecial
    public boolean getEsDamaEspecial() {
        return esDamaEspecial;
    }

    // setter esDamaEspecial
    public void setEsDamaEspecial(boolean esDamaEspecial) {
        this.esDamaEspecial = esDamaEspecial;
    }

    // metodo auxiliar para generar una posición inicial aleatoria válida
    private Posicion posicionInicialAleatoria() {
        Random random = new Random();
        int fila = random.nextInt(3) + 1; // genera fila aleatoria (1, 2 o 3)
        char columna = columnaAleatoria(fila); // obtiene columna válida para esa fila

        return new Posicion(fila, columna);
    }

    // metodo para obtener columna aleatoria valida dependiendo de la fila
    private char columnaAleatoria(int fila) {
        List<Character> columnasValidas;

        switch (fila) {
            case 1:
                columnasValidas = List.of('a', 'c', 'e', 'g'); // casillas negras fila 1
                break;
            case 2:
                columnasValidas = List.of('b', 'd', 'f', 'h'); // casillas negras fila 2
                break;
            case 3:
                columnasValidas = List.of('a', 'c', 'e', 'g'); // casillas negras fila 3
                break;
            default:
                throw new IllegalArgumentException("Fila fuera de rango.");
        }

        // selecciona una columna aleatoria de las válidas
        Random random = new Random();
        return columnasValidas.get(random.nextInt(columnasValidas.size()));
    }
}
