package org.iesalandalus.programacion.damas.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Random;
import java.util.List;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

    // constructor por defecto (paso 3)
    public Dama() {
        this.color = Color.BLANCO; // blanca por defecto
        this.posicion = crearPosicionInicial(this.color);
        this.esDamaEspecial = false; // por defecto no es especial
    }

    // constructor con parámetro color (paso 4)
    public Dama(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("El color no puede ser nulo");
        }
        this.color = color;
        this.posicion = crearPosicionInicial(color); // asigna posición según color
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
    private Posicion crearPosicionInicial(Color color) {
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
            case 3:
            case 7:
                columnasValidas = List.of('a', 'c', 'e', 'g');  // casillas negras filas 1, 3 y 7
                break;
            case 2:
            case 6:
            case 8:
                columnasValidas = List.of('b', 'd', 'f', 'h');  // casillas negras filas 2, 6 y 8
                break;
            default:
                throw new IllegalArgumentException("Fila fuera de rango.");
        }

        // selecciona una columna aleatoria de las válidas
        Random random = new Random();
        return columnasValidas.get(random.nextInt(columnasValidas.size()));
    }

    // metodo mover
    public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
        // validación de dirección
        if (direccion == null) {
            throw new NullPointerException("La dirección no puede ser nula.");
        }

        // validación de pasos
        if (pasos <= 0) {
            throw new IllegalArgumentException("El número de pasos debe ser mayor que 0.");
        }

        // validación de movimiento permitido para damas no especiales
        if (!esDamaEspecial) {
            if (pasos != 1) {
                throw new OperationNotSupportedException("Una dama no especial solo puede moverse 1 casilla.");
            }

            switch (color) {
                case BLANCO:
                    if (direccion != Direccion.NORESTE && direccion != Direccion.NOROESTE) {
                        throw new OperationNotSupportedException("Una dama blanca solo puede avanzar Noreste o Noroeste mientras no sea especial.");
                    }
                    break;
                case NEGRO:
                    if (direccion != Direccion.SURESTE && direccion != Direccion.SUROESTE) {
                        throw new OperationNotSupportedException("Una dama negra solo puede avanzar Sureste o Suroeste mientras no sea especial.");
                    }
                    break;
            }
        }

        // nueva posición
        int nuevaFila = posicion.getFila();
        char nuevaColumna = posicion.getColumna();

        switch (direccion) {
            case NORESTE:
                nuevaFila += pasos; // nuevaFila = nuevaFila + pasos
                nuevaColumna += pasos;
                break;
            case NOROESTE:
                nuevaFila += pasos;
                nuevaColumna -= pasos;
                break;
            case SURESTE:
                nuevaFila -= pasos;
                nuevaColumna += pasos;
                break;
            case SUROESTE:
                nuevaFila -= pasos;
                nuevaColumna -= pasos;
                break;
        }

        // límites del tablero
        if (nuevaFila < 1 || nuevaFila > 8 || nuevaColumna < 'a' || nuevaColumna > 'h') {
            throw new OperationNotSupportedException("El movimiento lleva a una posición fuera del tablero.");
        }

        // si llega al extremo del tablero, se convierte en "dama especial"
        if ((color == Color.BLANCO && nuevaFila == 8) || (color == Color.NEGRO && nuevaFila == 1)) {
            esDamaEspecial = true;
        }

        // actualizar posición si el movimiento es válido
        posicion = new Posicion(nuevaFila, nuevaColumna);
    }

    @Override
    public String toString() {
        return "Dama{" +
                "color = " + color +
                ", posicion = " + posicion +
                ", esDamaEspecial = " + esDamaEspecial +
                '}';
    }
}
