package org.iesalandalus.programacion.damas.modelo;

public class Dama {
    private Color color;
    private Posicion posicion;
    private boolean esDamaEspecial;

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

    public boolean isEsDamaEspecial() {
        return esDamaEspecial;
    }

    // setter esDamaEspecial

    public void setEsDamaEspecial(boolean esDamaEspecial) {
        this.esDamaEspecial = esDamaEspecial;
    }
}
