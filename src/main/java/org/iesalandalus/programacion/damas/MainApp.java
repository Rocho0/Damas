package org.iesalandalus.programacion.damas;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.damas.modelo.Color;
import org.iesalandalus.programacion.damas.modelo.Direccion;
import org.iesalandalus.programacion.damas.modelo.Dama;

public class MainApp {

    // atributo de clase de tipo Dama
    private static Dama dama;

    // metodo opcines
    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    // metodo dama por defecto
    public static void crearDamaDefecto() {
        dama = new Dama(); // crea una dama usando el constructor por defecto
        System.out.println("Dama creada por defecto: " + dama);
    }

    // metodo dama según color
    public static void crearDamaColor() {
        Color color = Consola.elegirOpcion();
        dama = new Dama(color); // según el color almacenado en "color" crea una dama
        System.out.println("Dama creada segñun el color " + color + ": " + dama);
    }

    // metodo mover la dama
    public static void mover() {
        // mostrar el menú de direcciones
        Consola.mostrarMenuDirecciones();

        // elegir la dirección con el metodo de Consola
        Direccion direccion = Consola.elegirDireccion();

        // verificar si la dama es especial y permitir la entrada de pasos
        int pasos = 1; // por defecto a 1 casilla para damas normales
        if (dama.getEsDamaEspecial()) {
            pasos = Consola.elegirPasos(); // pasos a elegir si es especial
        }

        // intentar mover la dama
        try {
            dama.mover(direccion, pasos); // Intentar mover la dama
            System.out.println("Dama movida: " + dama);
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }

    // metodo para mostrar la información de la dama
    public static void mostrarDama() {
        if (dama != null) { // comprobamos que la dama existe
            System.out.println("Color de la dama: " + dama.getColor());
            System.out.println("Posición de la dama: " + dama.getPosicion());
        } else {
            System.out.println("No se ha creado ninguna dama.");
        }
    }


}
