package org.iesalandalus.programacion.damas.modelo;

import java.util.Random;
import java.util.List;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    // constructor por defecto (paso 3)
    public Dama() {
        this.color = Color.BLANCO; // blanca por defecto
        this.posicion = posicionInicialAleatoria(color);
        this.esDamaEspecial = false; // por defecto no es especial
    }

    // constructor con parámetro color (paso 4)
    public Dama(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("El color no puede ser nulo");
        }
        this.color = color;
        this.posicion = posicionInicialAleatoria(color); // asigna posición según color
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
    private Posicion posicionInicialAleatoria(Color color) {
        Random random = new Random();
        int fila;

        // filas válidas según el color de la dama
        if (color == Color.BLANCO) {
            // Dama blanca: filas 1, 2 o 3
            fila = random.nextInt(3) + 1; // fila aleatoria entre 1 y 3
        } else {
            // Dama negra: filas 6, 7 o 8
            fila = random.nextInt(3) + 6; // fila aleatoria entre 6 y 8
        }

        // columna válida para la fila seleccionada
        char columna = columnaAleatoria(fila);

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
            case 6:
                columnasValidas = List.of('b', 'd', 'f', 'h'); // casillas negras fila 6
                break;
            case 7:
                columnasValidas = List.of('a', 'c', 'e', 'g'); // casillas negras fila 7
                break;
            case 8:
                columnasValidas = List.of('b', 'd', 'f', 'h'); // casillas negras fila 8
                break;
            default:
                throw new IllegalArgumentException("Fila fuera de rango.");
        }

        // selecciona una columna aleatoria de las válidas
        Random random = new Random();
        return columnasValidas.get(random.nextInt(columnasValidas.size()));
    }
}
